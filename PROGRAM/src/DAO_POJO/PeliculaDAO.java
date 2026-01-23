package clases;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

public class PeliculaDAO {

	//Listar todas las Peliculas

	public List<Pelicula> mostrarPelis() throws SQLException {

	    List<Pelicula> peliculas = new ArrayList<>();

	    String consulta1 = "SELECT IDPelicula, NomPelicula, Portada FROM Pelicula";

	    try (Connection conn = Conexion.getConnection();
	         PreparedStatement sentencia = conn.prepareStatement(consulta1);
	         ResultSet rs = sentencia.executeQuery()) {

	        System.out.println("---- CONSULTA PELÍCULAS ----");

	        while (rs.next()) {
	            int id = rs.getInt("IDPelicula");
	            String nombre = rs.getString("NomPelicula");  
	            String portada = rs.getNString("Portada");
	            
	            System.out.println(id + " - " + nombre + " - " + portada );
	        }

	    }

	    return peliculas;
	}
}