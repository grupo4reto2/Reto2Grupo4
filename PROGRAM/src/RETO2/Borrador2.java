package RETO2;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Borrador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://10.5.6.136:3309/reto2_g4_true";
		String user = "ander";
		String pass = "Elorrieta00-";
		
		String Consulta1 = "SELECT p.IDPelicula,p.NomPelicula, SUM(e.NumPers * s.Precio) AS Recaudacion\r\n"
				+ "FROM pelicula p JOIN sesion s ON p.IDPelicula = s.IDPelicula\r\n"
				+ "JOIN entrada e ON s.IDSesion = e.IDSesion AND s.FecHoraIni = e.FecHoraIni\r\n"
				+ "GROUP BY p.IDPelicula, p.NomPelicula\r\n"
				+ "having Recaudacion > 500;";

		Connection conn = null;
		Statement  sentencia = null;
		ResultSet  resultado1 = null;
		
	
		try {
			// 1 - Conexión
			conn = DriverManager.getConnection(url, user, pass);
			// 2 - Preparar la sentencia
			sentencia = conn.createStatement();
			// 3 - Ejecutarlo
			resultado1 = sentencia.executeQuery(Consulta1);
			
			// 4 - Tratar los datos
			while(resultado1.next()) {
				int idPelicula = resultado1.getInt("IDPelicula");
				String nomPelicula = resultado1.getString("NomPelicula");
				double recaudacion = resultado1.getDouble("Recaudacion");
				
			    System.out.println("ID de Pelicula: " + idPelicula);
                System.out.println("Nombre de Pelicula: " + nomPelicula);
                System.out.println("Recaudacion: " + recaudacion);
                System.out.println("----------------------------");
			}
			
						//5 - Cerrar en orden inverso
			conn.close();
		} catch (SQLException exSql) {
				System.out.println(exSql.getMessage());
			}
		}
	}


