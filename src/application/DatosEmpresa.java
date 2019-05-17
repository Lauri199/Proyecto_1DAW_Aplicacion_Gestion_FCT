package application;
public class DatosEmpresa {

	private String nombreemp; // Nombre del representante de la empresa
	private String apellidosemp; // Apellidos del representante de la empresa
	private String NIFEmp; // NIF del representante de la empresa
	private String Nombreempresa; // Nombre de la empresa
	private String CodigoConvenio;
	private String provinciaemp;
	private String direccionemp ;
	private String CPEmp;
	private String CIFEmp;
	private String telefonoEmp ;
	private String faxEmp;
	private String ciudadEmp;


	public DatosEmpresa(String nombreemp, String apellidosemp, String nIFEmp, String CodigoConvenio,
			String Nombreempresa, String provinciaemp, String direccionemp, String cPEmp, String cIFEmp,
			String telefonoEmp, String faxEmp, String ciudadEmp) {
		super();
		this.nombreemp = nombreemp;
		this.apellidosemp = apellidosemp;
		this.NIFEmp = nIFEmp;
		this.Nombreempresa = Nombreempresa;
		this.CodigoConvenio = CodigoConvenio;
		this.provinciaemp = provinciaemp;
		this.direccionemp = direccionemp;
		CPEmp = cPEmp;
		CIFEmp = cIFEmp;
		this.telefonoEmp = telefonoEmp;
		this.faxEmp = faxEmp;
		this.ciudadEmp = ciudadEmp;
	}


	public String getNombreemp() {
		return nombreemp;
	}


	public void setNombreemp(String nombreemp) {
		this.nombreemp = nombreemp;
	}


	public String getApellidosemp() {
		return apellidosemp;
	}


	public void setApellidosemp(String apellidosemp) {
		this.apellidosemp = apellidosemp;
	}


	public String getNIFEmp() {
		return NIFEmp;
	}


	public void setNIFEmp(String nIFEmp) {
		NIFEmp = nIFEmp;
	}


	public String getNombreEmpresa() {
		return this.Nombreempresa;
	}


	public void setNombreEmpresa(String nombreempresa) {
		this.Nombreempresa = nombreempresa;
	}


	public String getCodigoConvenio() {
		return CodigoConvenio;
	}


	public void setCodigoCentroemp(String CodigoConvenio) {
		this.CodigoConvenio = CodigoConvenio;
	}


	public String getProvinciaemp() {
		return provinciaemp;
	}


	public void setProvinciaemp(String provinciaemp) {
		this.provinciaemp = provinciaemp;
	}


	public String getDireccionemp() {
		return direccionemp;
	}


	public void setDireccionemp(String direccionemp) {
		this.direccionemp = direccionemp;
	}


	public String getCPEmp() {
		return CPEmp;
	}


	public void setCPEmp(String cPEmp) {
		this.CPEmp = cPEmp;
	}


	public String getCIFEmp() {
		return CIFEmp;
	}


	public void setCIFEmp(String cIFEmp) {
		this.CIFEmp = cIFEmp;
	}


	public String getTelefonoEmp() {
		return telefonoEmp;
	}


	public void setTelefonoEmp(String telefonoEmp) {
		this.telefonoEmp = telefonoEmp;
	}


	public String getFaxEmp() {
		return faxEmp;
	}


	public void setFaxEmp(String faxEmp) {
		this.faxEmp = faxEmp;
	}


	public String getCiudadEmp() {
		return ciudadEmp;
	}


	public void setCiudadEmp(String ciudadEmp) {
		this.ciudadEmp = ciudadEmp;
	}



}
