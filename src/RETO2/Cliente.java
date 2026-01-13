package RETO2;

public class Cliente {

	private String dni;
	private String nombreApellidos;
	private String correo;
	private String contraseña;
	
	public Cliente (String dni, String nombreApellidos, String correo, String contraseña) {
		this.dni = dni;
		this.nombreApellidos = nombreApellidos;
		this.correo = correo;
		this.contraseña = contraseña;
	}


	
	
	

	public String getDni() {
		return dni;
	}






	public void setDni(String dni) {
		this.dni = dni;
	}





	public String getNombreApellidos() {
		return nombreApellidos;
	}






	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}






	public String getCorreo() {
		return correo;
	}






	public void setCorreo(String correo) {
		this.correo = correo;
	}






	public String getContraseña() {
		return contraseña;
	}






	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}






	@Override 
	
	public String toString() {
		return  "DNI: " + dni +
				" Cliente: " + nombreApellidos +
				" Correo electrónico: " + correo + 
				" Contraseña: " + contraseña;
	}
	
}
