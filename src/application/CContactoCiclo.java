package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class CContactoCiclo {
	
	@FXML
	private Button add;
	
	@FXML
	private TextField Clave_Ciclo;
	
	@FXML
	private TextField Nombre_Ciclo;
	
	@FXML
	private TextField Familia_Profesional;
	
	@FXML
	private TextField Num_Cursos;
	
	@FXML
	private TextField Periodo_Practicas;
	
	/*
	
	@FXML
	private TextField Capacidades_terminales;
	
	@FXML
	private TextField Act_Activo_Formativas;
	
	@FXML
	private TextField Criterios_Evaluacion;
	*/
	
	@FXML
	private TextField ProgramaFormativo;
	
	@FXML
	private TextField Cod_Centro;

	
	TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private Ciclo ciclo;
    private boolean okClicked = false;

    public void setStageSecundario(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}
    
    	
	public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;

        System.out.println("setCiclo");
        Clave_Ciclo.setText(ciclo.getClave_ciclo());
        Nombre_Ciclo.setText(ciclo.getNom_ciclo());
        Familia_Profesional.setText(ciclo.getFamilia_prof());
        Num_Cursos.setText(ciclo.getNum_cursos());
        Periodo_Practicas.setText(ciclo.getPeriod_pract());
        /*
        Capacidades_terminales.setText(ciclo.getCapac_term());
        Act_Activo_Formativas.setText(ciclo.getAct_form());
        Criterios_Evaluacion.setText(ciclo.getCriterios_eva());
        */
        ProgramaFormativo.setText(ciclo.getPrograma_formativo());
        
        conexionbbdd = new TestConexion();
        
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
    private void InsertarCiclo() throws SQLException {
    	conexionbbdd = new TestConexion();
    	try {
			conexionbbdd.InsertCiclo(Clave_Ciclo.getText(), Nombre_Ciclo.getText(), Familia_Profesional.getText(), Num_Cursos.getText(), Periodo_Practicas.getText(), ProgramaFormativo.getText(), Cod_Centro.getText());
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			isInputValid();
		}

    }
    
    

    
    private void isInputValid() {
        String errorMessage = "";

        if (Clave_Ciclo.getText() == null || Clave_Ciclo.getText().length() == 0) {
            errorMessage += "Clave del ciclo no válida!\n";
        }
        if (Nombre_Ciclo.getText() == null || Nombre_Ciclo.getText().length() == 0) {
            errorMessage += "Nombre del ciclo no válido!\n";
        }
        if (Familia_Profesional.getText() == null || Familia_Profesional.getText().length() == 0) {
            errorMessage += "Familia Profesional no válida!\n";
        }
        
        if (Num_Cursos.getText() == null || Num_Cursos.getText().length() == 0) {
            errorMessage += "Numero de cursos no válido!\n";
        }
        if (Periodo_Practicas.getText() == null || Periodo_Practicas.getText().length() == 0) {
            errorMessage += "Periodo de practicas no válido!\n";
        }
        /*
        if (Capacidades_terminales.getText() == null || Capacidades_terminales.getText().length() == 0) {
            errorMessage += "Capacidades terminales no válidas!\n";
        }
        
        if (Act_Activo_Formativas.getText() == null || Act_Activo_Formativas.getText().length() == 0) {
            errorMessage += "Actividades activo formativas  no válidas!\n";
        }
        if (Criterios_Evaluacion.getText() == null || Criterios_Evaluacion.getText().length() == 0) {
            errorMessage += "Criterios de evaluacion no válidos!\n";
        }
        */
        if (ProgramaFormativo.getText() == null || ProgramaFormativo.getText().length() == 0) {
            errorMessage += "Programa Formativo no válido!\n";
        }
        
        if (Cod_Centro.getText() == null || Cod_Centro.getText().length() == 0) {
            errorMessage += "Codigo del Centro no válido!\n";
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
