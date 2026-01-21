package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {

	
<<<<<<< HEAD
	private static String BBDD = "reto2_g4";
=======
	private static String BBDD = "reto2_g4-true";
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	private static String login = "jhon";
	private static String passwd = "Elorrieta00-";
	private static String url = "jdbc:mysql://10.5.6.136:3309/" + BBDD;
	
	
	
	private static Connection conexion;
	
	
	
	  public static Connection geTConnexxionn() {
		  
	        if (conexion == null) {
	        	

	            try {
	            	
	                Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8+
	                conexion = DriverManager.getConnection(url, login, passwd);
	               
	                System.out.println("Conexión a la base de datos realizada. \nBase de datos: " + BBDD);
	            
	            } catch (SQLException e) {
	               
	            	System.err.println("Lo sentimos mucho, ha habido un error con la conexión:");
	                e.printStackTrace();
	          
	            } catch (ClassNotFoundException e) {

	            	System.err.println("Driver no enconntrado:");
	                e.printStackTrace();
	           
	            }
	       
	        }
	      
	        
	        
	        return conexion;
	    }

	    //CON ESTO CERRAMOS LA CONEXXIONN
	  
	    public static void cerrarConexion() {
	    	
	        try {
	        	
	            if (conexion != null && !conexion.isClosed()) {
	                conexion.close();
	                System.out.println("Conexión cerrada.");
	            }
	            
	       
	        } catch (SQLException e) {
	        	
	            e.printStackTrace();
	       
	        }
	    
	    }
	
}
