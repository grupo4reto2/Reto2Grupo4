package clases;

public class Pelicula {
	private int idPelicula;
	private String nomPelicula;
	private int duracion;
	private int idGenero;
	private String nomGenero;
	private String Portada;
	

	public Pelicula (int idPelicula, String nomPelicula, int duracion, int idGenero, String nomGenero, String Portada) {
		this.idPelicula = idPelicula;
		this.nomPelicula = nomPelicula;
		this.duracion = duracion;
		this.idGenero = idGenero;
		this.nomGenero = nomGenero;
		this.Portada = Portada;
	}

	public String getNomGenero() {
		return nomGenero;
	}

	public void getNomGenero(String nomGenero) {
		this.nomGenero = nomGenero;
	}
	
	public String getNomPelicula() {
		return nomPelicula;
	}
	
	public void setNomPelicula(String nomPelicula) {
		this.nomPelicula = nomPelicula;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getidGenero() {
		return idGenero;
	}

	public void setidGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getPortada() {
		return Portada;
	}
	
	public void setPortada(String Portada) {
		this.Portada = Portada;
	}
	
	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ",nomPelicula=" + nomPelicula + ", duracion=" + duracion
				+ ", idGenero=" + idGenero + ", nomGenero=" + nomGenero + ", getNomGenero()=" + getNomGenero()
				+ ", getNomPelicula()=" + getNomPelicula() +  ", getIdPelicula()=" + getIdPelicula() + ", getDuracion()=" + getDuracion()
				+ ",getPortada()=" + getPortada() + ", getidGenero()=" + getidGenero() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}

