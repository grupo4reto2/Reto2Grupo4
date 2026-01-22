package clases;

import java.sql.*;

public class Conexion {



	private static String url = "jdbc:mysql://10.5.6.136:3309/reto2_g4_true";

	private static String user = "usuario";

	private static String password = "Elorrieta00-";



	private Conexion() {}

	

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url, user, password);

	}

}