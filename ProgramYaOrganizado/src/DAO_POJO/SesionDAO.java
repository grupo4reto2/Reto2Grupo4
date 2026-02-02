package DAO_POJO;


import clases.*;
import DAO_POJO.*;
import utils.conexion;
import utils.conexion;

import java.time.LocalDateTime;


import java.sql.*;

import java.util.ArrayList;

import java.util.List;
public class SesionDAO {
	
	public static void main(String[] args) {

		//Listar todas las Sesiones

	  try {
          PeliculaDAO dao = new PeliculaDAO();
          dao.mostrarPelis();   // AQUÍ se pide al DAO que ejecute
      } catch (Exception e) {
          System.out.println("Error al mostrar películas: " + e.getMessage());
      }
  }
	
	
	
	public ArrayList<Sesion> mostrarSesiones (ArrayList<Pelicula> peliculas, ArrayList<Sala> salas) throws SQLException {
		
		ArrayList<Sesion> sesiones = new ArrayList<>();
		
		String sql = "Select * from Sesion";
		
	try (Connection conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()) {
		
		
		while (rs.next()) {
			
			int idSesion = rs.getInt("IDSesion");
			LocalDateTime fecha = rs.getTimestamp("fechaHora").toLocalDateTime();
			double precio = rs.getDouble("Precio");
			int idSala = rs.getInt("IDSala");
			int idPelicula = rs.getInt("IDPelicula");
			
			
			/*private int idSesion;
	private String codSesion;
	private LocalDateTime fecHoraIni;
	private LocalDateTime fecHoraFin;
	private double precio;
	private Sala idSala;
	private Pelicula idPelicula;*/
			
			Pelicula peliBorrador = null;
			Sala salaBorrador = null;
			
			for (Pelicula p: peliculas) {
				
				if (p.getIdPelicula() == idPelicula) {
					
					peliBorrador = p;
				}
				
				
				for (Sala s : salas) {
					
					if (s.getIdSala() == idSala) {
						
						salaBorrador = s;
						
					}
					
				}
				
				if (peliBorrador != null && salaBorrador != null) {
					
					sesiones.add(new Sesion(idSesion, "S" + idSesion, fecha, fecha.plusHours(2), precio, salaBorrador, peliBorrador));
					
				}
				
				
			}
					
			
		}
		
	}
	
	return sesiones;
		
	}
	
	
}