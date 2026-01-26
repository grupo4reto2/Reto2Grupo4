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

public class actualBorrador {

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

    private static ArrayList<Pelicula> cargarCartelera() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula(1, "El Rey León", 120, null, ""));
        peliculas.add(new Pelicula(2, "No Respires", 90, null, ""));
        peliculas.add(new Pelicula(3, "Senderos de Gloria", 130, null, ""));
        peliculas.add(new Pelicula(4, "Cop Car", 95, null, ""));
        peliculas.add(new Pelicula(5, "¡Aterriza Como Puedas!", 88, null, ""));
        return peliculas;
    }

    private static void mostrarCartelera(ArrayList<Pelicula> peliculas) {
        System.out.println("Cartelera: \n");
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println((i + 1) + " - " + peliculas.get(i).getNomPelicula());
        }
    }

    private static ArrayList<Sala> cargarSalas() {
        ArrayList<Sala> salas = new ArrayList<>();
        salas.add(new Sala(1, "Sala 1", 150));
        salas.add(new Sala(2, "Sala 2", 100));
        salas.add(new Sala(3, "Sala 3", 150));
        salas.add(new Sala(4, "Sala 4", 100));
        salas.add(new Sala(5, "Sala 5", 150));
        return salas;
    }

    private static ArrayList<Sesion> cargarSesiones(ArrayList<Pelicula> peliculas, ArrayList<Sala> salas) {
        ArrayList<Sesion> sesiones = new ArrayList<>();
        int idSesion = 1;

        // Recorremos cada día (7 días)
        for (int d = 0; d < 7; d++) {
            LocalDateTime inicioBase = LocalDateTime.of(2026, 2, 1, 10, 0).plusDays(d);
            LocalDateTime finBase    = LocalDateTime.of(2026, 2, 1, 12, 0).plusDays(d);

            // Recorremos cada película
            for (int p = 0; p < peliculas.size(); p++) {

                // Elegimos sala de forma circular si hay más películas que salas
                Sala sala = salas.get(p % salas.size());

                // Creamos 8 sesiones por película
                for (int s = 0; s < 8; s++) {
                    double precio;
                    if (s <= 2) precio = 6;
                    else if (s <= 5) precio = 9.50;
                    else precio = 12;

                    Sesion sesion = new Sesion(
                            idSesion++,
                            String.format("S%02d-%02d", p + 1, s + 1),
                            inicioBase.plusHours(2 * s),
                            finBase.plusHours(2 * s),
                            precio,
                            sala,
                            peliculas.get(p)
                    );

                    sesiones.add(sesion);
                    sala.getSesiones().add(sesion);
                }
            }
        }

        // Ordenar sesiones por fecha de inicio
        Collections.sort(sesiones, Comparator.comparing(Sesion::getfecHoraIni));
        return sesiones;
    }
    
    private static void mostrarSesiones(ArrayList<Sesion> sesiones, Pelicula peliculaElegida, LocalDateTime fechaElegida) {

        String[] numSesiones = {
            "Primera ", "Segunda ", "Tercera ", "Cuarta ",
            "Quinta ", "Sexta ", "Séptima ", "Octava "
        };

        int contador = 0;    
        DateTimeFormatter fechaF = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("es"));

        System.out.println("\nSeleccionada: " + peliculaElegida.getNomPelicula());
        System.out.println("\nHorarios: " + fechaElegida.format(fechaF) + " (" + peliculaElegida.getNomPelicula() + ")\n");

        for (Sesion s : sesiones) {
            LocalDateTime f = s.getfecHoraIni();

            // Comparamos objetos Pelicula y misma fecha
            if (s.getPelicula().equals(peliculaElegida) &&
                f.toLocalDate().equals(fechaElegida.toLocalDate())) {

                System.out.println(
                    numSesiones[contador] + "sesión : " +
                    f.toLocalTime() + " - " +
                    s.getPelicula().getNomPelicula() + " (" +
                    s.getidSala().getNombre() + ") - " +
                    s.getPrecio() + "€\n"
                );

                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("No hay sesiones disponibles para esta película en esta fecha.");
        }
    }

    private static ArrayList<LocalDateTime> cargarFechas() {
        ArrayList<LocalDateTime> fechas = new ArrayList<>();
        for (int f = 0; f < 7; f++) {
            fechas.add(LocalDateTime.of(2026, 2, 1, 10, 0).plusDays(f));
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

	public static double resumenCompra (ArrayList<Entrada> carrito, HashSet<String> peliculasDistintas) {

		

		System.out.println("\n------------ RESUMEN DE LA COMPRA -------------");

		

		double precioTotal = 0;


		for (Entrada c : carrito) {

			

			peliculasDistintas.add(c.getSesion().getPelicula().getNomPelicula());

			DateTimeFormatter fechaF = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("es"));

			

			double subTotal = c.getcantidad() * c.getSesion().getPrecio();

			precioTotal += subTotal;


			System.out.println(
		

					"\n\nPelícula seleccionada: " + c.getSesion().getPelicula().getNomPelicula() +

					"\nFecha y Hora: " + c.getSesion().getfecHoraIni().format(fechaF) +

					"\nSala: "	+ c.getSesion().getidSala().getIdSala() +

					"\nNúmero de entradas: " + c.getcantidad() +

					"\nPrecio total de la(s) entrada(s) ---> " + subTotal + " € "

					);	

					

					}	

		

		System.out.println("\nPRECIO TOTAL (SIN DESCUENTOS APLICADOS): " + precioTotal + " €" );

					

		return precioTotal;

		

	}


	public static double calcularDescuento (double precioTotal, int numPelis ) {		

		

		if (numPelis == 2) {

						

			System.out.println("\nDescuento del 20% aplicado\n");

			

			return	precioTotal * 0.80;

		} else if (numPelis >= 3) {

					

			System.out.println("\nDescuento del 30% aplicado\n");

			

			return precioTotal * 0.70;

			

		}

				

		return precioTotal;

		

	}

	

	

	

	public static void main(String[] args) {

		//Conexión con la BBD

		Scanner teclado = new Scanner(System.in);

		mensajeBienvenida();

		teclado.nextLine();

		

		//LISTAS

		ArrayList<Pelicula> peliculas = cargarCartelera();

		ArrayList <LocalDateTime> fechas = cargarFechas();

		ArrayList<Sala> salas = cargarSalas();

		ArrayList<Sesion> sesiones = cargarSesiones(peliculas, salas);

		ArrayList<Entrada> carrito = new ArrayList<>();

		

		ArrayList<Compra> carritoFinal = new ArrayList<>();

		ArrayList<Cliente>clientes = new ArrayList<>();

		

		

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

		Pelicula peliculaElegida = peliculas.get(opcionPelicula -1);

		

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

		

		LocalDateTime f = s.getfecHoraIni();

		

		if (s.getPelicula().equals(peliculaElegida) &&

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

		

		Entrada entrada = new Entrada (idEntrada,numPersonas, sesionElegida, null, LocalDateTime.now() );

		carrito.add(entrada);

		System.out.println("\nSe ha(n) añadido " + numPersonas + " entrada(s) para " + peliculaElegida + " a tu carrritoo\n");

		idEntrada++;

		//--------------------------------------------------------------------------------

		

		System.out.println("\nSeñala una de las 3 opciones: \n");

		System.out.println("1. Añadir más sesiones");

		System.out.println("2. Añadir más películas");

		System.out.println("3. Finalizar Compra");

		

		int opcionCompra = teclado.nextInt();

		teclado.nextLine();

		

		switch (opcionCompra) {

		

		case 1: seguirConPelicula = true;

		break;

		

		case 2: seguirConPelicula = false;

		break;

		

		case 3 : seguirConPelicula = false ;

		seguirComprando = false;

		break;

		

		}	

		}	

		}	

		}

		//Resumen de la compra

		HashSet<String > peliculasDistintas = new HashSet<>();

		

		double subTotal = resumenCompra(carrito, peliculasDistintas);

		

		double precioFinal = calcularDescuento(subTotal, peliculasDistintas.size());


		System.out.printf("\n PRECIO FINAL : %.2f €\n", precioFinal);

		
teclado.close();
		}

		}