package model;
import java.time.LocalDateTime;
public class Sesion {

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
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pelicula getidPelicula() {
		return idPelicula;

	public void setidPelicula(Pelicula idPelicula) {
		this.idPelicula = idPelicula;
	
	@Override
	
	public String toString() {
		return  "Sesion ID :" + idSesion +
				"Codigo Sesion:" + codSesion.getCodSesion()+
				" Inicio: " + fecHoraIni.getfecHoraIni() +
				" Fin: " + fecHoraFin.getfecHoraFin() +
				" Sala: " + idSala.getNombre() + 
				" Precio: " + precio +
				" Película: " + nomPelicula.getNomPelicula();
	}
	
}
