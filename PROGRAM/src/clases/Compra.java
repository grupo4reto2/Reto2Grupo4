package clases;

import java.time.LocalDateTime;

public class Compra {

	private int idCompra;
	private Entrada cantidad;
	private Cliente cliente;
	private Cliente dniCliente;
	private LocalDateTime fechaCompra;
	private double importe;
	private double descuento;

	
	public Compra (int idCompra, Entrada cantidad, Cliente cliente, Cliente dniCliente, LocalDateTime fechaCompra,  double importe, double descuento) {

		this.idCompra = idCompra;
		this.cantidad = cantidad;
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

	public Entrada getCantidad() {
		return cantidad;
	}

	public void setCantidad(Entrada cantidad) {
		this.cantidad = cantidad;
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
				" Número entradas: " + cantidad.getcantidad() + 
				" Cliente: " + cliente.getNombre() +
				" DNICliente: " + dniCliente.getDni() +
				" Fecha y hora de la compra: " + fechaCompra +
				" Importe de la compra: " + importe +
				" Descuento aplicado: " + descuento;
				
	}

}
