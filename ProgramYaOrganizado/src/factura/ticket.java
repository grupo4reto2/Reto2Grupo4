package factura;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import clases.*;

public class ticket {
	
	
	
	/**
	 * 
	 * 
	 * Este método genera números random para que cada fichero tenga un número identificador propio
	 * 
	 * @param valorMin - El límite inferior del rango de donde se empiezan a generar números random (incluído)
	 * @param valorMax - El límite superior del rango de donde se terminan de generar números (incluído)
	 * 
	 * @return un número generado entre el límite inferior al límite superior (ambos incluídos)
	 * 
	 * */
	
	public static int numerosRandom (int valorMin, int valorMax) {
		
		int rango = (valorMax - valorMin)  + 1; //se pone +1 para que el valor máximo se incluya también en el erango
		
		return (int) (Math.random() * rango ) + valorMin;  //lo pasamos de double a int
		
		
	}
	
	
	
	/**
	 * 
	 * El metodo genera ficheros de la factura de la compra, hecho
	 *  con un bucle for por si hay selección de otras sesiones o películas 
	 *  
	 *  @param carrito - Lo usamos para obtener el resumen de la compra
	 *  @param cliente - Lo usamos para obtener los datos del cliente que realizó la compra
	 *  @param precioFinal - Lo usamos para obtener el precio final de la compra que se realiza fuera del carrito
	 *  
	 *  @return devuelve el nombre del fichero generado por el dni del cliente y los números random
	 * 
	 * */
	
	public static String generarTicket(ArrayList<Entrada> carrito, Cliente cliente, double precioFinal) throws IOException {
		
		//Formatos de fechas y horas
		
		LocalDateTime facturaDate = LocalDateTime.now();
		DateTimeFormatter fechaFacturaForm = DateTimeFormatter.ofPattern("dd'-'MM'-'yyyy");
		DateTimeFormatter horaFacturaForm = DateTimeFormatter.ofPattern("HH:mm");
		
		
		//Damos valor a los numeros random 
		
		int valorMin = 100000000;
		int valorMax = 999999999;
		int numFactura = numerosRandom(valorMin, valorMax);
		
		String carpeta = "C:\\Users\\in1dm3-v\\Desktop\\GRUPO4-RETO2\\Reto2Grupo4\\ProgramYaOrganizado\\src\\factura\\";
		File archivo = new File(carpeta);
		if(!archivo.exists()) {
			archivo.mkdir();
		}
		
		
		String nomFichero = carpeta +File.separator + "_" + cliente.getDni() + "_vuelvaPronto_" + numFactura + ".txt";
		FileWriter fileWriter;
		PrintWriter ficheroInsert;
		       
			try {
		        	fileWriter = new FileWriter(nomFichero);
		        	ficheroInsert = new PrintWriter(fileWriter);    
		        		
		        	ficheroInsert.println("║=-==-==-==-==-==-==-==-==-==-==-==-==-=-=║");
		        	ficheroInsert.println("║             ELORRIETA CINEMA            ║");
		        	ficheroInsert.println("║=-==-==-==-==-==-==-==-==-==-==-==-==-=-=║");
		        	ficheroInsert.println(" Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + "");
		        	ficheroInsert.println(" DNI: " + cliente.getDni());
		        	ficheroInsert.println(" Correo electrónico: " + cliente.getCorreo());
		        	ficheroInsert.println(" Día de la factura 📅:  " + facturaDate.format(fechaFacturaForm));
		        	ficheroInsert.println(" Hora de la factura 🕰️: " + facturaDate.format(horaFacturaForm));
		        	ficheroInsert.println(" ﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌");
		        	
		        	for (Entrada e : carrito) {
			        
		        		ficheroInsert.println(" ﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌");

			        ficheroInsert.println(" Función: " + e.getSesion().getIDPelicula().getNomPelicula() );
			        ficheroInsert.println(" Sala: " + e.getSesion().getidSala().getNombre());  //getidSala es el nombre de la clase que contiene los atributos de Sala
		        				        ficheroInsert.println(" Fecha: " + e.getSesion().getfecHoraIni().format(fechaFacturaForm) + " " + e.getSesion().getfecHoraIni().format(horaFacturaForm));
			        ficheroInsert.println(" Número de entradas: " + e.getcantidad());
			        ficheroInsert.println(String.format(" Precio total de la sesión:  %.2f €" , e.getcantidad() * e.getSesion().getPrecio()));

		        	}
		        	
		        	ficheroInsert.println(" ﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌");
		        	ficheroInsert.println(String.format(" Precio final: %.2f €" , precioFinal ));
		        	
		        	ficheroInsert.println("\n        ¡Gracias por su compra UwU!");
		        	ficheroInsert.println("║=-==-==-==-==-==-==-==-==-==-==-==-==-=-=║");

		
		        }   catch (IOException e) {
		        	
		        	System.out.println("Error, no se pudo crear la factura: " + e.getMessage());
		        	
		        }
		        

		        return nomFichero;
		        
	}
	

}