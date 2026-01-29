package clases;

import java.time.LocalDateTime;

public class Compra {

	private int idCompra;
	private LocalDateTime fechaCompra;
	private Cliente dniCliente;
	private double importe;
	private double descuento;
	private int canal;

	

	public Compra (int idCompra, LocalDateTime fechaCompra, Cliente dniCliente,  double importe, double descuento, int canal) {

		this.idCompra = idCompra;
		this.fechaCompra = fechaCompra;
		this.dniCliente = dniCliente;
		this.importe = importe;
		this.descuento = descuento;
		this.canal = canal;
	}
	
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
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

	public int getCanal() {
		return canal;
	}
	
	public void setCanal(int canal) {
		this.canal = canal;
	}
	

}
