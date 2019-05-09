package application;

public class Empresa {
	
	String num_convenio;
	String nif;
	String nombre;
	String representante;
	String localidad;
	String provincia;
	String pais;
	String calle;
	String codigo_postal;
	String cif;
	String telefono;
	String fax;
	String ciudad_firma_convenio;
	String fecha_firma_convenio;
	
	
	public Empresa(String num_convenio, String nif, String nombre, String representante, String localidad,
			String provincia, String pais, String calle, String codigo_postal, String cif, String telefono, String fax,
			String ciudad_firma_convenio, String fecha_firma_convenio) {
		super();
		this.num_convenio = num_convenio;
		this.nif = nif;
		this.nombre = nombre;
		this.representante = representante;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
		this.calle = calle;
		this.codigo_postal = codigo_postal;
		this.cif = cif;
		this.telefono = telefono;
		this.fax = fax;
		this.ciudad_firma_convenio = ciudad_firma_convenio;
		this.fecha_firma_convenio = fecha_firma_convenio;
	}


	public String getNum_convenio() {
		return num_convenio;
	}


	public void setNum_convenio(String num_convenio) {
		this.num_convenio = num_convenio;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRepresentante() {
		return representante;
	}


	public void setRepresentante(String representante) {
		this.representante = representante;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getCodigo_postal() {
		return codigo_postal;
	}


	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}


	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getCiudad_firma_convenio() {
		return ciudad_firma_convenio;
	}


	public void setCiudad_firma_convenio(String ciudad_firma_convenio) {
		this.ciudad_firma_convenio = ciudad_firma_convenio;
	}


	public String getFecha_firma_convenio() {
		return fecha_firma_convenio;
	}


	public void setFecha_firma_convenio(String fecha_firma_convenio) {
		this.fecha_firma_convenio = fecha_firma_convenio;
	}
	
	
	
	
	

}
