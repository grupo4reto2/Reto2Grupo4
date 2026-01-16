package RETO2;
import java.time.LocalDateTime;
public class Sesion {

	private int idSesion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private Sala sala;
	private double precio;
	private Pelicula nomPelicula;
	
	public Sesion (int idSesion, LocalDateTime fechaInicio, LocalDateTime fechaFin, Sala sala, double precio, Pelicula nomPelicula) {
		this.idSesion = idSesion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.sala = sala;
		this.precio = precio;
		this.nomPelicula = nomPelicula;
		
		}

	
	public Pelicula getNomPelicula() {
		return nomPelicula;
	}

	public void setNomPelicula(Pelicula nomPelicula) {
		this.nomPelicula= nomPelicula;
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

	public Sala getsala() {
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
