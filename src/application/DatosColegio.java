package application;
public class DatosColegio {

	/* Esta clase sirve para definir un objeto con todos los datos del Centro que se necesitan para
	 * formatear el Anexo I de FCTs
	 */

	private String nombre; // Nombre director/a del Centro
	private String apellidos; // Apellidos director/a del Centro
	private String NIF; // NIF director/a del Centro
	private String NombreCentro; // Nombre del Centro
	private String CodigoCentro; // Código del Centro
	private String provincia; // Provincia de ubicacion del Centro
	private String direccion; // Dirección de ubicacion del Centro
	private String CP; // Código Postal de ubicacion del Centro
	private String CIF; // CIF del Centro
	private String telefono; // Telefono del Centro
	private String fax; // fax del Centro
	private String ciudad; // ciudad de ubicacion del Centro
	private String DAT; // Dirección del Area Territorial al que pertenece el Centro



	public DatosColegio(String nombre, String apellidos, String nIF, String nombreCentro, String codigoCentro,
			String provincia, String direccion, String cP, String cIF, String telefono, String fax, String ciudad, String DAT) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		NIF = nIF;
		NombreCentro = nombreCentro;
		CodigoCentro = codigoCentro;
		this.provincia = provincia;
		this.direccion = direccion;
		CP = cP;
		CIF = cIF;
		this.telefono = telefono;
		this.fax = fax;
		this.ciudad = ciudad;
		this.DAT = DAT;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public String getNombreCentro() {
		return NombreCentro;
	}
	public void setNombreCentro(String nombreCentro) {
		NombreCentro = nombreCentro;
	}
	public String getCodigoCentro() {
		return CodigoCentro;
	}
	public void setCodigoCentro(String codigoCentro) {
		CodigoCentro = codigoCentro;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCP() {
		return CP;
	}
	public void setCP(String cP) {
		CP = cP;
	}
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
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
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDAT() {
		return DAT;
	}

	public void setDAT(String dAT) {
		DAT = dAT;
	}



}
