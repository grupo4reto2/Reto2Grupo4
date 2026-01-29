package DAO_POJO;

import java.util.Scanner;

public class EjecucionVentasDAO {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("=== Registro de venta de entradas ===");

        InsertarVentaDAO ventaDAO = new InsertarVentaDAO();

        // Insertar la venta y obtener el ID de la compra generada
        int idCompra = ventaDAO.insertarVenta();

        if (idCompra != -1) {
            System.out.println("La venta se ha registrado correctamente con ID de compra: " + idCompra);
         
        } else {
            System.out.println("No se pudo registrar la venta.");
        }

        teclado.close();
    }
}