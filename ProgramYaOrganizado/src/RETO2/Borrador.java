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
import DAO_POJO.*;
import java.sql.Connection;

public class Borrador {

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
        
    	PeliculaDAO daoPelis = new PeliculaDAO();
    	
    	try {
    		
    		 return daoPelis.mostrarCartelera();
    		
    	} catch (Exception e) {
    		
    		System.out.println("Error al cargar cartelera: " + e.getMessage());
    		
    		return null;
    	}
    	
    }

    private static void mostrarCartelera(ArrayList<Pelicula> peliculas) {
        System.out.println("Cartelera: \n");
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println((i + 1) + " - " + peliculas.get(i).getNomPelicula());
        }
    }

    private static ArrayList<Sala> cargarSalas() {
    	salaDAO daoSala = new salaDAO();
    	
    	try {
    		
    		ArrayList<Sala> salas = daoSala.mostrarSalas();
    		
    		System.out.println("Salas: \n" + salas.size());
    		
    		return salas;
    		
    	} catch (Exception e) {
    		
    		System.out.println("Error al buscar salas: " + e.getMessage());
    		
    		return new ArrayList<>();
    		
    	}
    
    }

    private static ArrayList<Sesion> cargarSesiones(ArrayList<Pelicula> peliculas, ArrayList<Sala> salas) {
      
    	SesionDAO daoSesion = new SesionDAO();
    	
    	
    	try {
    		
        	ArrayList<Sesion> sesiones = daoSesion.mostrarSesiones(peliculas, salas);
        	
        	System.out.println("Sesiones: " + sesiones.size());
        	
        	
        	
        	return sesiones;

    		
    	} catch (Exception e) {
    	
    		System.out.println("Error al mostrar las sesiones: " + e.getMessage() );
    		
    		return new ArrayList<>();
    				
    	}
    	
    	
    	

    	
    			
    	
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
            if (s.getIDPelicula().equals(peliculaElegida) &&
                f.toLocalDate().equals(fechaElegida.toLocalDate())) {

                System.out.println(
                    numSesiones[contador] + "sesión : " +
                    f.toLocalTime() + " - " +
                    s.getIDPelicula().getNomPelicula() + " (" +
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

			

			peliculasDistintas.add(c.getSesion().getIDPelicula().getNomPelicula());

			DateTimeFormatter fechaF = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("es"));

			

			double subTotal = c.getcantidad() * c.getSesion().getPrecio();

			precioTotal += subTotal;


			System.out.println(
		

					"\n\nPelícula seleccionada: " + c.getSesion().getIDPelicula().getNomPelicula() +

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

		} else if (numPelis > 2) {

					

			System.out.println("\nDescuento del 30% aplicado\n");

			

			return precioTotal * 0.70;

			

		}

				

		return precioTotal;

		

	}

	

	

	

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		mensajeBienvenida();

		teclado.nextLine();

		

		//LISTAS

		ArrayList<Pelicula> peliculas = cargarCartelera();

		ArrayList <LocalDateTime> fechas = cargarFechas();

		ArrayList<Sala> salas = cargarSalas();

		ArrayList<Sesion> sesiones = cargarSesiones(peliculas, salas);

		ArrayList<Entrada> carrito = new ArrayList<>();

		ArrayList<Sesion> sesionesFiltradas = new ArrayList<>();

		ArrayList<Compra> carritoFinal = new ArrayList<>();

		ArrayList<Cliente>clientes = new ArrayList<>();

		

		

		boolean seguirComprando = true;	

		while (seguirComprando) {

		mostrarCartelera(peliculas);

		System.out.println("\nElige una pelicula (1-" + peliculas.size() + ")");

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
		


		for (Sesion s : sesiones) {	

		LocalDateTime f = s.getfecHoraIni();

		if (s.getIDPelicula().equals(peliculaElegida) &&

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

		double precioTotal = 0;
		
		for (Entrada c:carrito) {
			double subTotal = c.getcantidad() * c.getSesion().getPrecio();
			precioTotal = subTotal + precioTotal;
			
			DateTimeFormatter fechaF = DateTimeFormatter.ofPattern("dd MMMM yyyy");
			System.out.println(
					"\nPelicula: " + c.getSesion().getIDPelicula().getNomPelicula()+
					"\nFecha y hora: " +c.getSesion().getfecHoraIni().format(fechaF)+
					"\nSala: " +c.getSesion().getidSala().getNombre()+
					"\nNumero de entradas: " + c.getcantidad()+
					"\nSubtotal: " + subTotal+ " €"
					);
			
		}

		System.out.println("\n---------------RESUMEN---------------");
		System.out.printf("Subtotal (sin descuentos): %.2f €\n", precioTotal);
		
		
		try {
	          EntradaDAO dao = new EntradaDAO();
	          dao.mostrarDescuentos();   // AQUÍ se pide al DAO que ejecute
	      } catch (Exception e) {
	          System.out.println("Error al mostrar entradas: " + e.getMessage());
	      }
		
		//double subTotal = resumenCompra(carrito, peliculasDistintas);

		

		//double precioFinal = calcularDescuento(subTotal, peliculasDistintas.size());


		System.out.printf("\n PRECIO FINAL : %.2f €\n", precioTotal);
		
		
		
		ClienteDAO daoCli = new ClienteDAO();
		
		String emogi = "\uD83D\uDE00";
		int contador = 1;
		boolean clienteValido = false;
		
		System.out.println("\n----------------LOGIN-----------------");

		while (!clienteValido && contador <4) {
			
			System.out.println("\nIntento " + contador + "/3");
			
			
			System.out.println("\nCorreo electrónico: ");
			String correo = teclado.nextLine();
			
			System.out.println("\nContraseña: ");
			String passwd = teclado.nextLine();
			
			
			try {
				
				Cliente login = daoCli.login(correo, passwd);
				
				
				if (login != null) {
					
					System.out.println("\nLogin correcto, ¡Bienvenido seas " + login.getNombre() + " " + login.getApellido() + " " + emogi + "!");			
					
					clienteValido = true;
					
				} else {
					
					System.out.println("Login incorrecto");
					contador++;
					
				}
				
				
			} catch (Exception e) {
				
				System.out.println("Error al mostrar cliente: " + e.getMessage());
				
			}
			
			
		}
		
		teclado.close();
		}

	}