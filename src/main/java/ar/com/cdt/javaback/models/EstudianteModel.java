package ar.com.cdt.javaback.models;

public class EstudianteModel {

	public Long id;
	public String nombre;
	public String apellido;
	public long DNI;
	public int edad;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public long getDNI() {
		return DNI;
	}
	public void setDNI(long dni) {
		this.DNI = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "EstudianteModel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI
				+ ", edad=" + edad + "]";
	}
	
	
}
