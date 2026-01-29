package clases;

public class Cliente {

	private String dni;
	private String nombre;
	private String apellido;
	private String correo;
	private String contraseña;
	
	public Cliente (String dni, String nombre, String apellido, String correo, String contraseña) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
		
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contraseña;
	}

	public void setContraseña(String contrasena) {
		this.contraseña = contrasena;
	}

	@Override 
	
	public String toString() {
		return  "DNI: " + dni + "\n" +
				" Cliente: " + nombre + " " + apellido + "\n" +
				" Correo electrónico: " + correo+ "\n" +
				" Contrasena: " + contraseña;
	}
	
}
