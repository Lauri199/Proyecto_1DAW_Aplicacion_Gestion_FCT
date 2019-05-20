package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CContactoModificarAlumno {
	
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
	private TextField Curso;
	
	
	
	@FXML
	private TableView<TutorCentro> Tabla_TC;
	
	@FXML
	private TableColumn<TutorCentro,String> DNI_TC;

	@FXML
	private TableColumn<TutorCentro,String> Nombre_TC;

	@FXML
	private TableColumn<TutorCentro,String> Apellido_TC;
	
	@FXML
	private TableColumn<TutorCentro,String> Telefono_TC;
	
	@FXML
	private TableColumn<TutorCentro,String> Gmail_TC;
	
	@FXML
	private Button Actualizar_TC;
	
	
	
	@FXML
	private TableView<TutorEmpresa> Tabla_TE;
	
	@FXML
	private TableColumn<TutorEmpresa,String> DNI_TE;
	
	@FXML
	private TableColumn<TutorEmpresa,String> Nombre_TE;

	@FXML
	private TableColumn<TutorEmpresa,String> Apellido_TE;
	
	@FXML
	private TableColumn<TutorEmpresa,String> Telefono_TE;
	
	@FXML
	private TableColumn<TutorEmpresa,String> Gmail_TE;
	
	@FXML
	private TableColumn<TutorEmpresa,String> Num_Convenio_TE;
	
	@FXML
	private Button Actualizar_TE;
	
	
	
	@FXML
	private TableView<Ciclo> Tabla_Ciclo;
	
	@FXML
	private TableColumn<Ciclo,String> Clave_Ciclo;

	@FXML
	private TableColumn<Ciclo,String> Nombre_Ciclo;

	@FXML
	private TableColumn<Ciclo,String> Fam_Prof;
	
	@FXML
	private TableColumn<Ciclo,String> Num_Cursos;
	
	@FXML
	private TableColumn<Ciclo,String> Period_Pract;
	
	@FXML
	private TableColumn<Ciclo,String> Cap_terminales;
	
	@FXML
	private TableColumn<Ciclo,String> Act_Form;
	
	@FXML
	private TableColumn<Ciclo,String> Criterio;
	
	@FXML
	private TableColumn<Ciclo,String> Programa_Formativo;
	
	@FXML
	private TableColumn<Ciclo,String> Cod_Centro;
	
	@FXML
	private Button ActualizarCiclo;

	
	TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private Alumno alumno;
    private boolean okClicked = false;
    
    @FXML
	public void initialize(){
		DNI_TC.setCellValueFactory(new PropertyValueFactory<TutorCentro,String>("dni"));
		Nombre_TC.setCellValueFactory(new PropertyValueFactory<TutorCentro,String>("nombre"));
		Apellido_TC.setCellValueFactory(new PropertyValueFactory<TutorCentro,String>("apellido"));
		Telefono_TC.setCellValueFactory(new PropertyValueFactory<TutorCentro,String>("telefono"));
		Gmail_TC.setCellValueFactory(new PropertyValueFactory<TutorCentro,String>("gmail"));
		
		
		
		DNI_TE.setCellValueFactory(new PropertyValueFactory<TutorEmpresa,String>("dni"));
		Nombre_TE.setCellValueFactory(new PropertyValueFactory<TutorEmpresa,String>("nombre"));
		Apellido_TE.setCellValueFactory(new PropertyValueFactory<TutorEmpresa,String>("apellido"));
		Telefono_TE.setCellValueFactory(new PropertyValueFactory<TutorEmpresa,String>("telefono"));
		Gmail_TE.setCellValueFactory(new PropertyValueFactory<TutorEmpresa,String>("gmail"));
		Num_Convenio_TE.setCellValueFactory(new PropertyValueFactory<TutorEmpresa,String>("num_convenio"));
		
		
		Clave_Ciclo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("clave_ciclo"));
		Nombre_Ciclo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("nom_ciclo"));
		Fam_Prof.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("familia_prof"));
		Num_Cursos.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("num_cursos"));
		Period_Pract.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("period_pract"));
		Cap_terminales.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("capac_term"));
		Act_Form.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("act_form"));
		Criterio.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("criterios_eva"));
		Programa_Formativo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("programa_formativo"));
		Cod_Centro.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("cod_centro"));
		
		
		conexionbbdd = new TestConexion();
		Tabla_TC.setItems(conexionbbdd.ConsultaTutorCentro());
		Tabla_TE.setItems(conexionbbdd.ConsultaTodosTutorEmpresa());
		Tabla_Ciclo.setItems(conexionbbdd.ConsultaCiclos());
	}
    
    @FXML
	public void ActualizaTablaTutorCentro(){
		conexionbbdd = new TestConexion();
		Tabla_TC.setItems(conexionbbdd.ConsultaTutorCentro());
	}
    
    @FXML
	public void ActualizaTablaTutorEmpresa(){
		conexionbbdd = new TestConexion();
		Tabla_TE.setItems(conexionbbdd.ConsultaTodosTutorEmpresa());
	}
    
    @FXML
	public void ActualizaTablaCiclo(){
		conexionbbdd = new TestConexion();
		Tabla_Ciclo.setItems(conexionbbdd.ConsultaCiclos());
	}

    public void setStageSecundario(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}
    
    	
	public void setAlumno(Alumno alumno) {
        this.alumno = alumno;

        System.out.println("setAlumno");
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
    
    @FXML
    private void ModificarAlumno() throws SQLException {
    	conexionbbdd = new TestConexion();
    	
    	try {
    		Ciclo selectedCiclo = Tabla_Ciclo.getSelectionModel().getSelectedItem();
    		TutorEmpresa selectedTE = Tabla_TE.getSelectionModel().getSelectedItem();
    		TutorCentro selectedTC = Tabla_TC.getSelectionModel().getSelectedItem();
    		if (selectedCiclo != null) {
    			conexionbbdd.ModificarAlumno(DNI_ALUM.getText(), Nombre.getText(), Apellido.getText(), Tiempo_Empleado.getText(), selectedTC.dni, selectedTE.dni);
    			conexionbbdd.ModificarCursan(selectedCiclo.clave_ciclo, DNI_ALUM.getText(), Curso.getText());
    		}else {
    			Alert alert = new Alert(AlertType.ERROR);
            	ShowAlertNoSelectionCiclo(alert);
    		}
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

    }
    private void ShowAlertNoSelectionCiclo(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Elemento o elementos no seleccionada");
        alert.setContentText("Por favor!!! Seleccione todos los elementos de todas las tablas");

        alert.showAndWait();
    }

    
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
