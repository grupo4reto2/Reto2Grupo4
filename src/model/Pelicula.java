package model;

public class Pelicula {

	private int idPelicula;
	private String codPelicula;
	private String nomPelicula;
	private int duracion;
	private String idGenero;
	private String nomGenero;
	
	public Pelicula (int idPelicula, String codPelicula, int duracion, String IDidGenero, String nomPelicula,  String nomGenero) {
		this.idPelicula = idPelicula;
		this.codPelicula = codPelicula;
		this.duracion = duracion;
		this.idGenero = idGenero;
		this.nomPelicula = nomPelicula;
		this.nomGenero = nomGenero;  
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

	public String getCodPelicula(String codPelicula) {
		return codPelicula;
	}

	public void getCodPelicula(){
		this.codPelicula = codPelicula;
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
		return "Pelicula [idPelicula=" + idPelicula + ",codPelicula=" + codPelicula + ",nomPelicula=" + nomPelicula + ", duracion=" + duracion
				+ ", idGenero=" + idGenero + ", nomGenero=" + nomGenero + ", getNomGenero()=" + getNomGenero()
				+ ", getNomPelicula()=" + getNomPelicula() + ", getCodPelicula()=" + getCodPelicula() + ", getIdPelicula()=" + getIdPelicula() + ", getDuracion()=" + getDuracion()
				+ ", getidGenero()=" + getidGenero() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
	
}
