package utils;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {

	       private static Connection conn = null;

	       public static Connection getConnection() {
	           try {
	        	   String url = "jdbc:mysql://10.5.6.136:3309/reto2_g4_true";
		           String user = "usuario";
		           String password = "Elorrieta00-";

	               conn = DriverManager.getConnection(url, user, password);
	               return conn;

	                } catch (SQLException e) {
	                    System.out.println("Error al conectar: " + e.getMessage());
	                    return null;
	                }
	            }

	            public static void cerrarConexion() {
	                try {
	                    if (conn != null && !conn.isClosed()) {
	                        conn.close();
	                        System.out.println("Conexión cerrada correctamente");
	                    }
	                } catch (SQLException e) {
	                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
	                }
	            }
	            
	        }
