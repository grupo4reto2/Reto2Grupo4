package DAO_POJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import clases.Cliente;
import utils.conexion;

public class InsertarVentaDAO {

    public int insertarVenta() {
        Scanner sc = new Scanner(System.in);

        // --- Datos de la sesión y venta ---
        System.out.print("Introduce el ID de la sesión: ");
        int idSesion = sc.nextInt();

        System.out.print("Introduce el número de espectadores: ");
        int espectadores = sc.nextInt();

        // --- Datos del cliente ---
        System.out.print("Introduce el DNI del cliente: ");
        String dni = sc.next();

        System.out.print("Introduce el nombre del cliente: ");
        String nombre = sc.next();

        System.out.print("Introduce el apellido del cliente: ");
        String apellido = sc.next();
        
        System.out.print("Introduce el correo del cliente: ");
        String correo = sc.next();
        
        System.out.print("Introduce la contraseña del cliente: ");
        String contraseña = sc.next();

        Cliente cliente = new Cliente(dni, nombre, apellido, correo, contraseña);

        // --- Datos de la compra ---
        System.out.print("Introduce el canal de venta: ");
        int canalVenta = sc.nextInt();

        System.out.print("Introduce el importe: ");
        double importe = sc.nextDouble();
        
        int idCompraGenerado = -1;

        try (Connection con = conexion.getConnection()) {

            // 1️⃣ Verificar si el cliente existe
            String sqlCheckCliente = "SELECT DNICliente FROM cliente WHERE DNICliente = ?";
            try (PreparedStatement psCheck = con.prepareStatement(sqlCheckCliente)) {
                psCheck.setString(1, cliente.getDni());
                ResultSet rs = psCheck.executeQuery();
                if (!rs.next()) {
                    // Insertar cliente si no existe
                    String sqlInsertCliente = "INSERT INTO cliente (DNICliente, Nombre, Apellido, Correo, Contrasena) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement psInsertCliente = con.prepareStatement(sqlInsertCliente)) {
                        psInsertCliente.setString(1, cliente.getDni());
                        psInsertCliente.setString(2, cliente.getNombre());
                        psInsertCliente.setString(3, cliente.getApellido());
                        psInsertCliente.setString(4, cliente.getCorreo());
                        psInsertCliente.setString(5, cliente.getContrasena());
                        psInsertCliente.executeUpdate();
                        System.out.println("Cliente insertado correctamente.");
                    }
                } else {
                    System.out.println("Cliente ya existe.");
                }
            }

            // 2️⃣ Insertar la compra
            String sqlInsertCompra = "INSERT INTO compra (DNICliente, canal, Importe, descuento) VALUES (?, ?, ?, ?)";
            try (PreparedStatement psCompra = con.prepareStatement(sqlInsertCompra, PreparedStatement.RETURN_GENERATED_KEYS)) {
                psCompra.setString(1, cliente.getDni());       
                psCompra.setInt(2, canalVenta);
                psCompra.setDouble(3, importe);
                psCompra.setDouble(4, 0);
                psCompra.executeUpdate();

                ResultSet rsKeys = psCompra.getGeneratedKeys();
                if (rsKeys.next()) {
                    idCompraGenerado = rsKeys.getInt(1);
                }

                System.out.println("Compra registrada correctamente con ID: " + idCompraGenerado);
            }

            // 3️⃣ Insertar la entrada
            String sqlInsertEntrada = "INSERT INTO entrada (cantidad, IDSesion, IDCompra) VALUES (?, ?, ?)";
            try (PreparedStatement psEntrada = con.prepareStatement(sqlInsertEntrada)) {
                psEntrada.setInt(1, espectadores);
                psEntrada.setInt(2, idSesion);
                psEntrada.setInt(3, idCompraGenerado);

                psEntrada.executeUpdate();
                System.out.println("Entrada registrada correctamente.");
            }

            // 4️⃣ Calcular y actualizar el descuento según canal y número de espectadores
            double descuento;

            if (canalVenta == 1) {
                if (espectadores == 1) {
                    descuento = 0;
                } else if (espectadores == 2) {
                    descuento = 0.2;
                } else {
                    descuento = 0.3;
                }
            } else {
                descuento = 0;
            }

            String sqlUpdateDescuento =
                    "UPDATE compra SET descuento = ? WHERE IDCompra = ?";

            try (PreparedStatement psUpdate = con.prepareStatement(sqlUpdateDescuento)) {
                psUpdate.setDouble(1, descuento);
                psUpdate.setInt(2, idCompraGenerado);
                psUpdate.executeUpdate();
                System.out.println("Descuento actualizado correctamente: " + (descuento * 100) + "%");
            }

        } catch (SQLException e) {
            System.out.println("Error al registrar la venta: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
        return idCompraGenerado;
    }
}