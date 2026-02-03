package DAO_POJO;

import clases.*;
import DAO_POJO.*;
import utils.conexion;
import utils.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {

    public void mostrarClientes() throws SQLException {

        String consulta1 = "select * from Cliente";

        try (Connection conn = conexion.getConnection();
		         PreparedStatement sentencia1 = conn.prepareStatement(consulta1);
		         ResultSet resultado1 = sentencia1.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw ex;
        }
    }
    
    
    
    public Cliente Login(String nombre, String contraseña) throws SQLException {
    	
    	Cliente cliente = null;
    	
    	String sql = "Select * from Cliente where Nombre = ? and contraseña = ?";
    	
    	try (Connection conn = conexion.getConnection();
    			PreparedStatement ps = conn.prepareStatement(sql)) {
    		
    		
    		ps.setString(1, nombre);
    		ps.setString(2, contraseña);
    		
    		
    		try (ResultSet rs = ps.executeQuery()) {
    			
    			if (rs.next() ) {
    				
    				cliente = new Cliente (
    						
    						rs.getString("DNICliente"),
    						rs.getString("Nombre"),
    						rs.getString("Apellido"),
    						rs.getString("Correo"),
    						rs.getString("Contraseña")
    						
    						);
    						
    				
    			}
    			
    		}
    		
    		
    	}
		return cliente;
		
		
    }
		
		 public Cliente login(String nombre, String contraseña) throws SQLException {
		    	
		    	Cliente cliente = null;
		    	
		    	String sql = "Select * from Cliente where nombre = ? and contraseña = ? ";
		    	
		    	try (Connection conn = conexion.getConnection();
		    			PreparedStatement ps = conn.prepareStatement(sql)) {
		    		
		    		ps.setString(1, nombre);
		    		ps.setString(2, contraseña);
		    		
		    		
		    		try (ResultSet rs = ps.executeQuery()) {
		    			
		    			if (rs.next()) {
		    				
		    				cliente = new Cliente (
		    						
		    						rs.getString("DNICliente"),
		    						rs.getString("Nombre"),
		    						rs.getString("Apellido"),
		    						rs.getString("Correo"),
		    						rs.getString("Contraseña")
		    						
		    						);
		    				
		    			}
		    			
		    		}
		    		
		    	}
				return cliente;
		
    	
    }
    
    
    
    
}
