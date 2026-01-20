package model;

import java.util.List;
import java.util.ArrayList;

public class Sala {

	private String idSala;
	private String nombre;
	private int aforo;
	private List<Sesion>sesiones;

	public Sala (String nombre, String idSala, int aforo) {
		this.nombre = nombre;
		this.idSala = idSala;
		this.aforo = aforo;
		this.sesiones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
		
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdSala() {
		return idSala;
	}

	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	
	
	public String toString () {
		
		return "ID Sala: " + idSala +
				" Sala: " + nombre + 
				" Aforo: " + aforo;
	}
	
	
}



