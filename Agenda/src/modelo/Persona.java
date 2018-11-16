package modelo;

public class Persona {
	
	 private String nombre;
	 private int edad;
	 private String telefono;
	 private String correo;
	 private Genero genero;
	 
	public Persona(String nombre, int edad, String telefono, String correo, Genero genero) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", telefono=" + telefono + ", correo=" + correo
				+ ", genero=" + genero + "]";
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
