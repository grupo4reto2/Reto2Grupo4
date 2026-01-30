package DAO_POJO;


import clases.*;
import DAO_POJO.*;
import utils.conexion;
import utils.conexion;


import java.sql.*;

import java.util.ArrayList;

import java.util.List;

import clases.Sesion;
public class SesionDAO {
	
	public static void main(String[] args) {

		//Listar todas las Sesiones

	  try {
          PeliculaDAO dao = new PeliculaDAO();
          dao.mostrarPelis();   // AQUÍ se pide al DAO que ejecute
      } catch (Exception e) {
          System.out.println("Error al mostrar películas: " + e.getMessage());
      }
  }
}