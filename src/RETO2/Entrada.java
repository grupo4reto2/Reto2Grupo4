package RETO2;

public class Entrada {

	private int idEntrada;
	private Sesion sesion;
	private int numEntradas;
	private double precio;
	private double descuento;
	
	public Entrada (int idEntrada, Sesion sesion, int numEntradas, double precio, double descuento) {
		this.idEntrada = idEntrada;
		this.sesion = sesion;
		this.numEntradas = numEntradas;
		this.precio = precio;
		this.descuento = descuento;
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

	
	public int getNumEntradas() {
		return numEntradas;
	}

	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	@Override 
	
	public String toString() {
		
		return "ID entrada: " + idEntrada +
			   " Sesión: " + sesion.getIdSesion() +
			   " Número de entradas: " + numEntradas +
			   " Precio: " + precio + 
			   " Descuento aplicado: " + descuento;
	}
	
}