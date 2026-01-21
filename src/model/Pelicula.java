package model;

public class Pelicula {

	private int idPelicula;
<<<<<<< HEAD
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
=======
	private String nomPelicula;
	private int duracion;
	private int idGenero;
	private String nomGenero;
	
	public Pelicula (int idPelicula, String nomPelicula, int duracion, int idGenero, String nomGenero) {
		this.idPelicula = idPelicula;
		this.nomPelicula = nomPelicula;
		this.duracion = duracion;
		this.idGenero = idGenero;
		this.nomGenero = nomGenero;
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
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

<<<<<<< HEAD
	public String getCodPelicula(String codPelicula) {
		return codPelicula;
	}

	public void getCodPelicula(){
		this.codPelicula = codPelicula;
	}

=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

<<<<<<< HEAD
	public String getidGenero() {
		return idGenero;
	}

	public void setidGenero(String idGenero) {
=======
	public int getidGenero() {
		return idGenero;
	}

	public void setidGenero(int idGenero) {
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
		this.idGenero = idGenero;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Pelicula [idPelicula=" + idPelicula + ",codPelicula=" + codPelicula + ",nomPelicula=" + nomPelicula + ", duracion=" + duracion
				+ ", idGenero=" + idGenero + ", nomGenero=" + nomGenero + ", getNomGenero()=" + getNomGenero()
				+ ", getNomPelicula()=" + getNomPelicula() + ", getCodPelicula()=" + getCodPelicula() + ", getIdPelicula()=" + getIdPelicula() + ", getDuracion()=" + getDuracion()
				+ ", getidGenero()=" + getidGenero() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


=======
		return "Pelicula [idPelicula=" + idPelicula + ",nomPelicula=" + nomPelicula + ", duracion=" + duracion
				+ ", idGenero=" + idGenero + ", nomGenero=" + nomGenero + ", getNomGenero()=" + getNomGenero()
				+ ", getNomPelicula()=" + getNomPelicula() +  ", getIdPelicula()=" + getIdPelicula() + ", getDuracion()=" + getDuracion()
				+ ", getidGenero()=" + getidGenero() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	
	
}
