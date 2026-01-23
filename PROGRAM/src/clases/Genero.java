package clases;



public class Genero {

	private int idGenero;

	private String nomGenero;


	public Genero (int idGenero, String nomGenero) {

		this.idGenero = idGenero;

		this.nomGenero = nomGenero;

	}
	
	public int getIdGenero() {

		return idGenero;

	}

	public void setIdGenero(int idGenero) {

		this.idGenero = idGenero;

	}



	public String getNomGenero() {

		return nomGenero;

	}



	public void setNomGenero(String nomGenero) {

		this.nomGenero = nomGenero;

	}

}