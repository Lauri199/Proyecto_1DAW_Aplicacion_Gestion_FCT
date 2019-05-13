package application;

public class Alumno {
	
	String dni_alum;
	String nombre;
	String apellido;
	String tiempo_empleado;
	String dni_tc;
	String dni_te;
	
	
	public Alumno(String dni_alum, String nombre, String apellido, String tiempo_empleado, String dni_tc,
			String dni_te) {
		super();
		this.dni_alum = dni_alum;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tiempo_empleado = tiempo_empleado;
		this.dni_tc = dni_tc;
		this.dni_te = dni_te;
	}


	public String getDni_alum() {
		return dni_alum;
	}


	public void setDni_alum(String dni_alum) {
		this.dni_alum = dni_alum;
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


	public String getTiempo_empleado() {
		return tiempo_empleado;
	}


	public void setTiempo_empleado(String tiempo_empleado) {
		this.tiempo_empleado = tiempo_empleado;
	}


	public String getDni_tc() {
		return dni_tc;
	}


	public void setDni_tc(String dni_tc) {
		this.dni_tc = dni_tc;
	}


	public String getDni_te() {
		return dni_te;
	}


	public void setDni_te(String dni_te) {
		this.dni_te = dni_te;
	}
	
	

}
