package application;

public class TutorEmpresa {
	
	String dni;
	String nombre;
	String apellido;
	String telefono;
	String gmail;
	String num_convenio;
	
	
	public TutorEmpresa(String dni, String nombre, String apellido, String telefono, String gmail,
			String num_convenio) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.gmail = gmail;
		this.num_convenio = num_convenio;
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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}


	public String getNum_convenio() {
		return num_convenio;
	}


	public void setNum_convenio(String num_convenio) {
		this.num_convenio = num_convenio;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
