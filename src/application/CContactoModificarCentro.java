package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CContactoModificarCentro {
	
	@FXML
	private Button add;
	
	@FXML
	private TextField Cod_Centro;
	
	@FXML
	private TextField Representante_Centro;
	
	@FXML
	private TextField NIF;
	
	@FXML
	private TextField NombreCentro;
	
	@FXML
	private TextField Ciudad;
	
	@FXML
	private TextField Provincia;
	
	@FXML
	private TextField Calle;
	
	@FXML
	private TextField Codigo_Postal;
	
	@FXML
	private TextField CIF;
	
	@FXML
	private TextField Telefono;
	
	@FXML
	private TextField Fax;
	
	@FXML
	private TextField DAT;

	
	TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private Centro centro;
    private boolean okClicked = false;

    public void setStageSecundario(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}
	
	
	public void setCentro(Centro centro) {
        this.centro = centro;

        Cod_Centro.setText(centro.getCod_centro());
        Representante_Centro.setText(centro.getRepresentante_centro());
        NIF.setText(centro.getNif());
        NombreCentro.setText(centro.getNombrecentro());
        Ciudad.setText(centro.getCiudad());
        Provincia.setText(centro.getProvincia());
        Calle.setText(centro.getCalle());
        Codigo_Postal.setText(centro.getCodigo_postal());
        CIF.setText(centro.getCif());
        Telefono.setText(centro.getTelefono());
        Fax.setText(centro.getFax());
        DAT.setText(centro.getDat());
        
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
    private void ModificarCentro() throws SQLException {
    	conexionbbdd = new TestConexion();
		try {
			conexionbbdd.ModificarCentro(Cod_Centro.getText(), Representante_Centro.getText(), NIF.getText(), NombreCentro.getText(), Ciudad.getText(), Provincia.getText(), Calle.getText(), Codigo_Postal.getText(), CIF.getText(), Telefono.getText(), Fax.getText(), DAT.getText());
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			isInputValid();
		}

    }

    
    private void isInputValid() {
        String errorMessage = "";

        if (Cod_Centro.getText() == null || Cod_Centro.getText().length() == 0) {
            errorMessage += "Codigo de centro no válido!\n";
        }
        if (Representante_Centro.getText() == null || Representante_Centro.getText().length() == 0) {
            errorMessage += "Representante del centro no válido!\n";
        }
        if (NIF.getText() == null || NIF.getText().length() == 0) {
            errorMessage += "NIF no válido!\n";
        }
        
        if (NombreCentro.getText() == null || NombreCentro.getText().length() == 0) {
            errorMessage += "Nombre del centro no válido!\n";
        }
        if (Ciudad.getText() == null || Ciudad.getText().length() == 0) {
            errorMessage += "Ciudad no válida!\n";
        }
        
        if (Provincia.getText() == null || Provincia.getText().length() == 0) {
            errorMessage += "Provincia no válida!\n";
        }
        
        if (Calle.getText() == null || Calle.getText().length() == 0) {
            errorMessage += "Calle no válida!\n";
        }
        if (Codigo_Postal.getText() == null || Codigo_Postal.getText().length() == 0) {
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
        
        if (DAT.getText() == null || DAT.getText().length() == 0) {
            errorMessage += "DAT no válido!\n";
        }
        
        
        if (errorMessage.length() != 0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos incorrectos!!");
            alert.setContentText("Por favor, corrija campos incorrectos");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            
        }
    }

}
