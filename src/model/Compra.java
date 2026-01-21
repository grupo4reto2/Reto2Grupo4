package model;

import java.time.LocalDateTime;

public class Compra {

	private int idCompra;
<<<<<<< HEAD

	private Entrada numEntradas;

	private Cliente cliente;

	private LocalDateTime fechaCompra;

	private double importe;

	private double descuento;

	
	public Compra (int idCompra, Entrada numEntradas, Cliente nomCliente, Cliente cliente, LocalDateTime fechaCompra,  double importe, double descuento) {

		this.idCompra = idCompra;

		this.numEntradas = numEntradas;

		this.cliente = cliente;

		this.fechaCompra = fechaCompra;

		this.importe = importe;

		this.descuento = descuento;
		
	}


	



=======
	private Entrada numEntradas;
	private Cliente cliente;
	private String dniCliente
	private LocalDateTime fechaCompra;
	private double importe;
	private double descuento;

	
	public Compra (int idCompra, Entrada numEntradas, Cliente cliente, String dniCliente, LocalDateTime fechaCompra,  double importe, double descuento) {

		this.idCompra = idCompra;
		this.numEntradas = numEntradas;
		this.cliente = cliente;
		this.dniCliente = dniCliente;
		this.fechaCompra = fechaCompra;
		this.importe = importe;
		this.descuento = descuento;
		
	}
	
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public int getIdCompra() {
		return idCompra;
	}

<<<<<<< HEAD





=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

<<<<<<< HEAD





=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public Entrada getNumEntradas() {
		return numEntradas;
	}

<<<<<<< HEAD





=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public void setNumEntradas(Entrada numEntradas) {
		this.numEntradas = numEntradas;
	}

<<<<<<< HEAD





=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public Cliente getCliente() {
		return cliente;
	}

<<<<<<< HEAD





=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

<<<<<<< HEAD




=======
	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

<<<<<<< HEAD





	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}






	public double getImporte() {
		return importe;
	}






=======
	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	public double getImporte() {
		return importe;
	}
	
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public void setImporte(double importe) {
		this.importe = importe;
	}

<<<<<<< HEAD





=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public double getDescuento() {
		return descuento;
	}

<<<<<<< HEAD





=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

<<<<<<< HEAD





=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	@Override 

	public String toString() {
		
		return "ID compra: " + idCompra +
				" Número entradas: " + numEntradas.getNumPersonas() + 
<<<<<<< HEAD
				" Cliente: " + cliente.getNombre() + " " + cliente.getApellido() +
				" DNICliente: " + cliente.getDni() +
				" Fecha y hora de la compra: " + fechaCompra +
=======
				" Cliente: " + cliente.getCliente() +
				" DNICliente: " + cliente.getDniCliente() +
				" Fecha y hora de la compra: " + fechaCompra.getFechaCompra() +
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
				" Importe de la compra: " + importe +
				" Descuento aplicado: " + descuento;
				
	}

}
