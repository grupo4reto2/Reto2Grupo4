package RETO2;
import java.time.LocalDateTime;
public class Sesion {

	private int idSesion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private Sala sala;
	private double precio;
	private String pelicula;
	
	public Sesion (int idSesion, LocalDateTime fechaInicio, LocalDateTime fechaFin, Sala sala, double precio, String pelicula) {
		this.idSesion = idSesion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.sala = sala;
		this.precio = precio;
		this.pelicula = pelicula;
		
		}

	
	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public int getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	
	@Override
	
	public String toString() {
		return  "Sesion ID :" + idSesion +
				" Inicio: " + fechaInicio +
				" Fin: " + fechaFin +
				" Sala: " + sala.getNombre() +
				" Precio: " + precio +
				" Película: " + pelicula;
	}
	
}
