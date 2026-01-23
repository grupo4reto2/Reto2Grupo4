package DAO_POJO;


import clases.*;
import DAO_POJO.*;
import utils.conexion;
import utils.conexion;


import java.sql.*;

import java.util.ArrayList;

import java.util.List;

import clases.Genero;
public class GeneroDAO {




		//Listar todas las Generos

		public List<Genero> mostrarGeneros() throws SQLException {

		    List<Genero> Generos = new ArrayList<>();

		    String consulta1 = "SELECT IDGenero,NomGenero FROM Genero";

		    try (Connection conn = conexion.getConnection();
		         PreparedStatement sentencia = conn.prepareStatement(consulta1);
		         ResultSet rs = sentencia.executeQuery()) {

		        System.out.println("---- CONSULTA PELÍCULAS ----");

		        while (rs.next()) {
		            int id = rs.getInt("IDGenero");
		            String NomGenero = rs.getString("NomGenero");  
		            
		            
		            
		            System.out.println(id + " - " + NomGenero);
		        }

		    }

		    return Generos;
		}
	}
