package RETO2;

import java.util.List;
import java.util.ArrayList;

public class Sala {

	private String nombre;
	private int idSala;
	private List<Sesion>sesiones;

	public Sala (String nombre, int idSala) {
		this.nombre = nombre;
		this.idSala = idSala;
		this.sesiones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
		
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setId(int idSala) {
		this.idSala = idSala;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	
	
	public String toString () {
		
		return nombre;
		
	}
	
	
}




