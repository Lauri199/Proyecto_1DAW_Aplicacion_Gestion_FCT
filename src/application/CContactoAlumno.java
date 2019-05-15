package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CContactoAlumno {
	
	@FXML
	private Button add;
	
	@FXML
	private TextField DNI_ALUM;
	
	@FXML
	private TextField Nombre;
	
	@FXML
	private TextField Apellido;
	
	@FXML
	private TextField Tiempo_Empleado;
	
	@FXML
	private TextField DNI_TC;
	
	@FXML
	private TextField DNI_TE;

	
	TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private Alumno alumno;
    private boolean okClicked = false;

    public void setStageSecundario(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}
    
    	
	public void setAlumno(Alumno alumno) {
        this.alumno = alumno;

        System.out.println("setCiclo");
        DNI_ALUM.setText(alumno.getDni_alum());
        Nombre.setText(alumno.getNombre());
        Apellido.setText(alumno.getApellido());
        Tiempo_Empleado.setText(alumno.getTiempo_empleado());
        DNI_TC.setText(alumno.getDni_tc());
        DNI_TE.setText(alumno.getDni_te());

        
        okClicked = true;
        
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }


    @FXML
    private void handleCancel() {
    	ventanaTres.close();
    }
    
    /*@FXML
    private void InsertarAlumno() throws SQLException {
    	conexionbbdd = new TestConexion();
    	
    	try {
			conexionbbdd.InsertAlumno(DNI_ALUM.getText(), Nombre.getText(), Apellido.getText(), Tiempo_Empleado.getText(), DNI_TC.getText(), DNI_TE.getText());
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

    }*/

    
    private boolean isInputValid() {
        String errorMessage = "";

        if (DNI_ALUM.getText() == null || DNI_ALUM.getText().length() == 0) {
            errorMessage += "DNI del alumno no válido!\n";
        }
        if (Nombre.getText() == null || Nombre.getText().length() == 0) {
            errorMessage += "Nombre del alumno no válido!\n";
        }
        if (Apellido.getText() == null || Apellido.getText().length() != 0) {
            errorMessage += "Apellido  del alumno no válida!\n";
        }
        
        if (Tiempo_Empleado.getText() == null || Tiempo_Empleado.getText().length() == 0) {
            errorMessage += "Numero de cursos no válido!\n";
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
