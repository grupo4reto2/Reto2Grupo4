package model;

public class Entrada {

	private int idEntrada;
<<<<<<< HEAD
	private Sesion sesion;
	private int numPersonas;
	private Compra idCompra;
	
	public Entrada (int idEntrada, Sesion sesion, int numPersonas, Compra idCompra) {
		this.idEntrada = idEntrada;
		this.sesion = sesion;
		this.numPersonas = numPersonas;
		this.idCompra = idCompra;
	}

	

	
=======
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
		
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public int getIdEntrada() {
		return idEntrada;
	}




	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}


<<<<<<< HEAD


	public Sesion getSesion() {
		return sesion;
	}




	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}




=======
	public Sesion getIdSesion() {
		return sesion;
	}

	public void setIdSesion(Sesion sesion) {
		this.sesion = sesion;
	}

>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public int getNumPersonas() {
		return numPersonas;
	}

<<<<<<< HEAD



=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

<<<<<<< HEAD



=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public Compra getIdCompra() {
		return idCompra;
	}

<<<<<<< HEAD



=======
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
	public void setIdCompra(Compra idCompra) {
		this.idCompra = idCompra;
	}




	@Override 
	
	public String toString() {
		
		return "ID entrada: " + idEntrada +
<<<<<<< HEAD
			   " Sesión: " + sesion.getIdSesion() +
			   " Número de personas: " + numPersonas + 
				" ID de Compra: " + idCompra.getIdCompra();
=======
				" Número de personas: " + numPersonas + 
			    " Sesión: " + sesion.getIdSesion() +
				" ID de Compra: " + idCompra.getIdCompra() +
				" Fecha de compra: " + fecHoraIni.getFecHoraIni();
>>>>>>> 356c0af2a9002f4886ce81a2a86301de0d10891e
			 
	}
	
}
