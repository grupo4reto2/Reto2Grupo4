package RETO2;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class actualBorrador {

	private static void mensajeBienvenida () {

		String negrita = "\033[1m";

		System.out.println("_______________________________ ");

		System.out.println(negrita + "\nBIENVENIDO A \"NOMBRE DEL CINE\" |");

		System.out.println("_______________________________|");


		System.out.println("\n Haga click para iniciar");


	}
	
	
	/*private static String fechaFormateada () {
		
		LocalDateTime mañana = LocalDateTime.now().plusDays(1);
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd MMMM", new Locale("es"));
		String fechaTexto = mañana.format(fechaFormateada);
		
		return fechaTexto;
		
	}*/
	
	
	
	private static void mostrarFechas (ArrayList<Sesion>  sesiones ) {
		
		DateTimeFormatter fechaF = DateTimeFormatter.ofPattern("dd MMMM YYYY" , new Locale ("es"));
		
		System.out.println("\nFechas disponibles: \n");
		
		for (int f = 0; f < 5; f++) {
			
			LocalDateTime fecha = sesiones.get(f).getFechaInicio().plusDays(f);
			
			System.out.println( (f + 1) + ". - " + fecha.toLocalDate().format(fechaF) + "\n");
			
		}
		
		
	}
	
	
	private static void mostrarCartelera (ArrayList<String> peliculas) {
		
	System.out.println("Cartelera: \n");
		
		for (int i = 0; i < peliculas.size(); i++) {
			
			System.out.println(i + 1 + " - " + peliculas.get(i));
			
		}
		
	}
	
	
	
	private static void mostrarSesion (ArrayList<Sesion> sesiones, String nombrePelicula, LocalDateTime fechaElegida) {
		
		DateTimeFormatter fechaF = DateTimeFormatter.ofPattern("dd MMMM YYYY" , new Locale ("es"));
	
		//sesiones.get(f).getFechaInicio().plusDays(f);
		
		System.out.println("\nSeleccionada: " + nombrePelicula );
		System.out.println("\nHorarios: " + fechaElegida.format(fechaF) + " (" + nombrePelicula + ")\n ");
		
		for (int i= 0; i < sesiones.size(); i++) {
			
			if(sesiones.get(i).getNomPelicula().equals(nombrePelicula)) {
				
				System.out.println(
						
						sesiones.get(i).getFechaInicio().toLocalTime() + 
						" - " + nombrePelicula + 
						" (" + sesiones.get(i).getSala().getNombre() + ")" +
						" - " + sesiones.get(i).getPrecio() + "€\n"
						
						);

			}
				
			}
			
		
	}
	

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		mensajeBienvenida();
		teclado.nextLine();
		
		//SALASSS
		
		ArrayList<Sala> salas = new ArrayList<>();
		
		salas.add( new Sala ("Sala 1" , "S01" , 150));
		salas.add(new Sala ("Sala 2" , "S02" , 100));
		salas.add(new Sala ("Sala 3" , "S03" , 150));
		salas.add(new Sala("Sala 4" , "S04", 100));
		salas.add(new Sala("Sala 5" , "S05" , 150));
		
		//PELICULAS (STRING)
		
		ArrayList<String> peliculas = new ArrayList<>();
		peliculas.add("El Rey León");
		peliculas.add("No Respires");
		peliculas.add("Senderos de Gloria");
		peliculas.add("Cop Car");
		peliculas.add("¡Aterriza Como Puedas!");
		
		
		//FECHASSSS
		
		

		ArrayList<LocalDateTime> fechas = new ArrayList<>();
		
		for (int f = 1 ; f <= 7; f++) {                           //CORREGIR
			
			fechas.add(LocalDateTime.now().plusDays(13 + f));

			
		}
		
	
		/*ArrayList<LocalDateTime> fechas = new ArrayList<>();
		
		for (int f = 1 ; f <= 7; f++) {
			
			fechas.add(LocalDateTime.now().plusDays(f));

			
		}*/
		
	
				
		
		//SESIONESSSS
		
		ArrayList<Sesion> sesiones = new ArrayList<>();
		
		for (int p = 0; p < peliculas.size(); p++) {
			for (int s = 1; s <=8; s++) {
				double precio;
				
				if(s <= 3) {
					precio = 6;
				} else if (s <=6) {
					precio = 9.50;
				} else {
					precio = 12;
				}
				
				sesiones.add(new Sesion (
						
						String.format("S%02d-%02d" , p + 1, s), 
						LocalDateTime.of(2026,2,1,10,0,0).plusHours(2 * (s - 1)).plusDays(p),
						LocalDateTime.of(2026,2,1,12,0,0).plusHours(2 * (s - 1)),
						salas.get(p),
						precio,
						peliculas.get(p)
						
						));
				
			}
			
		}
		
		
		//SESIONES POR FECHA Y HORA
		
		Collections.sort(sesiones, Comparator.comparing(Sesion:: getFechaInicio));
		
		
		//SELECCIÓN DE PELICULA
		
		mostrarCartelera(peliculas);
		
		int opcion1 = teclado.nextInt();
		
		
		switch (opcion1) {
		
		case 1: mostrarFechas(sesiones);
		break;
		
		case 2: mostrarFechas(sesiones);
		break;
		
		case 3: mostrarFechas(sesiones);
		break;
		
		case 4: mostrarFechas(sesiones);
		break;
		
		case 5: mostrarFechas(sesiones);
		break;
		
		
		
		default: System.out.println("OPCION NO VALIDA");
		return;
		
		
		}
		
		
		
		//SELECCIÓN DE FECHAS
		
		int opcion2 = teclado.nextInt();
		LocalDateTime fechaElegida = fechas.get(opcion2 -1);
		
		System.out.println("\nElige una fecha\n");
		
		switch (opcion2) {
		
		
		case 1: mostrarSesion(sesiones, "El Rey León", fechaElegida);
		break;
		
		case 2: mostrarSesion(sesiones, "No Respires", fechaElegida);
		break;
		
		case 3: mostrarSesion(sesiones, "Senderos de Gloria", fechaElegida);
		break;
		
		case 4: mostrarSesion(sesiones, "Cop Car", fechaElegida);
		break;
		
		case 5: mostrarSesion(sesiones, "¡Aterriza Como Puedas!", fechaElegida);
		break;
		
		default: System.out.println("Opcion no válida");
		return;
		
		}
		
		
		
		}
		

	}

