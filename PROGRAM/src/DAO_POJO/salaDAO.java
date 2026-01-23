package clases;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class salaDAO {

	public List<Sala> mostrarSalas() throws SQLException {



	    List<Sala> Salas = new ArrayList<>();



	    String consulta1 = "SELECT IDSala, NomSala, Aforo FROM Sala";



	    try (Connection conn = Conexion.getConnection();

	         PreparedStatement sentencia = conn.prepareStatement(consulta1);

	         ResultSet rs = sentencia.executeQuery()) {



	        System.out.println("---- CONSULTA Salas ----");



	        while (rs.next()) {

	            int id = rs.getInt("IDSala");

	            String nomSala = rs.getString("NomSala");
	            String aforo = rs.getString("Aforo");
	          


	            System.out.println(id + " - " + nomSala +  " - " + aforo + " - " );
	            
	        }
	    }
		return Salas;
	}	
}