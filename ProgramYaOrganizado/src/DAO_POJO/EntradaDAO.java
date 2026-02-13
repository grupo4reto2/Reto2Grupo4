package DAO_POJO;

import utils.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntradaDAO {

    // Mostrar descuentos de la última compra y calcular actualización
    public void mostrarDescuentos() throws SQLException {

    	String sqlUltimaCompra = "SELECT IDCompra FROM Compra ORDER BY IDCompra DESC LIMIT 1";
    	int ultimaCompraId = 0;

    	try (Connection conn = conexion.getConnection();
    	     PreparedStatement psUltima = conn.prepareStatement(sqlUltimaCompra);
    	     ResultSet rsUltima = psUltima.executeQuery()) {

    	    if (rsUltima.next()) {
    	        ultimaCompraId = rsUltima.getInt("IDCompra");
    	        System.out.println("Última compra ID: " + ultimaCompraId);
    	    }
    	}

    	// 2️⃣ Consultar entradas de esa compra
    	String consulta = "SELECT  COUNT(DISTINCT S.IDPelicula) AS peliculasDistintas,\r\n"
    			+ "        SUM(E.Cantidad * S.Precio) AS importeTotal\r\n"
    			+ "FROM    Entrada E\r\n"
    			+ "JOIN    Sesion S ON E.IDSesion = S.IDSesion\r\n"
    			+ "WHERE   E.IDCompra = ?;"
    			+ "";

    	String sqlUpdateDescuento = "UPDATE Compra SET descuento = ? WHERE IDCompra = ?";

    	try (Connection conn = conexion.getConnection();
    	     PreparedStatement psSelect = conn.prepareStatement(consulta)) {

    	    psSelect.setInt(1, ultimaCompraId);
    	    ResultSet rs = psSelect.executeQuery();

    	    if (rs.next()) {
    	        int peliculas = rs.getInt("peliculasDistintas");
    	        double importe = rs.getDouble("importeTotal");

    	        System.out.println("Películas distintas: " + peliculas);
    	        System.out.println("Importe total: " + importe);

    	        // Calcular descuento
    	        double descuento = 0;
    	        if (peliculas == 2) descuento = 0.2;
    	        else if (peliculas > 2) descuento = 0.3;

    	        // Actualizar la compra
    	        try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdateDescuento)) {
    	            psUpdate.setDouble(1, descuento);
    	            psUpdate.setInt(2, ultimaCompraId);
    	            psUpdate.executeUpdate();
    	            System.out.println("Descuento actualizado correctamente para la compra " + ultimaCompraId);
    	        }
    	    }

    	} catch (SQLException ex) {
    	    System.out.println("Error en mostrarDescuentos: " + ex.getMessage());
    	    throw ex;
    	}
    	
    }
}