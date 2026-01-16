package RETO2;

public class Cliente {

	private String dni;
	private String nombre
	private string apellido;
	private String correo;
	private String contrasena;
	
	public Cliente (String dni, String nombre, String apellido, String correo, String contrasena) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
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

	public String getcontrasena() {
		return contrasena;
	}

	public void setcontrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override 
	
	public String toString() {
		return  "DNI: " + dni +
				" Cliente: " + nombre + apellido +
				" Correo electrónico: " + correo + 
				" contrasena: " + contrasena;
	}
	
}
