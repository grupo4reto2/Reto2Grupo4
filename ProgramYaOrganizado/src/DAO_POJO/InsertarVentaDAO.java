package DAO_POJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import clases.Cliente;
import clases.Entrada;
import utils.conexion;

public class InsertarVentaDAO {

    public int insertarVenta(Cliente cliente, List<Entrada> entradas) {
        
        int idCompraGenerado = -1;
        double subtotal = 0;
       

        try (Connection con = conexion.getConnection()) {

            // 1️ Verificar si el cliente existe
            String sqlCheckCliente = "SELECT DNICliente FROM cliente WHERE DNICliente = ? AND Nombre = ? AND Contraseña = ?";
            try (PreparedStatement sentencia = con.prepareStatement(sqlCheckCliente)) {
            			sentencia.setString(1, cliente.getDni());
                        sentencia.setString(2, cliente.getNombre());
                        sentencia.setString(3, cliente.getContrasena());
                        
                        ResultSet rs = sentencia.executeQuery(); 
                    
                 if (!rs.next()) {
                	System.out.println("Cliente  no encontrado o contraseña incorrecta");
                	return -1;
                } else {
                    System.out.println("Cliente verificado correctamente");
                }
            }
        
            //2 Insertamos la compra inicialmente con Importe 0 y descuento 0
            String sqlInsertCompra = "INSERT INTO compra (DNICliente, Canal, Importe, descuento) VALUES (?, ?, ?, ?)";
            try (PreparedStatement psCompra = con.prepareStatement(sqlInsertCompra, PreparedStatement.RETURN_GENERATED_KEYS)) {
                psCompra.setString(1, cliente.getDni());
                psCompra.setInt(2, 0); // Canal por defecto
                psCompra.setDouble(3, 0); // Importe temporal
                psCompra.setDouble(4, 0); // descuento temporal
                psCompra.executeUpdate();
                ResultSet rsKeys = psCompra.getGeneratedKeys();
                if (rsKeys.next()) {
                    idCompraGenerado = rsKeys.getInt(1);
                }
            }

            // 3️ Agregar entradas por cada película
            String sqlInsertEntrada = "INSERT INTO entrada (cantidad, IDSesion, IDCompra) VALUES (?, ?, ?)";
            try (PreparedStatement psEntrada = con.prepareStatement(sqlInsertEntrada)) {
                for (Entrada e : entradas) {
                	subtotal += e.getcantidad()*e.getSesion().getPrecio();
                	psEntrada.setInt(1, e.getcantidad());
                	psEntrada.setInt(2, e.getSesion().getIdSesion());
                	psEntrada.setInt(3, idCompraGenerado);
                }
            }

            // 4️ Contar peliculas distintas
            
            int numPeliculasDistintas = 0;
            for (int i = 0;i < entradas.size(); i++) {
            	int idActual = entradas.get(i).getSesion().getIDPelicula().getIdPelicula();
            	boolean yaContada = false;
            	
            for (int j = 0; j < i; j++) {
            	int idAnterior = entradas.get(j).getSesion().getIDPelicula().getIdPelicula();
            	if(idActual == idAnterior) {
            		yaContada = true;
            		
            	}
            }
            
            if(!yaContada) {
            	numPeliculasDistintas++;
            }
         }
            
             
            // 5 Calcular descuento
            double descuento = 1.0;
            double descuentoRaw = 0;
            if (numPeliculasDistintas == 2) {
                descuento = 0.80;
                descuentoRaw = 0.2;
            } else if (numPeliculasDistintas >= 3) {
                descuento = 0.70;
                descuentoRaw = 0.3;
            }
            
            

            // 6 Actualizar la compra con subtotal y descuento final
            String sqlUpdateCompra = "UPDATE compra SET Importe = ?, descuento = ? WHERE IDCompra = ?";
            try (PreparedStatement psUpdate = con.prepareStatement(sqlUpdateCompra)) {
                psUpdate.setDouble(1, subtotal);
                psUpdate.setDouble(2, descuento);
                psUpdate.setInt(3, idCompraGenerado);
                psUpdate.executeUpdate();
            }

            System.out.println("Compra registrada correctamente con ID: " + idCompraGenerado);
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Descuento: " + (descuentoRaw * 100) + "%");
            System.out.println("Coste total (Con descuento aplicado): " + (subtotal * descuento));

            
        } catch (SQLException e) {
            System.out.println("Error al registrar la venta: " + e.getMessage());
            e.printStackTrace();
        }

        return idCompraGenerado;
    }
}