package RETO2;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class borrador {

	private static void mensajeBienvenida () {

		String negrita = "\033[1m";

		System.out.println("_______________________________ ");

		System.out.println(negrita + "\nBIENVENIDO A \"NOMBRE DEL CINE\" |");

		System.out.println("_______________________________|");


		System.out.println("\n Haga click para iniciar");


	}
	
	
	private static String fechaFormateada () {
		
		LocalDateTime mañana = LocalDateTime.now().plusDays(1);
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("d MMMM", new Locale("es"));
		String fechaTexto = mañana.format(fechaFormateada);
		
		return fechaTexto;
		
	}
	
	
	
	
	private static void mostrarSesion (ArrayList<Sesion> sesiones, String nombrePelicula) {
		
		String fechaTexto = fechaFormateada();
		
		System.out.println("\nSeleccionada: " + sesiones.get(0).getNomPelicula());
		System.out.println("\nHorarios: " + fechaTexto + " (" + sesiones.get(0).getNomPelicula() + ")\n ");
		
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
						LocalDateTime.of(2026,1,1,10,0,0).plusHours(2 * (s - 1)),
						LocalDateTime.of(2026,1,1,12,0,0).plusHours(2 * (s - 1)),
						salas.get(p),
						precio,
						peliculas.get(p)
						
						));
				
			}
			
		}
		
		
		//SESIONES POR FECHA Y HORA
		
		Collections.sort(sesiones, Comparator.comparing(Sesion:: getFechaInicio));
		
		
		//CARTELERAAA
		
		System.out.println("Cartelera: ");
		
		for (int i = 0; i < peliculas.size(); i++) {
			
			System.out.println(i + 1 + " - " + peliculas.get(i));
			
		}
		
		
		//SELECCIÓNNNNN
		
		int opcion = teclado.nextInt();
		
		switch(opcion) {
		
		case 1: mostrarSesion(sesiones, "El Rey León");
		break;
		
		case 2: mostrarSesion(sesiones, "No Respires");
		break;
		
		case 3: mostrarSesion(sesiones, "Senderos de Gloria");
		break;
		
		case 4: mostrarSesion(sesiones, "Cop Car");
		break;
		
		case 5: mostrarSesion(sesiones, "¡Aterriza Como Puedas!");
		break;
		
		}
		

	}

}
