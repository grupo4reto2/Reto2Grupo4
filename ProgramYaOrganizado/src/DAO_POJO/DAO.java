package DAO_POJO;

import clases.*;
import utils.conexion;

public class DAO {

    public static void main(String[] args) {

        try {
            SesionDAO dao = new SesionDAO();
            dao.mostrarSesiones();   // AQUÍ se pide al DAO que ejecute
        } catch (Exception e) {
            System.out.println("Error al mostrar películas: " + e.getMessage());
        }
    }
}