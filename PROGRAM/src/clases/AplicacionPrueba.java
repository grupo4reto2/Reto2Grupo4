package clases;

public class AplicacionPrueba {

    public static void main(String[] args) {

        try {
            SesionDAO dao = new SesionDAO();
            dao.mostrarSesiones();   // AQUÍ se pide al DAO que ejecute
        } catch (Exception e) {
            System.out.println("Error al mostrar películas: " + e.getMessage());
        }
    }
}