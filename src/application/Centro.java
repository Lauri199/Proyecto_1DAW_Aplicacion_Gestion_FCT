package application;

public class Centro {
	
	String cod_centro;
	String representante_centro;
	String nif;
	String nombrecentro;
	String ciudad;
	String provincia;
	String calle;
	String codigo_postal;
	String cif;
	String telefono;
	String fax;
	String dat;
	
	public Centro(String cod_centro, String representante_centro, String nif, String nombrecentro, String ciudad,
			String provincia, String calle, String codigo_postal, String cif, String telefono, String fax, String dat) {
		super();
		this.cod_centro = cod_centro;
		this.representante_centro = representante_centro;
		this.nif = nif;
		this.nombrecentro = nombrecentro;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.calle = calle;
		this.codigo_postal = codigo_postal;
		this.cif = cif;
		this.telefono = telefono;
		this.fax = fax;
		this.dat = dat;
	}

	public String getCod_centro() {
		return cod_centro;
	}

	public void setCod_centro(String cod_centro) {
		this.cod_centro = cod_centro;
	}

	public String getRepresentante_centro() {
		return representante_centro;
	}

	public void setRepresentante_centro(String representante_centro) {
		this.representante_centro = representante_centro;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombrecentro() {
		return nombrecentro;
	}

	public void setNombrecentro(String nombrecentro) {
		this.nombrecentro = nombrecentro;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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

	public String getDat() {
		return dat;
	}

	public void setDat(String dat) {
		this.dat = dat;
	}
	
	
	
	

}
