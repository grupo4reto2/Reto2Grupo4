package RETO2;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

//TODO ESTO ESTO ES UNA PRUEBA//

public class APLICACION {

	private static void mensajeBienvenida () {
		String negrita = "\033[1m";
		System.out.println("_______________________________ ");
		System.out.println(negrita + "\nBIENVENIDO A \"NOMBRE DEL CINE\" |");
		System.out.println("_______________________________|");
	}
	
	private static void relacionPeliculas() {
		
	}

	public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	mensajeBienvenida();
	teclado.nextLine();

	Sala sala1 = new Sala("Sala 1", 11);
	Sesion sesion1 = new Sesion(
			3303,
			LocalDateTime.of(2026,2,1,13,30,0),
			LocalDateTime.of(2026,2,1,15,30,0),
			sala1,
			10.50,
			"Pulp fiction");
			
	sala1.getSesiones().add(sesion1);
	
	System.out.println("Cartelera:");
	System.out.println("1 - " + sesion1.getPelicula());
	
	}

}
