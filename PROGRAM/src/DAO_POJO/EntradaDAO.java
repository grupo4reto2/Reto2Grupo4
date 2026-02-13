package DAO_POJO;

import clases.*;
import DAO_POJO.*;
import utils.conexion;
import utils.conexion;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

import clases.Entrada;
public class EntradaDAO {




		//Listar todas las Entradas

		public List<Entrada> mostrarEntradas() throws SQLException {

		    List<Entrada> Entradas = new ArrayList<>();

		    String consulta1 = "SELECT IDEntrada,Cantidad, IDSesion, IDCompra, FecHoraIni FROM Entrada";

		    try (Connection conn = conexion.getConnection();
		         PreparedStatement sentencia = conn.prepareStatement(consulta1);
		         ResultSet rs = sentencia.executeQuery()) {

		        System.out.println("---- CONSULTA PELÍCULAS ----");

		        while (rs.next()) {
		            int id = rs.getInt("IDEntrada");
		            String fecha = rs.getString("Cantidad");  
		            int dniCliente = rs.getInt("IDSesion");
		            int descuento = rs.getInt("IDCompra");
		            String importe = rs.getString("FecHoraIni");
		            
		            
		            System.out.println(id + " - " + fecha + " - " + dniCliente + " - " + descuento + " - " + importe);
		        }

		    }

		    return Entradas;
		}
	}