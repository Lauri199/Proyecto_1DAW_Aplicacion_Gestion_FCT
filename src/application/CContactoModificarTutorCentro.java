package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CContactoModificarTutorCentro {
	
	@FXML
	private Button add;
	
	@FXML
	private TextField DNI_TC;
	
	@FXML
	private TextField Nombre;
	
	@FXML
	private TextField Apellido;
	
	@FXML
	private TextField Telefono;
	
	@FXML
	private TextField Gmail;

	
	TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private TutorCentro tutorcentro;
    private boolean okClicked = false;

    public void setStageSecundario(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}
    
    	
	public void setTutorCentro(TutorCentro tutorcentro) {
        this.tutorcentro = tutorcentro;

        System.out.println("setCiclo");
        DNI_TC.setText(tutorcentro.getDni());
        Nombre.setText(tutorcentro.getNombre());
        Apellido.setText(tutorcentro.getApellido());
        Telefono.setText(tutorcentro.getTelefono());
        Gmail.setText(tutorcentro.getGmail());
        
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
    private void ModificarTutorCentro() throws SQLException {
    	conexionbbdd = new TestConexion();
    	
    	try {
			conexionbbdd.ModificarTutorCentro(DNI_TC.getText(), Nombre.getText(), Apellido.getText(), Telefono.getText(), Gmail.getText());
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			isInputValid();
		}

    }

    
    private void isInputValid() {
        String errorMessage = "";

        if (DNI_TC.getText() == null || DNI_TC.getText().length() == 0) {
            errorMessage += "DNI no válido!\n";
        }
        if (Nombre.getText() == null || Nombre.getText().length() == 0) {
            errorMessage += "Nombre no válido!\n";
        }
        if (Apellido.getText() == null || Apellido.getText().length() == 0) {
            errorMessage += "Apellido no válido!\n";
        }
        
        if (Telefono.getText() == null || Telefono.getText().length() == 0) {
            errorMessage += "Telefono no válido!\n";
        }
        if (Gmail.getText() == null || Gmail.getText().length() == 0) {
            errorMessage += "Gmail no válido!\n";
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
