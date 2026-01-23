package DAO_POJO;

import java.sql.*;
import clases.*;
import DAO_POJO.*;
import utils.conexion;
import utils.conexion;
import java.util.ArrayList;

import java.util.List;

import clases.Compra;
public class CompraDAO {




		//Listar todas las Compras

		public List<Compra> mostrarCompras() throws SQLException {

		    List<Compra> compras = new ArrayList<>();

		    String consulta1 = "SELECT IDCompra,Fecha, DNICliente, descuento, Importe FROM Compra";

		    try (Connection conn = conexion.getConnection();
		         PreparedStatement sentencia = conn.prepareStatement(consulta1);
		         ResultSet rs = sentencia.executeQuery()) {

		        System.out.println("---- CONSULTA PELÍCULAS ----");

		        while (rs.next()) {
		            int id = rs.getInt("IDCompra");
		            String fecha = rs.getString("Fecha");  
		            String dniCliente = rs.getNString("DNICliente");
		            int descuento = rs.getInt("descuento");
		            int importe = rs.getInt("Importe");
		            
		            
		            System.out.println(id + " - " + fecha + " - " + dniCliente + " - " + descuento + " - " + importe);
		        }

		    }

		    return compras;
		}
	}