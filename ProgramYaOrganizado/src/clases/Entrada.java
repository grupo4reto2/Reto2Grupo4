package clases;

import java.time.LocalDateTime;


public class Entrada {

	private int idEntrada;
	private int cantidad;
	private Sesion sesion;
	private Compra idCompra;
	private LocalDateTime fecHoraIni;
	
	public Entrada (int idEntrada, int cantidad, Sesion sesion, Compra idCompra, LocalDateTime fecHoraIni) {
		this.idEntrada = idEntrada;
		this.cantidad = cantidad;
		this.sesion = sesion;
		this.idCompra = idCompra;
		this.fecHoraIni = fecHoraIni;
	}

	
	public LocalDateTime getfecHoraIni() {
		return fecHoraIni;
	}
	public void setfecHoraIni(LocalDateTime fecHoraIni) {
		this.fecHoraIni = fecHoraIni;
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

	public int getcantidad() {
		return cantidad;
	}

	public void setcantidad(int cantidad) {
		this.cantidad = cantidad;
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
				" Número de personas: " + cantidad + 
			    " Sesión: " + sesion.getIdSesion() +
				" ID de Compra: " + idCompra.getIdCompra() +
				" Fecha de compra: " + fecHoraIni;
			 
	}
	

	}
