package model;

import java.time.LocalDateTime;

public class Compra {

	private int idCompra;
	private Entrada numEntradas;
	private Cliente cliente;
	private Cliente dniCliente;
	private LocalDateTime fechaCompra;
	private double importe;
	private double descuento;

	
	public Compra (int idCompra, Entrada numEntradas, Cliente cliente, Cliente dniCliente, LocalDateTime fechaCompra,  double importe, double descuento) {

		this.idCompra = idCompra;
		this.numEntradas = numEntradas;
		this.cliente = cliente;
		this.dniCliente = dniCliente;
		this.fechaCompra = fechaCompra;
		this.importe = importe;
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

	public Cliente getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(Cliente dniCliente) {
		this.dniCliente = dniCliente;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	public double getImporte() {
		return importe;
	}
	
	public void setImporte(double importe) {
		this.importe = importe;
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
				" Número entradas: " + numEntradas.getNumPersonas() + 
				" Cliente: " + cliente.getNombre() +
				" DNICliente: " + dniCliente.getDni() +
				" Fecha y hora de la compra: " + fechaCompra +
				" Importe de la compra: " + importe +
				" Descuento aplicado: " + descuento;
				
	}

}
