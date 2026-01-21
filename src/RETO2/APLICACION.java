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
		
		Sala sala1 = new Sala(1 , "Sala 1", 150);

		Sala sala2 = new Sala(2, "Sala 2" , 100);

		Sala sala3 = new Sala(3, "Sala 3" , 150);

		Sala sala4 = new Sala(4, "Sala 4" , 100);

		Sala sala5 = new Sala(5, "Sala 5" , 150);


		salas.add(sala1);

		salas.add(sala2);

		salas.add(sala3);

		salas.add(sala4);

		salas.add(sala5);


		return salas;

	}

	

	public static void sesiones (Sala sala) {


		Sesion sesion1 = new Sesion(1, "S01-01", LocalDateTime.of(2026,1,15,10,00,00), LocalDateTime.of(2026,1,15,12,00,00), 1, 6.00, 1, "El Rey León");

		Sesion sesion2 = new Sesion(2, "S01-02", LocalDateTime.of(2026,1,15,12,00,00),LocalDateTime.of(2026,1,15,14,00,00), 1, 6.00, 1,"El Rey León");

		Sesion sesion3 = new Sesion(3, "S01-03", LocalDateTime.of(2026,1,15,14,00,00),LocalDateTime.of(2026,1,15,16,00,00),  1, 6.00,1, "El Rey León");

		Sesion sesion4 = new Sesion(4, "S01-04",LocalDateTime.of(2026,1,15,16,00,00),LocalDateTime.of(2026,1,15,18,00,00),  1, 9.50, 1,"El Rey León");

		Sesion sesion5 = new Sesion(5, "S01-05", LocalDateTime.of(2026,1,15,18,00,00),LocalDateTime.of(2026,1,15,20,00,00), 1, 9.50, 1,"El Rey León");

		Sesion sesion6 = new Sesion(6, "S01-06", LocalDateTime.of(2026,1,15,20,00,00),LocalDateTime.of(2026,1,15,22,00,00), 1, 9.50, 1,"El Rey León");

		Sesion sesion7 = new Sesion(7, "S01-07",LocalDateTime.of(2026,1,15,22,00,00),LocalDateTime.of(2026,1,16,00,00,00), 1, 12, 1,"El Rey León");

		Sesion sesion8 = new Sesion(8, "S01-08", LocalDateTime.of(2026,1,16,00,00,00),LocalDateTime.of(2026,1,16,02,00,00), 1, 12,1, "El Rey León");
		
		}
	
	
}
