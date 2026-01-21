package model;
import java.time.LocalDateTime;
public class Sesion {

	private int idSesion;
	private String codSesion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private Sala sala;
	private double precio;
	private String nomPelicula;
	
	public Sesion (int idSesion, String codSesion, LocalDateTime fechaInicio, LocalDateTime fechaFin, Sala sala, double precio, String nomPelicula) {
		this.idSesion = idSesion;
		this.codSesion = codSesion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.sala = sala;
		this.precio = precio;
		this.nomPelicula = nomPelicula;
		
		}

	
	public String getNomPelicula() {
		return nomPelicula;
	}

	public void setNomPelicula(String nomPelicula) {
		this.nomPelicula= nomPelicula;
	}

	public int getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public String getCodSesion() {
		return codSesion;
	}

	public void setCodSesion(String codSesion) {
		this.codSesion = codSesion;
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
				"Codigo Sesion:" + codSesion.getCodSesion()+
				" Inicio: " + fechaInicio.getFechaInicio() +
				" Fin: " + fechaFin.getFechaFin() +
				" Sala: " + sala.getNombre() + 
				" Precio: " + precio +
				" Película: " + nomPelicula.getNomPelicula();
	}
	
}
