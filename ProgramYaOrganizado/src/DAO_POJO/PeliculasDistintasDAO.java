package DAO_POJO;
import DAO_POJO.*;
import utils.conexion;
public class PeliculasDistintasDAO {

	public static void main(String[] args) {

		//Listar todas las Sesiones

	  try {
          EntradaDAO dao = new EntradaDAO();
          dao.mostrarDescuentos();   // AQUÍ se pide al DAO que ejecute
      } catch (Exception e) {
          System.out.println("Error al mostrar entradas: " + e.getMessage());
      }
  }
}