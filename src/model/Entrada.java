package model;

public class Entrada {

	private int idEntrada;
	private Sesion sesion;
	private int numPersonas;
	private Compra idCompra;
	
	public Entrada (int idEntrada, Sesion sesion, int numPersonas, Compra idCompra) {
		this.idEntrada = idEntrada;
		this.sesion = sesion;
		this.numPersonas = numPersonas;
		this.idCompra = idCompra;
	}

	

	
	public int getIdEntrada() {
		return idEntrada;
	}




	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}




	public Sesion getSesion() {
		return sesion;
	}




	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}




	public int getNumPersonas() {
		return numPersonas;
	}




	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}




	public Compra getIdCompra() {
		return idCompra;
	}




	public void setIdCompra(Compra idCompra) {
		this.idCompra = idCompra;
	}




	@Override 
	
	public String toString() {
		
		return "ID entrada: " + idEntrada +
			   " Sesión: " + sesion.getIdSesion() +
			   " Número de personas: " + numPersonas + 
				" ID de Compra: " + idCompra.getIdCompra();
			 
	}
	
}
