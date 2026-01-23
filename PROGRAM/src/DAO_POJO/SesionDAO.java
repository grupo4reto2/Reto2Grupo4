package clases;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;
public class SesionDAO {




		//Listar todas las Sesions

		public List<Sesion> mostrarSesiones() throws SQLException {

		    List<Sesion> Sesions = new ArrayList<>();

		    String consulta1 = "SELECT * FROM Sesion";

		    try (Connection conn = Conexion.getConnection();
		         PreparedStatement sentencia = conn.prepareStatement(consulta1);
		         ResultSet rs = sentencia.executeQuery()) {

		        System.out.println("---- CONSULTA PELÍCULAS ----");

		        while (rs.next()) {
		            int id = rs.getInt("IDSesion");
		            String codSesion = rs.getString("CodigoSesion");  
		            String dniCliente = rs.getString("FecHoraIni");
		            String descuento = rs.getString("FecHoraFin");
		            double importe = rs.getDouble("Precio");
		            int IDSala = rs.getInt("IDSala");
		            int IDPelicula = rs.getInt("IDPelicula");
		            
		            
		            System.out.println(id + " - " + codSesion + " - " + dniCliente + " - " + descuento + " - " + importe + " - " + IDSala + " - " + IDPelicula);
		        }

		    }

		    return Sesions;
		}
	}