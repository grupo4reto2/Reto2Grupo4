package DAO_POJO;


import clases.*;
import DAO_POJO.*;
import utils.conexion;
import utils.conexion;


import java.sql.*;

import java.util.ArrayList;

import java.util.List;

import clases.Pelicula;

public class PeliculaDAO {

	//Listar todas las Peliculas

	public List<Pelicula> mostrarPelis() throws SQLException {

	    List<Pelicula> peliculas = new ArrayList<>();

	    String consulta1 = "Select P.NomPelicula, P.IDPelicula, SA.NomSala, SA.IDSala, S.IDSesion, S.FecHoraIni\r\n"
	    		+ "From Pelicula P join Sesion S on P.IDPelicula = S.IDPelicula \r\n"
	    		+ "left join Sala SA on S.IDSala = SA.IDSala\r\n"
	    		+ "where FecHoraIni = '2026-01-15 10:00:00'\r\n"
	    		+ "limit 4;";
	    
	    String consulta2 = "select P.IDPelicula, P.NomPelicula, S.FecHoraIni, S.IDSesion, SA.NomSala, S.Precio\r\n"
	    		+ "From Pelicula P join Sesion S on P.IDPelicula = S.IDPelicula\r\n"
	    		+ "join Sala SA on SA.IDSala = S.IDSala;";

	    try (Connection conn = conexion.getConnection();
	         PreparedStatement sentencia = conn.prepareStatement(consulta1);
	         ResultSet rs = sentencia.executeQuery()) {

	        System.out.println("---- CONSULTA PELÍCULAS ----");

	        while (rs.next()) {
	        	int id = rs.getInt("IDPelicula");
	        	String nomPeli = rs.getString("NomPelicula");  
	            String nomSala = rs.getString("NomSala"); 
	            int idSala = rs.getInt("IDSala");
	            int idSesion = rs.getInt("IDSesion");
	            String FecHoraIni = rs.getString("FecHoraIni");
	            
	            System.out.println(id + " - " + nomPeli + " - " + nomSala + " - " + idSala + " - " + idSesion + " - " + FecHoraIni );
	        	}

	    	}
	    
	    try (Connection conn = conexion.getConnection();
		         PreparedStatement sentencia = conn.prepareStatement(consulta2);
		         ResultSet rs = sentencia.executeQuery()) {

		        System.out.println("---- CONSULTA PELÍCULAS ----");

		        while (rs.next()) {
		        	int id = rs.getInt("IDPelicula");
		        	String nomPeli = rs.getString("NomPelicula");  
		        	String FecHoraIni = rs.getString("FecHoraIni");
		        	int idSesion = rs.getInt("IDSesion");
		            String nomSala = rs.getString("NomSala"); 
		            double precio = rs.getDouble("Precio");
		            
		            System.out.println(id + " - " + nomPeli + " - " + FecHoraIni + " - " +idSesion +" - "  +nomSala + " - " + precio );
		        	}

		    	}
	    return peliculas;
	    
	}
	
	
	
	
		public ArrayList<Pelicula> mostrarCartelera() throws SQLException {
				
				ArrayList<Pelicula> peliculas = new ArrayList<>();
				
				String sql = "Select IDPelicula, NomPelicula, Duracion, IDGenero FROM pelicula";
				
				try (Connection conn = conexion.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery()) {
					
					
					while (rs.next()) {
						
						int id = rs.getInt("IDPelicula");
						String nombre = rs.getString("NomPelicula");
						int duracion = rs.getInt("Duracion");
						int idGenero = rs.getInt("IDGenero");
						
						Pelicula pelis = new Pelicula(id, nombre, duracion, new Genero(idGenero, null), null);
					
						peliculas.add(pelis);
					}
					
				}
				
				return peliculas;
			
			
			
			
			
		}
		
		
}