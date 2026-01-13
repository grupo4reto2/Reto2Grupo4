package RETO2;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class borrador {
	
	private static void mensajeBienvenida () {

		String negrita = "\033[1m";

		System.out.println("_______________________________ ");

		System.out.println(negrita + "\nBIENVENIDO A \"NOMBRE DEL CINE\" |");

		System.out.println("_______________________________|");

		

		System.out.println("\n Haga click para iniciar");
		
	}
	
	private static void mostrarSesion(Sesion sesion, Sesion sesion2, Pelicula pelicula) {
		
		LocalDateTime mañana = LocalDateTime.now().plusDays(1);
		DateTimeFormatter formatearFecha = DateTimeFormatter.ofPattern("d MMMM",  new Locale ("Ja"));
		String fechaTexto = mañana.format(formatearFecha);
		
		System.out.println("\nSeleccionada: " + sesion.getPelicula());
		
		System.out.println("\nHorarios " + fechaTexto + " "+ "(" + sesion.getPelicula() + ")\n");
		
		System.out.println(
				
							//SESION 1
							sesion.getFechaInicio().toLocalTime() + " - " + sesion.getPelicula() + 
							" " + "(" + sesion.getSala() + ") - " + sesion.getPrecio() + " € \n" + 
				
							//SESION 2
							sesion2.getFechaInicio().toLocalTime() + " - " + sesion2.getPelicula() + 
							" " + "(" + sesion2.getSala() + ") - " + sesion2.getPrecio() + " €");
		
	}
	
	
	

    enum opcionesPelicula {
        Pulp_Fiction, Kung_Fu_Panda, IT
    }

    public static void main(String[] args) {
    	
    	Scanner teclado = new Scanner(System.in);
    	
    	Pelicula peliculaPulpFiction = new Pelicula(4549, 154, "Crimen/thriller/comedia negra", 7.50);
    	Pelicula peliculaKungFuPanda = new Pelicula(4570,92, "Infantil/comedia", 10.50);
    	Pelicula peliculaIT = new Pelicula(4578, 135, "Horror/suspense", 10.50);
    	
    	
    	Sala salaPulpFiction = new Sala("Sala 4", 343);
    	Sala salaKungFuPanda = new Sala("Sala 2", 321);
    	Sala salaIT = new Sala("Sala 1", 314);
    	
    	Sesion sesionPulpFiction1 = new Sesion(7877,LocalDateTime.of(2026,2,1,13,00,0), LocalDateTime.of(2026,2,1,15,30,0), salaPulpFiction, 7.50, "Pulp Fiction");
    	Sesion sesionKungFuPanda1 = new Sesion(7656,LocalDateTime.of(2026,2,1,18,00,0), LocalDateTime.of(2026,2,1,19,30,0), salaKungFuPanda, 10.50, "Kung Fu Panda");
    	Sesion sesionIT1 = new Sesion(7754,LocalDateTime.of(2026,2,1,18,30,0), LocalDateTime.of(2026,2,1,20,45,0), salaIT, 10.50, "IT");
    	
    	Sesion sesionPulpFiction2 = new Sesion(7869,LocalDateTime.of(2026,2,1,17,00,0), LocalDateTime.of(2026,2,1,19,30,0), salaPulpFiction, 10.50, "Pulp Fiction");
    	Sesion sesionKungFuPanda2 = new Sesion(7699,LocalDateTime.of(2026,2,1,21,00,0), LocalDateTime.of(2026,2,1,22,30,0), salaKungFuPanda, 10.50, "Kung Fu Panda");
    	Sesion sesionIT2 = new Sesion(7750,LocalDateTime.of(2026,2,1,21,30,0), LocalDateTime.of(2026,2,1,23,45,0), salaIT, 10.50, "IT");
    	
    	
    	mensajeBienvenida();
    	teclado.nextLine();
    	
    	System.out.println("Cartelera:");
    	System.out.println("\n 1. - Pulp Fiction");
    	System.out.println("\n 2. - Kung Fu Panda");
    	System.out.println("\n 3. - IT");

    	int opcion = teclado.nextInt();
    	
    	opcionesPelicula eleccion;
    	
    	switch (opcion) {
    	
    	case 1: eleccion = opcionesPelicula.Pulp_Fiction;
    			break;
    	case 2: eleccion = opcionesPelicula.Kung_Fu_Panda;
    			break;
    	case 3: eleccion = opcionesPelicula.IT;
    			break;
    	default: System.out.println("Opcion no valida");
    			return;
    	
    	}
    	
    	
    	
    	switch (eleccion) {
    	
    	case Pulp_Fiction:
    		mostrarSesion(sesionPulpFiction1, sesionPulpFiction2, peliculaPulpFiction);
    		break;
    		
    	case Kung_Fu_Panda:
    		mostrarSesion(sesionKungFuPanda1, sesionKungFuPanda2, peliculaKungFuPanda);
    		break;
    	
    	case IT:
    		mostrarSesion(sesionIT1, sesionIT2, peliculaIT);
    		break;
    		
    	
    	}
    	
    	teclado.close();
    	
    	
    }
}




























