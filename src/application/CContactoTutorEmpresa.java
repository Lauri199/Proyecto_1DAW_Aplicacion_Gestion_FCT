package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CContactoTutorEmpresa {
	
	@FXML
	private Button add;
	
	@FXML
	private TextField DNI_TE;
	
	@FXML
	private TextField Nombre;
	
	@FXML
	private TextField Apellido;
	
	@FXML
	private TextField Telefono;
	
	@FXML
	private TextField Gmail;
	
	@FXML
	private TextField Num_Convenio;

	
	TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private TutorEmpresa tutorempresa;
    private boolean okClicked = false;

    public void setStageSecundario(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}
    
    	
	public void setTutorEmpresa(TutorEmpresa tutorempresa) {
        this.tutorempresa = tutorempresa;

        System.out.println("setCiclo");
        DNI_TE.setText(tutorempresa.getDni());
        Nombre.setText(tutorempresa.getNombre());
        Apellido.setText(tutorempresa.getApellido());
        Telefono.setText(tutorempresa.getTelefono());
        Gmail.setText(tutorempresa.getGmail());
        Num_Convenio.setText(tutorempresa.getNum_convenio());
        
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
    private void InsertarTutorCentro() throws SQLException {
    	conexionbbdd = new TestConexion();
    	
    	try {
			conexionbbdd.InsertTutorEmpresa(DNI_TE.getText(), Nombre.getText(), Apellido.getText(), Telefono.getText(), Gmail.getText(), Num_Convenio.getText());
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

    }

    
    private boolean isInputValid() {
        String errorMessage = "";

        if (DNI_TE.getText() == null || DNI_TE.getText().length() == 0) {
            errorMessage += "DNI no válido!\n";
        }
        if (Nombre.getText() == null || Nombre.getText().length() == 0) {
            errorMessage += "Nombre no válido!\n";
        }
        if (Apellido.getText() == null || Apellido.getText().length() != 0) {
            errorMessage += "Apellido no válido!\n";
        }
        
        if (Telefono.getText() == null || Telefono.getText().length() == 0) {
            errorMessage += "Telefono no válido!\n";
        }
        if (Gmail.getText() == null || Gmail.getText().length() == 0) {
            errorMessage += "Gmail no válido!\n";
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
