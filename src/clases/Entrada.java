package model;

public class Entrada {

	private int idEntrada;
	private int numPersonas;
	private Sesion idSesion;
	private Compra idCompra;
	private LocalDateTime fecHoraIni;
	
	public Entrada (int idEntrada, int numPersonas, Sesion idSesion Compra idCompra, LocalDateTime fecHoraIn) {
		this.idEntrada = idEntrada;
		this.numPersonas = numPersonas;
		this.idSesion = idSesion;
		this.idCompra = idCompra;
		this.fecHoraIni = fecHoraIni;
	}

	
	public LocalDateTime getFecHoraIni() {
		return FecHoraIni;

	public void setFecHoraIni(LocalDateTime getFecHoraIni) {
		this.getFecHoraIni = getFecHoraIni;
		
	public int getIdEntrada() {
		return idEntrada;
	}




	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}


	public Sesion getIdSesion() {
		return sesion;
	}

	public void setIdSesion(Sesion sesion) {
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
				" Número de personas: " + numPersonas + 
			    " Sesión: " + sesion.getIdSesion() +
				" ID de Compra: " + idCompra.getIdCompra() +
				" Fecha de compra: " + fecHoraIni.getFecHoraIni();
			 
	}
	
}
