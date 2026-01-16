package RETO2;

public class Pelicula {

	private int idPelicula;
	private String nomPelicula;
	private int duracion;
	private String idGenero;
	private String nomGenero;
	
	public Pelicula (int idPelicula, int duracion, String IDidGenero, String nomPelicula,  String nomGenero) {
		this.idPelicula = idPelicula;
		this.duracion = duracion;
		this.idGenero = idGenero;
		this.nomPelicula = nomPelicula;
		this.nomGenero = nomGenero;  
	}

	public String nomGenero() {
		return nomGenero;
	}

	public void nomGenero(String nomGenero) {
		this.nomGenero = nomGenero;
	}
	
	public String nomPelicula() {
		return nomPelicula;
	}
	
	public void nomPelicula(String nomPelicula) {
		this.nomPelicula = nomPelicula;
	}

	public int getId() {
		return idPelicula;
	}

	public void setId(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getidGenero() {
		return idGenero;
	}

	public void setidGenero(String idGenero) {
		this.idGenero = idGenero;
	}


	
	@Override 
	
	public String toString() {
		return  " ID: " + idPelicula +
				" Pelicula " + nomPelicula +
				" Duración: " + duracion + " min" + 
				" Género: " + idGenero + genero + 
	}
	
}
