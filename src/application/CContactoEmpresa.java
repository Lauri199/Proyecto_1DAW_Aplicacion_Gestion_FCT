package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CContactoEmpresa {
	
	@FXML
	private Button add;
	
	@FXML
	private TextField Num_Convenio;
	
	@FXML
	private TextField NIF;
	
	@FXML
	private TextField Nombre_Empresa;
	
	@FXML
	private TextField Representante_Empresa;
	
	@FXML
	private TextField Localidad;
	
	@FXML
	private TextField Provincia;
	
	@FXML
	private TextField Pais;
	
	@FXML
	private TextField Calle;
	
	@FXML
	private TextField Codigo_postal;
	
	@FXML
	private TextField CIF;
	
	@FXML
	private TextField Telefono ;
	
	@FXML
	private TextField Fax;
	
	@FXML
	private TextField CiudadFirmaConvenio;
	
	@FXML
	private TextField FechaFirmaConvenio;
	
	
TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private Empresa empresa;
    private boolean okClicked = false;

    public void setStageSecundario(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}
	
	
	public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;

        Num_Convenio.setText(empresa.getNum_convenio());
        NIF.setText(empresa.getNif());
        Nombre_Empresa.setText(empresa.getNombre());
        Representante_Empresa.setText(empresa.getRepresentante());
        Localidad.setText(empresa.getLocalidad());
        Provincia.setText(empresa.getProvincia());
        Pais.setText(empresa.getPais());
        Calle.setText(empresa.getCalle());
        Codigo_postal.setText(empresa.getCodigo_postal());
        CIF.setText(empresa.getCif());
        Telefono.setText(empresa.getTelefono());
        Fax.setText(empresa.getFax());
        CiudadFirmaConvenio.setText(empresa.getCiudad_firma_convenio());
        FechaFirmaConvenio.setText(empresa.getFecha_firma_convenio());
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }

    
    @FXML
    private void handleOk() {
    	if (isInputValid()) {
    		empresa.setNum_convenio(Num_Convenio.getText());
    		empresa.setNif(NIF.getText());
    		empresa.setNombre(Nombre_Empresa.getText());
    		empresa.setRepresentante(Representante_Empresa.getText());
    		empresa.setLocalidad(Localidad.getText());
    		empresa.setProvincia(Provincia.getText());
    		empresa.setPais(Pais.getText());
    		empresa.setCalle(Calle.getText());
    		empresa.setCodigo_postal(Codigo_postal.getText());
    		empresa.setCif(CIF.getText());
    		empresa.setTelefono(Telefono.getText());
    		empresa.setFax(Fax.getText());
    		empresa.setCiudad_firma_convenio(CiudadFirmaConvenio.getText());
    		empresa.setFecha_firma_convenio(FechaFirmaConvenio.getText());

            okClicked = true;
            ventanaTres.close();
        }
    }

    @FXML
    private void handleCancel() {
    	ventanaTres.close();
    }
    
    /*@FXML
    private void InsertarEmpresa() throws SQLException {
    	conexionbbdd = new TestConexion();
		try {
			conexionbbdd.InsertCiclo(Num_Convenio.getText(), NIF.getText(), Nombre_Empresa.getText(), Representante_Empresa.getText(), Localidad.getText(), Provincia.getText(), Pais.getText(), Calle.getText(), Codigo_postal.getText(), CIF.getText(), Telefono.getText(), Fax.getText(), CiudadFirmaConvenio.getText(), FechaFirmaConvenio.getText());
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		this.ventanaTres.close();

    }*/

    
    private boolean isInputValid() {
        String errorMessage = "";

        if (Num_Convenio.getText() == null || Num_Convenio.getText().length() == 0) {
            errorMessage += "Numero convenio no v�lido!\n";
        }
        if (NIF.getText() == null || NIF.getText().length() == 0) {
            errorMessage += "NIF no v�lido!\n";
        }
        if (Nombre_Empresa.getText() == null || Nombre_Empresa.getText().length() != 9) {
            errorMessage += "Nombre de la Empresa no v�lido!\n";
        }
        
        if (Representante_Empresa.getText() == null || Representante_Empresa.getText().length() == 0) {
            errorMessage += "Representante de la Empresa no v�lido!\n";
        }
        if (Localidad.getText() == null || Localidad.getText().length() == 0) {
            errorMessage += "Localidad no v�lida!\n";
        }
        if (Provincia.getText() == null || Provincia.getText().length() != 9) {
            errorMessage += "Provincia no v�lida!\n";
        }
        
        if (Pais.getText() == null || Pais.getText().length() == 0) {
            errorMessage += "Pais no v�lido!\n";
        }
        if (Calle.getText() == null || Calle.getText().length() == 0) {
            errorMessage += "Calle no v�lida!\n";
        }
        if (Codigo_postal.getText() == null || Codigo_postal.getText().length() != 9) {
            errorMessage += "Codigo postal no v�lido!\n";
        }
        if (CIF.getText() == null || CIF.getText().length() != 9) {
            errorMessage += "CIF no v�lido!\n";
        }
        
        if (Telefono.getText() == null || Telefono.getText().length() == 0) {
            errorMessage += "Telefono no v�lido!\n";
        }
        if (Fax.getText() == null || Fax.getText().length() == 0) {
            errorMessage += "Fax no v�lido!\n";
        }
        if (CiudadFirmaConvenio.getText() == null || CiudadFirmaConvenio.getText().length() != 9) {
            errorMessage += "Ciudad de la firma del convenio no v�lida!\n";
        }
        if (FechaFirmaConvenio.getText() == null || FechaFirmaConvenio.getText().length() != 9) {
            errorMessage += "Fecha de la firma del convenio no v�lida!\n";
        }
        
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos incorrectos!!");
            alert.setContentText("Por favor, corrija campos incorrectos");

            alert.showAndWait();
            return false;
        }
    }

}
