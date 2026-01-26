package clases;
import java.time.LocalDateTime;
public class Sesion {

	private int idSesion;
	private String codSesion;
	private LocalDateTime fecHoraIni;
	private LocalDateTime fecHoraFin;
	private double precio;
	private Sala idSala;
	private Pelicula pelicula;
	
	public Sesion (int idSesion, String codSesion, LocalDateTime fecHoraIni, LocalDateTime fecHoraFin,  double precio, Sala idSala, Pelicula pelicula) {
		this.idSesion = idSesion;
		this.codSesion = codSesion;
		this.fecHoraIni = fecHoraIni;
		this.fecHoraFin = fecHoraFin;
		this.precio = precio;
		this.idSala = idSala;
		this.pelicula = pelicula;

		}

	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula= pelicula;
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

	
	
	@Override
	
	public String toString() {
		return  "Sesion ID :" + idSesion +
				"Codigo Sesion:" + codSesion +
				" Inicio: " + fecHoraIni +
				" Fin: " + fecHoraFin +
				" Sala: " + idSala.getNombre() + 
				" Precio: " + precio +
				" Película: " +  pelicula.getIdPelicula();
	}
	
}
