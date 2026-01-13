package RETO2;

import java.time.LocalDateTime;



public class Compra {



	private int idCompra;

	private Entrada numEntradas;

	private Cliente cliente;

	private LocalDateTime fechaHora;

	private double precio;

	private double descuento;

	

	public Compra (int idCompra, Entrada numEntradas, Cliente cliente, LocalDateTime fechaHora, double precio, double descuento) {

		this.idCompra = idCompra;

		this.numEntradas = numEntradas;

		this.cliente = cliente;

		this.fechaHora = fechaHora;

		this.precio = precio;

		this.descuento = descuento;

	}

	


	public int getIdCompra() {

		return idCompra;

	}



	public void setIdCompra(int idCompra) {

		this.idCompra = idCompra;

	}



	public Entrada getNumEntradas() {

		return numEntradas;

	}



	public void setNumEntradas(Entrada numEntradas) {

		this.numEntradas = numEntradas;

	}



	public Cliente getCliente() {

		return cliente;

	}



	public void setCliente(Cliente cliente) {

		this.cliente = cliente;

	}



	public LocalDateTime getFechaHora() {

		return fechaHora;

	}



	public void setFechaHora(LocalDateTime fechaHora) {

		this.fechaHora = fechaHora;

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
	

		return "ID compra: " + idCompra +

				" Número entradas: " + numEntradas.getNumEntradas() + 

				" Cliente: " + cliente.getNombreApellidos() +

				" Fecha y hora de la compra: " + fechaHora + 

				" Descuento aplicado: " + descuento;

	}

	

}