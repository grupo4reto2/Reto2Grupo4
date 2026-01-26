package RETO2;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import clases.Sala;
import clases.Sesion;
import clases.Pelicula;
import clases.Cliente;
import clases.Compra;
import clases.Entrada;
import utils.conexion;
import java.sql.Connection;

public class APLICACION {

    public static void getConexion() {
        Connection conexxion = conexion.getConnection();
        if (conexxion != null) {
            System.out.println("Conectado correctamente");
        }
    }

    private static void mensajeBienvenida() {
        String negrita = "\033[1m";
        System.out.println("_______________________________ ");
        System.out.println(negrita + "\nBIENVENIDO A \"NOMBRE DEL CINE\" |");
        System.out.println("_______________________________|");
        System.out.println("\n Haga click para iniciar\n");
    }

    private static ArrayList<String> cargarCartelera() {
        ArrayList<String> peliculas = new ArrayList<>();
        peliculas.add("El Rey León");
        peliculas.add("No Respires");
        peliculas.add("Senderos de Gloria");
        peliculas.add("Cop Car");
        peliculas.add("¡Aterriza Como Puedas!");
        return peliculas;
    }

    private static void mostrarCartelera(ArrayList<String> peliculas) {
        System.out.println("Cartelera: \n");
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println((i + 1) + " - " + peliculas.get(i));
        }
    }

    private static ArrayList<Sala> cargarSalas() {
        ArrayList<Sala> salas = new ArrayList<>();
        salas.add(new Sala("Sala 1", "S01", 150));
        salas.add(new Sala("Sala 2", "S02", 100));
        salas.add(new Sala("Sala 3", "S03", 150));
        salas.add(new Sala("Sala 4", "S04", 100));
        salas.add(new Sala("Sala 5", "S05", 150));
        return salas;
    }

    private static ArrayList<Sesion> cargarSesiones(ArrayList<String> peliculas, ArrayList<Sala> salas) {
        ArrayList<Sesion> sesiones = new ArrayList<>();
        for (int d = 0; d < 7; d++) {
            for (int p = 0; p < peliculas.size(); p++) {
                for (int s = 1; s <= 8; s++) {
                    double precio;
                    if (s <= 3) precio = 6;
                    else if (s <= 6) precio = 9.50;
                    else precio = 12;

                    sesiones.add(new Sesion(
                        String.format("S%02d-%02d", p + 1, s),
                        LocalDateTime.of(2026, 1, 15, 10, 0).plusDays(d).plusHours(2 * (s - 1)),
                        LocalDateTime.of(2026, 1, 15, 12, 0).plusDays(d).plusHours(2 * (s - 1)),
                        salas.get(p),
                        precio,
                        peliculas.get(p)
                    ));
                }
            }
        }
        Collections.sort(sesiones, Comparator.comparing(Sesion::getFechaInicio));
        return sesiones;
    }

    private static void mostrarSesiones(ArrayList<Sesion> sesiones, String nombrePelicula, LocalDateTime fechaElegida) {
        String[] numSesiones = {
            "Primera ", "Segunda ", "Tercera ", "Cuarta ",
            "Quinta ", "Sexta ", "Séptima ", "Octava "
        };
        int contador = 0;
        DateTimeFormatter fechaF = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("es"));
        System.out.println("\nSeleccionada: " + nombrePelicula);
        System.out.println("\nHorarios: " + fechaElegida.format(fechaF) + " (" + nombrePelicula + ")\n");

        for (Sesion s : sesiones) {
            LocalDateTime f = s.getFechaInicio();
            if (s.getNomPelicula().equals(nombrePelicula)) {
                if ((f.toLocalDate().equals(fechaElegida.toLocalDate()) && f.getHour() >= 10) ||
                    (f.toLocalDate().equals(fechaElegida.toLocalDate().plusDays(1)) && f.getHour() == 0)) {
                    System.out.println(numSesiones[contador] + "sesión : " +
                        s.getFechaInicio().toLocalTime() +
                        " - " + nombrePelicula +
                        " (" + s.getSala().getNombre() + ")" +
                        " - " + s.getPrecio() + "€\n"
                    );
                    contador++;
                }
            }
        }
    }

    private static ArrayList<LocalDateTime> cargarFechas() {
        ArrayList<LocalDateTime> fechas = new ArrayList<>();
        for (int f = 0; f < 7; f++) {
            fechas.add(LocalDateTime.of(2026, 1, 15, 10, 0).plusDays(f));
        }
        return fechas;
    }

    public static void mostrarFechas(ArrayList<LocalDateTime> fechas) {
        DateTimeFormatter fechaF = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("es"));
        System.out.println("\nFechas disponibles: \n");
        for (LocalDateTime f : fechas) {
            System.out.println(" - " + f.format(fechaF));
        }
    }

    public static double resumenCompra(ArrayList<Entrada> carrito, HashSet<String> peliculasDistintas) {
        System.out.println("\n------------ RESUMEN DE LA COMPRA -------------");
        double precioTotal = 0;
        for (Entrada c : carrito) {
            peliculasDistintas.add(c.getSesion().getNomPelicula());
            DateTimeFormatter fechaF = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("es"));
            double subTotal = c.getNumPersonas() * c.getSesion().getPrecio();
            precioTotal += subTotal;

            System.out.println("\n\nPelícula seleccionada: " + c.getSesion().getNomPelicula() +
                "\nFecha: " + c.getSesion().getFechaInicio().toLocalDate().format(fechaF) +
                "\nHora: " + c.getSesion().getFechaInicio().toLocalTime() +
                "\nSala: " + c.getSesion().getSala().getIdSala() +
                "\nNúmero de entradas: " + c.getNumPersonas() +
                "\nPrecio total de la(s) entrada(s) ---> " + subTotal + " € "
            );
        }
        System.out.println("\nPRECIO TOTAL (SIN DESCUENTOS APLICADOS): " + precioTotal + " €");
        return precioTotal;
    }

    public static double calcularDescuento(double precioTotal, int numPelis) {
        if (numPelis == 2) {
            System.out.println("\nDescuento del 20% aplicado\n");
            return precioTotal * 0.80;
        } else if (numPelis >= 3) {
            System.out.println("\nDescuento del 30% aplicado\n");
            return precioTotal * 0.70;
        }
        return precioTotal;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        mensajeBienvenida();
        teclado.nextLine();

        ArrayList<String> peliculas = cargarCartelera();
        ArrayList<LocalDateTime> fechas = cargarFechas();
        ArrayList<Sala> salas = cargarSalas();
        ArrayList<Sesion> sesiones = cargarSesiones(peliculas, salas);
        ArrayList<Entrada> carrito = new ArrayList<>();
        ArrayList<Compra> carritoFinal = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        boolean seguirComprando = true;
        while (seguirComprando) {
            mostrarCartelera(peliculas);
            System.out.println("\nElige una pelicula (1-" + peliculas.size() + ")\n");
            int opcionPelicula = teclado.nextInt();
            teclado.nextLine();

            if (opcionPelicula == 0) {
                seguirComprando = false;
            }

            if (seguirComprando) {
                String peliculaElegida = peliculas.get(opcionPelicula - 1);
                boolean seguirConPelicula = true;
                while (seguirConPelicula) {
                    mostrarFechas(fechas);
                    System.out.println("\nElige el día (1-" + fechas.size() + ")\n");
                    int opcionFecha = teclado.nextInt();
                    teclado.nextLine();
                    LocalDateTime fechaElegida = fechas.get(opcionFecha - 1);

                    mostrarSesiones(sesiones, peliculaElegida, fechaElegida);

                    System.out.println("\nElige una sesion: (1-8) ");
                    int opcionSesion = teclado.nextInt();
                    teclado.nextLine();

                    ArrayList<Sesion> sesionesFiltradas = new ArrayList<>();
                    for (Sesion s : sesiones) {
                        LocalDateTime f = s.getFechaInicio();
                        if (s.getNomPelicula().equals(peliculaElegida) &&
                            ((f.toLocalDate().equals(fechaElegida.toLocalDate()) && f.getHour() >= 10) ||
                             (f.toLocalDate().equals(fechaElegida.toLocalDate().plusDays(1)) && f.getHour() == 0))) {
                            sesionesFiltradas.add(s);
                        }
                    }

                    Sesion sesionElegida = sesionesFiltradas.get(opcionSesion - 1);

                    System.out.println("\nNúmero de personas:\n ");
                    int numPersonas = teclado.nextInt();
                    teclado.nextLine();

                    int idEntrada = 1;
                    Entrada entrada = new Entrada(idEntrada, sesionElegida, numPersonas, null);
                    carrito.add(entrada);
                    System.out.println("\nSe ha(n) añadido " + numPersonas + " entrada(s) para " + peliculaElegida + " a tu carrito\n");
                    idEntrada++;

                    System.out.println("\nSeñala una de las 3 opciones: \n");
                    System.out.println("1. Añadir más sesiones");
                    System.out.println("2. Añadir más películas");
                    System.out.println("3. Finalizar Compra");

                    int opcionCompra = teclado.nextInt();
                    teclado.nextLine();

                    switch (opcionCompra) {
                        case 1 -> seguirConPelicula = true;
                        case 2 -> seguirConPelicula = false;
                        case 3 -> {
                            seguirConPelicula = false;
                            seguirComprando = false;
                        }
                    }
                }
            }
        }

        HashSet<String> peliculasDistintas = new HashSet<>();
        double subTotal = resumenCompra(carrito, peliculasDistintas);
        double precioFinal = calcularDescuento(subTotal, peliculasDistintas.size());
        System.out.printf("\n PRECIO FINAL : %.2f €\n", precioFinal);
    }
}