package RETO2;

public class Pelicula {

	private int idPelicula;
	private int duracion;
	private String genero;
	private double precio;
	
	public Pelicula (int idPelicula, int duracion, String genero, double precio) {
		this.idPelicula = idPelicula;
		this.duracion = duracion;
		this.genero = genero;
		this.precio = precio;
		
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override 
	
	public String toString() {
		return  "ID: " + idPelicula +
				" Duración: " + duracion + " min" + 
				" Género: " + genero + 
				" Precio: " + precio + " €"; 
	}
	
}