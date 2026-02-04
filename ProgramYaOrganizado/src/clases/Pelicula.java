package clases;

public class Pelicula {
	private int idPelicula;
	private String nomPelicula;
	private int duracion;
	private Genero idGenero;
	private String Portada;
	

	public Pelicula (int idPelicula, String nomPelicula, int duracion, Genero idGenero, String Portada) {
		this.idPelicula = idPelicula;
		this.nomPelicula = nomPelicula;
		this.duracion = duracion;
		this.idGenero = idGenero;
		this.Portada = Portada;
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

	public Genero getidGenero() {
		return idGenero;
	}

	public void setidGenero(Genero idGenero) {
		this.idGenero = idGenero;
	}

	public String getPortada() {
		return Portada;
	}
	
	public void setPortada(String Portada) {
		this.Portada = Portada;
	}
	
	
	
}

