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
        Scanner teclado = new Scanner(System.in);

        // --- Datos del cliente ---
        System.out.print("Introduce el DNI del cliente: ");
        String dni = teclado.next();

        System.out.print("Introduce el nombre del cliente: ");
        String nombre = teclado.next();

        System.out.print("Introduce el apellido del cliente: ");
        String apellido = teclado.next();

        System.out.print("Introduce el correo del cliente: ");
        String correo = teclado.next();

        System.out.print("Introduce la contraseña del cliente: ");
        String contraseña = teclado.next();

        Cliente cliente = new Cliente(dni, nombre, apellido, correo, contraseña);

        int idCompraGenerado = -1;
        double subtotal = 0;

        try (Connection con = conexion.getConnection()) {

            // 1️ Verificar si el cliente existe
            String sqlCheckCliente = "SELECT DNICliente FROM cliente WHERE DNICliente = ?";
            try (PreparedStatement ptecladoheck = con.prepareStatement(sqlCheckCliente)) {
                ptecladoheck.setString(1, cliente.getDni());
                ResultSet rs = ptecladoheck.executeQuery();
                if (!rs.next()) {
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

            // 2️ Datos de la compra
            System.out.print("Introduce el número de películas distintas que compra: ");
            int numPeliculasDistintas = teclado.nextInt();

            // Insertamos la compra inicialmente con Importe 0 y descuento 0
            String sqlInsertCompra = "INSERT INTO compra (DNICliente, Canal, Importe, descuento) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ptecladoompra = con.prepareStatement(sqlInsertCompra, PreparedStatement.RETURN_GENERATED_KEYS)) {
                ptecladoompra.setString(1, cliente.getDni());
                ptecladoompra.setInt(2, 0); // Canal por defecto
                ptecladoompra.setDouble(3, 0); // Importe temporal
                ptecladoompra.setDouble(4, 0); // descuento temporal
                ptecladoompra.executeUpdate();
                ResultSet rsKeys = ptecladoompra.getGeneratedKeys();
                if (rsKeys.next()) {
                    idCompraGenerado = rsKeys.getInt(1);
                }
            }

            // 3️ Agregar entradas por cada película
            String sqlInsertEntrada = "INSERT INTO entrada (cantidad, IDSesion, IDCompra) VALUES (?, ?, ?)";
            try (PreparedStatement psEntrada = con.prepareStatement(sqlInsertEntrada)) {
                for (int i = 1; i <= numPeliculasDistintas; i++) {
                    System.out.print("Introduce el ID de la sesión de la película #" + i + ": ");
                    int idSesion = teclado.nextInt();

                    System.out.print("Introduce el número de espectadores para esta película: ");
                    int espectadores = teclado.nextInt();

                    System.out.print("Introduce el precio por entrada: ");
                    double precio = teclado.nextDouble();

                    subtotal += precio * espectadores;

                    // Insertar la entrada
                    psEntrada.setInt(1, espectadores);
                    psEntrada.setInt(2, idSesion);
                    psEntrada.setInt(3, idCompraGenerado);
                    psEntrada.executeUpdate();
                }
            }

            // 4️⃣ Calcular descuento según número de películas distintas
            double descuento = 0;
            if (numPeliculasDistintas == 2) {
                descuento = 0.2;
            } else if (numPeliculasDistintas >= 3) {
                descuento = 0.3;
            }

            // 5️⃣ Actualizar la compra con subtotal y descuento final
            String sqlUpdateCompra = "UPDATE compra SET Importe = ?, descuento = ? WHERE IDCompra = ?";
            try (PreparedStatement psUpdate = con.prepareStatement(sqlUpdateCompra)) {
                psUpdate.setDouble(1, subtotal);
                psUpdate.setDouble(2, descuento);
                psUpdate.setInt(3, idCompraGenerado);
                psUpdate.executeUpdate();
            }

            System.out.println("Compra registrada correctamente con ID: " + idCompraGenerado);
            System.out.println("Subtotal: " + subtotal);
            System.out.println("descuento aplicado: " + (descuento * 100) + "%");

        } catch (SQLException e) {
            System.out.println("Error al registrar la venta: " + e.getMessage());
            e.printStackTrace();
        }

        teclado.close();
        return idCompraGenerado;
    }
}