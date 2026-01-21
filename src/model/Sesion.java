package model;
import java.time.LocalDateTime;
public class Sesion {

<<<<<<< HEAD
	private String idSesion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private Sala sala;
	private double precio;
	private String nomPelicula;
	
	public Sesion (String idSesion, LocalDateTime fechaInicio, LocalDateTime fechaFin, Sala sala, double precio, String nomPelicula) {
		this.idSesion = idSesion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.sala = sala;
		this.precio = precio;
=======
	private int idSesion;
	private String codSesion;
	private LocalDateTime fecHoraIni;
	private LocalDateTime fecHoraFin;
	private double precio;
	private Sala idSala;
	private Pelicula idPelicula;
	private String nomPelicula;
	
	public Sesion (int idSesion, String codSesion, LocalDateTime fecHoraIni, LocalDateTime fecHoraFin,  double precio, Sala idSala, Pelicula idPelicula, String nomPelicula) {
		this.idSesion = idSesion;
		this.codSesion = codSesion;
		this.fecHoraIni = fecHoraIni;
		this.fecHoraFin = fecHoraFin;
		this.precio = precio;
		this.idSala = idSala;
		this.idPelicula = idPelicula;
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
		this.nomPelicula = nomPelicula;
		
		}

	
	public String getNomPelicula() {
		return nomPelicula;
	}

	public void setNomPelicula(String nomPelicula) {
		this.nomPelicula= nomPelicula;
	}

<<<<<<< HEAD
	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
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
=======
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

	public LocalDateTime getfecHoraIni() {
		return fecHoraIni;
	}

	public void setfecHoraIni(LocalDateTime fecHoraIni) {
		this.fecHoraIni = fecHoraIni;
	}

	public LocalDateTime getfecHoraFin() {
		return fecHoraFin;
	}

	public void setfecHoraFin(LocalDateTime fecHoraFin) {
		this.fecHoraFin = fecHoraFin;
	}

	public Sala getidSala() {
		return idSala;
	}

	public void setidSala(Sala idSala) {
		this.idSala = idSala;
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

<<<<<<< HEAD

=======
	public Pelicula getidPelicula() {
		return idPelicula;

	public void setidPelicula(Pelicula idPelicula) {
		this.idPelicula = idPelicula;
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	
	@Override
	
	public String toString() {
		return  "Sesion ID :" + idSesion +
<<<<<<< HEAD
				" Inicio: " + fechaInicio +
				" Fin: " + fechaFin +
				" Sala: " + sala.getNombre() + 
				" Precio: " + precio +
				" Película: " + nomPelicula;
=======
				"Codigo Sesion:" + codSesion.getCodSesion()+
				" Inicio: " + fecHoraIni.getfecHoraIni() +
				" Fin: " + fecHoraFin.getfecHoraFin() +
				" Sala: " + idSala.getNombre() + 
				" Precio: " + precio +
				" Película: " + nomPelicula.getNomPelicula() + idPelicula.getIdPelicula();
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	}
	
}
