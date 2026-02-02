package DAO_POJO;

import clases.*;
import DAO_POJO.*;
import utils.conexion;
import utils.conexion;


import java.sql.*;
import java.util.ArrayList;

import clases.Sala;

public class salaDAO {

	public ArrayList<Sala> mostrarSalas() throws SQLException {



	    ArrayList<Sala> salas = new ArrayList<>();



	    String sql = "Select * from sala";



	    try (Connection conn = conexion.getConnection();

	         PreparedStatement sentencia = conn.prepareStatement(sql);

	         ResultSet rs = sentencia.executeQuery()) {


	        while (rs.next()) {

	            int idSala = rs.getInt("IDSala");
	            String nomSala = rs.getString("NomSala");
	            int aforo = rs.getInt("Aforo");
	          


	            salas.add(new Sala(idSala, nomSala, aforo));
	            
	        }
	    }
		return salas;
	}	
}