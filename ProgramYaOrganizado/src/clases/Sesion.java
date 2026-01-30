package clases;
import java.time.LocalDateTime;
public class Sesion {

	private int idSesion;
	private String codSesion;
	private LocalDateTime fecHoraIni;
	private LocalDateTime fecHoraFin;
	private double precio;
	private Sala idSala;
	private Pelicula idPelicula;
	
	public Sesion (int idSesion, String codSesion, LocalDateTime fecHoraIni, LocalDateTime fecHoraFin,  double precio, Sala idSala, Pelicula idPelicula) {
		this.idSesion = idSesion;
		this.codSesion = codSesion;
		this.fecHoraIni = fecHoraIni;
		this.fecHoraFin = fecHoraFin;
		this.precio = precio;
		this.idSala = idSala;
		this.idPelicula = idPelicula;

		}

	
	public Pelicula getIDPelicula() {
		return idPelicula;
	}

	public void setIDPelicula(Pelicula idPelicula) {
		this.idPelicula= idPelicula;
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
				" Película: " +  idPelicula.getIdPelicula();
	}
	
}
