package ar.com.cdt.javaback.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "estudianteentity")
public class EstudianteEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	@NotNull
	public String nombre;
	@NotNull
	public String apellido;
	@NotNull
	public long DNI;
	@NotNull
	public int edad;
	
	public EstudianteEntity() {
		super();
	}
	public EstudianteEntity(Long id, String nombre, String apellido, long dni, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = dni;
		this.edad = edad;
	}
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
		DNI = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "EstudianteEntity [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI
				+ ", edad=" + edad + "]";
	}

}
