package application;

import java.sql.SQLException;
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
        
        okClicked = true;
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }

    @FXML
    private void handleCancel() {
    	ventanaTres.close();
    }
    
    @FXML
    private void InsertarEmpresa() throws SQLException {
    	
		try {
			conexionbbdd = new TestConexion();
			conexionbbdd.InsertEmpresa(Num_Convenio.getText(), NIF.getText(), Nombre_Empresa.getText(), Representante_Empresa.getText(), Localidad.getText(), Provincia.getText(), Pais.getText(), Calle.getText(), Codigo_postal.getText(), CIF.getText(), Telefono.getText(), Fax.getText(), CiudadFirmaConvenio.getText(), FechaFirmaConvenio.getText());
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			isInputValid();
		}

    }

    
    private void isInputValid() {
        String errorMessage = "";

        if (Num_Convenio.getText() == null || Num_Convenio.getText().length() == 0) {
            errorMessage += "Numero convenio no válido!\n";
        }
        if (NIF.getText() == null || NIF.getText().length() == 0) {
            errorMessage += "NIF no válido!\n";
        }
        if (Nombre_Empresa.getText() == null || Nombre_Empresa.getText().length() == 0) {
            errorMessage += "Nombre de la Empresa no válido!\n";
        }
        
        if (Representante_Empresa.getText() == null || Representante_Empresa.getText().length() == 0) {
            errorMessage += "Representante de la Empresa no válido!\n";
        }
        if (Localidad.getText() == null || Localidad.getText().length() == 0) {
            errorMessage += "Localidad no válida!\n";
        }
        if (Provincia.getText() == null || Provincia.getText().length() == 0) {
            errorMessage += "Provincia no válida!\n";
        }
        
        if (Pais.getText() == null || Pais.getText().length() == 0) {
            errorMessage += "Pais no válido!\n";
        }
        if (Calle.getText() == null || Calle.getText().length() == 0) {
            errorMessage += "Calle no válida!\n";
        }
        if (Codigo_postal.getText() == null || Codigo_postal.getText().length() == 0) {
            errorMessage += "Codigo postal no válido!\n";
        }
        if (CIF.getText() == null || CIF.getText().length() == 0) {
            errorMessage += "CIF no válido!\n";
        }
        
        if (Telefono.getText() == null || Telefono.getText().length() == 0) {
            errorMessage += "Telefono no válido!\n";
        }
        if (Fax.getText() == null || Fax.getText().length() == 0) {
            errorMessage += "Fax no válido!\n";
        }
        if (CiudadFirmaConvenio.getText() == null || CiudadFirmaConvenio.getText().length() == 0) {
            errorMessage += "Ciudad de la firma del convenio no válida!\n";
        }
        if (FechaFirmaConvenio.getText() == null || FechaFirmaConvenio.getText().length() == 0) {
            errorMessage += "Fecha de la firma del convenio no válida!\n";
        }
        
        
        if (errorMessage.length() != 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos incorrectos!!");
            alert.setContentText("Por favor, corrija campos incorrectos");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            
        }
    }

}
