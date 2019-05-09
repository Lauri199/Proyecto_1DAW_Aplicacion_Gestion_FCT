package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CContactoCiclo {
	
	@FXML
	private Button add;
	
	@FXML
	private TextField Clave_Ciclo ;
	
	@FXML
	private TextField Nombre_Ciclo ;
	
	@FXML
	private TextField Familia_Profesional ;
	
	@FXML
	private TextField Num_Cursos ;
	
	@FXML
	private TextField Periodo_Practicas ;
	
	@FXML
	private TextField Capacidades_terminales ;
	
	@FXML
	private TextField Act_Activo_Formativas ;
	
	@FXML
	private TextField Criterios_Evaluacion ;
	
	@FXML
	private TextField ProgramaFormativo ;
	
	@FXML
	private TextField Cod_Centro ;

	
	TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private Ciclo ciclo;
    private boolean okClicked = false;

	
	
	
	public void setPerson(Ciclo ciclo) {
        this.ciclo = ciclo;

        Clave_Ciclo.setText(ciclo.getClave_ciclo());
        Nombre_Ciclo.setText(ciclo.getNom_ciclo());
        Familia_Profesional.setText(ciclo.getFamilia_prof());
        Num_Cursos.setText(ciclo.getNum_cursos());
        Periodo_Practicas.setText(ciclo.getPeriod_pract());
        Capacidades_terminales.setText(ciclo.getCapac_term());
        Act_Activo_Formativas.setText(ciclo.getAct_form());
        Criterios_Evaluacion.setText(ciclo.getCriterios_eva());
        ProgramaFormativo.setText(ciclo.getPrograma_formativo());
        Cod_Centro.setText(ciclo.getCod_centro());
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }

    
    @FXML
    private void handleOk() {
    	if (isInputValid()) {
            ciclo.setClave_ciclo(Clave_Ciclo.getText());
            ciclo.setNom_ciclo(Nombre_Ciclo.getText());
            ciclo.setFamilia_prof(Familia_Profesional.getText());
            ciclo.setNum_cursos(Num_Cursos.getText());
            ciclo.setPeriod_pract(Periodo_Practicas.getText());
            ciclo.setCapac_term(Capacidades_terminales.getText());
            ciclo.setAct_form(Act_Activo_Formativas.getText());
            ciclo.setCriterios_eva(Criterios_Evaluacion.getText());
            ciclo.setPrograma_formativo(ProgramaFormativo.getText());
            ciclo.setCod_centro(Cod_Centro.getText());

            okClicked = true;
            ventanaTres.close();
        }
    }

    @FXML
    private void handleCancel() {
    	ventanaTres.close();
    }
    
    @FXML
    private void InsertarCiclo() throws SQLException {
    	conexionbbdd = new TestConexion();
		try {
			conexionbbdd.InsertCiclo(Clave_Ciclo.getText(), Nombre_Ciclo.getText(), Familia_Profesional.getText(), Num_Cursos.getText(), Periodo_Practicas.getText(), Capacidades_terminales.getText(), Act_Activo_Formativas.getText(), Criterios_Evaluacion.getText(), ProgramaFormativo.getText(), Cod_Centro.getText());
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		this.ventanaTres.close();

    }

    
    private boolean isInputValid() {
        String errorMessage = "";

        if (Clave_Ciclo.getText() == null || Clave_Ciclo.getText().length() == 0) {
            errorMessage += "Clave del ciclo no válida!\n";
        }
        if (Nombre_Ciclo.getText() == null || Nombre_Ciclo.getText().length() == 0) {
            errorMessage += "Nombre del ciclo no válido!\n";
        }
        if (Familia_Profesional.getText() == null || Familia_Profesional.getText().length() != 9) {
            errorMessage += "Familia profesional no válida!\n";
        }
        
        if (Num_Cursos.getText() == null || Num_Cursos.getText().length() == 0) {
            errorMessage += "Numero de cursos no válido!\n";
        }
        if (Periodo_Practicas.getText() == null || Periodo_Practicas.getText().length() == 0) {
            errorMessage += "Periodo de practicas no válido!\n";
        }
        if (Capacidades_terminales.getText() == null || Capacidades_terminales.getText().length() != 9) {
            errorMessage += "Capacidades terminales no válidas!\n";
        }
        
        if (Act_Activo_Formativas.getText() == null || Act_Activo_Formativas.getText().length() == 0) {
            errorMessage += "Actividades activo formativas  no válidas!\n";
        }
        if (Criterios_Evaluacion.getText() == null || Criterios_Evaluacion.getText().length() == 0) {
            errorMessage += "Criterios de evaluacion no válidos!\n";
        }
        if (ProgramaFormativo.getText() == null || ProgramaFormativo.getText().length() != 9) {
            errorMessage += "Programa Formativo no válido!\n";
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
    
    public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}

}
