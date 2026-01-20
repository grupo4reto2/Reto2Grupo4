package RETO2;
import java.util.Scanner;

import model.Sala;
import model.Sesion;

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

		

		System.out.println("\n Haga click para iniciar");

	}
	

	public static ArrayList<Sala> salas() {

		ArrayList<Sala> salas = new ArrayList<>();
		
		Sala sala1 = new Sala("Sala 1" , 6);

		Sala sala2 = new Sala("Sala 2" , 12);

		Sala sala3 = new Sala("Sala 3" , 18);

		Sala sala4 = new Sala("Sala 4" , 24);

		Sala sala5 = new Sala("Sala 5" , 30);

		Sala sala6 = new Sala("Sala 6" , 36);

		Sala sala7 = new Sala("Sala 7" , 42);

		Sala sala8 = new Sala("Sala 8" , 48);

		Sala sala9 = new Sala("Sala 9" , 54);

		Sala sala10 = new Sala("Sala 10" , 60);
		

		salas.add(sala1);

		salas.add(sala2);

		salas.add(sala3);

		salas.add(sala4);

		salas.add(sala5);

		salas.add(sala6);

		salas.add(sala7);

		salas.add(sala8);

		salas.add(sala9);

		salas.add(sala10);

		return salas;

	}

	

	public static void sesiones (Sala sala) {


		Sesion sesion1 = new Sesion(4343,LocalDateTime.of(2026,2,1,12,00,0),LocalDateTime.of(2026,2,1,14,00,0), sala, 8.50, "Pelicula1");

		Sesion sesion2 = new Sesion(2433,LocalDateTime.of(2026,2,1,12,00,0),LocalDateTime.of(2026,2,1,13,45,0), sala, 8.50, "Pelicula2");

		Sesion sesion3 = new Sesion(2877,LocalDateTime.of(2026,2,1,12,30,0),LocalDateTime.of(2026,2,1,14,45,0), sala, 8.50, "Pelicula3");

		Sesion sesion4 = new Sesion(6763,LocalDateTime.of(2026,2,1,13,00,0),LocalDateTime.of(2026,2,1,15,00,0), sala, 8.50, "Pelicula4");

		Sesion sesion5 = new Sesion(5675,LocalDateTime.of(2026,2,1,13,30,0),LocalDateTime.of(2026,2,1,16,00,0), sala, 8.50, "Pelicula5");

		Sesion sesion6 = new Sesion(9868,LocalDateTime.of(2026,2,1,16,00,0),LocalDateTime.of(2026,2,1,18,00,0), sala, 10.50, "Pelicula1");

		Sesion sesion7 = new Sesion(9764,LocalDateTime.of(2026,2,1,16,30,0),LocalDateTime.of(2026,2,1,19,00,0), sala, 10.50, "Pelicula2");

		Sesion sesion8 = new Sesion(3333,LocalDateTime.of(2026,2,1,17,30,0),LocalDateTime.of(2026,2,1,20,00,0), sala, 10.50, "Pelicula3");

		Sesion sesion9 = new Sesion(4544,LocalDateTime.of(2026,2,1,18,00,0),LocalDateTime.of(2026,2,1,20,00,0), sala, 10.50, "Pelicula4");

		Sesion sesion10 = new Sesion(2233,LocalDateTime.of(2026,2,1,19,30,0),LocalDateTime.of(2026,2,1,22,00,0), sala, 10.50, "Pelicula5");

	
		
		}
	
	
}
