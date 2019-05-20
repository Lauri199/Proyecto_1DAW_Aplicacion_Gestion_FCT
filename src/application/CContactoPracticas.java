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

public class CContactoPracticas {
	
	@FXML
	private Button add;
	
	
	@FXML
	private TextField Fecha_Inicio;
	
	@FXML
	private TextField Fecha_Terminacion;
	
	@FXML
	private TextField Fecha_Final;
	
	@FXML
	private TextField Dias_Semana;
	
	@FXML
	private TextField Tipo_Horario;
	
	@FXML
	private TextField Horas_al_dia;
	
	
	@FXML
	private TextField Total_horas;
	
	@FXML
	private TextField Hora_Inicio;
	
	@FXML
	private TextField Hora_terminacion;
	
	
	
	@FXML
	private TableView<Empresa> Tabla_Empresa;
	
	@FXML
	private TableColumn<Empresa,String> Num_Convenio;

	@FXML
	private TableColumn<Empresa,String> NIF;

	@FXML
	private TableColumn<Empresa,String> Nombre_Empresa;
	
	@FXML
	private TableColumn<Empresa,String> Representante_Empresa;
	
	@FXML
	private TableColumn<Empresa,String> Localidad;
	
	@FXML
	private TableColumn<Empresa,String> Provincia;
	
	@FXML
	private TableColumn<Empresa,String> Pais;
	
	@FXML
	private TableColumn<Empresa,String> Calle;
	
	@FXML
	private TableColumn<Empresa,String> Codigo_postal;
	
	@FXML
	private TableColumn<Empresa,String> CIF;
	
	@FXML
	private TableColumn<Empresa,String> TelefonoColum;
	
	@FXML
	private TableColumn<Empresa,String> Fax;
	
	@FXML
	private TableColumn<Empresa,String> CiudadFirmaConvenio;
	
	@FXML
	private TableColumn<Empresa,String> FechaFirmaConvenio;
	
	
	
	
	@FXML
	private TableView<Alumno> Tabla_Alum;
	
	@FXML
	private TableColumn<Alumno,String> DNI_ALUM;

	@FXML
	private TableColumn<Alumno,String> Nombre;

	@FXML
	private TableColumn<Alumno,String> Apellido;
	
	@FXML
	private TableColumn<Alumno,String> Tiempo_Empleado;
	
	@FXML
	private TableColumn<Alumno,String> DNI_TC;
	
	@FXML
	private TableColumn<Alumno,String> DNI_TE;
	
	

	
	TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private Practicas practicas;
    private boolean okClicked = false;
    
    
    @FXML
	public void initialize(){
    	
		Num_Convenio.setCellValueFactory(new PropertyValueFactory<Empresa,String>("num_convenio"));
		NIF.setCellValueFactory(new PropertyValueFactory<Empresa,String>("nif"));
		Nombre_Empresa.setCellValueFactory(new PropertyValueFactory<Empresa,String>("nombre"));
		Representante_Empresa.setCellValueFactory(new PropertyValueFactory<Empresa,String>("representante"));
		Localidad.setCellValueFactory(new PropertyValueFactory<Empresa,String>("localidad"));
		Provincia.setCellValueFactory(new PropertyValueFactory<Empresa,String>("provincia"));
		Pais.setCellValueFactory(new PropertyValueFactory<Empresa,String>("pais"));
		Calle.setCellValueFactory(new PropertyValueFactory<Empresa,String>("calle"));
		Codigo_postal.setCellValueFactory(new PropertyValueFactory<Empresa,String>("codigo_postal"));
		CIF.setCellValueFactory(new PropertyValueFactory<Empresa,String>("cif"));
		TelefonoColum.setCellValueFactory(new PropertyValueFactory<Empresa,String>("telefono"));
		Fax.setCellValueFactory(new PropertyValueFactory<Empresa,String>("fax"));
		CiudadFirmaConvenio.setCellValueFactory(new PropertyValueFactory<Empresa,String>("ciudad_firma_convenio"));
		FechaFirmaConvenio.setCellValueFactory(new PropertyValueFactory<Empresa,String>("fecha_firma_convenio"));
		
		
		DNI_ALUM.setCellValueFactory(new PropertyValueFactory<Alumno,String>("dni_alum"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("nombre"));
		Apellido.setCellValueFactory(new PropertyValueFactory<Alumno,String>("apellido"));
		Tiempo_Empleado.setCellValueFactory(new PropertyValueFactory<Alumno,String>("tiempo_empleado"));
		DNI_TC.setCellValueFactory(new PropertyValueFactory<Alumno,String>("dni_tc"));
		DNI_TE.setCellValueFactory(new PropertyValueFactory<Alumno,String>("dni_te"));
		
		conexionbbdd = new TestConexion();
		Tabla_Empresa.setItems(conexionbbdd.ConsultaEmpresas());
		
		Tabla_Alum.setItems(conexionbbdd.ConsultaAlumno());
		
	}
    
    

    public void setStageSecundario(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}
    
    	
	public void setPractica(Practicas practica) {
        this.practicas = practica;

        System.out.println("setCiclo");
        Num_Convenio.setText(practicas.getNum_convenio());
        DNI_ALUM.setText(practicas.getDni_alum());
        Fecha_Inicio.setText(practicas.getFecha_inicio());
        Fecha_Terminacion.setText(practicas.getFecha_terminacion());
        Fecha_Final.setText(practicas.getFecha_final());
        Dias_Semana.setText(practicas.getDias_semana());
        Tipo_Horario.setText(practicas.getTipo_horario());
        Horas_al_dia.setText(practicas.getHoras_al_dia());
        Total_horas.setText(practicas.getTotal_horas());
        Hora_Inicio.setText(practicas.getHora_inicio());
        Hora_terminacion.setText(practicas.getFecha_terminacion());
        
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
    private void InsertarPracticas() throws SQLException {
    	conexionbbdd = new TestConexion();
    	try {
    		Empresa selectedEmpresa = Tabla_Empresa.getSelectionModel().getSelectedItem();
    		Alumno selectedAlumno = Tabla_Alum.getSelectionModel().getSelectedItem();
    		if (selectedEmpresa != null && selectedAlumno != null) {
    			conexionbbdd.InsertPracticas(selectedEmpresa.num_convenio, selectedAlumno.dni_alum, Fecha_Inicio.getText(), Fecha_Terminacion.getText(), Fecha_Final.getText(), Dias_Semana.getText(), Tipo_Horario.getText(), Horas_al_dia.getText(), Total_horas.getText(), Hora_Inicio.getText(), Hora_terminacion.getText());
    		}else {
    			Alert alert = new Alert(AlertType.ERROR);
            	ShowAlertNoSelectionEmpresa(alert);
    		}
			
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			isInputValid();
		}

    }
    
    private void ShowAlertNoSelectionEmpresa(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Practica no seleccionada");
        alert.setContentText("Por favor!!! Seleccione un elemento de la tabla");

        alert.showAndWait();
    }
    
    

    
    private void isInputValid() {
        String errorMessage = "";

        if (Num_Convenio.getText() == null || Num_Convenio .getText().length() == 0) {
            errorMessage += "Numero de Convenio no válido!\n";
        }
        if (DNI_ALUM.getText() == null || DNI_ALUM.getText().length() == 0) {
            errorMessage += "DNI de alumno no válido!\n";
        }
        if (Fecha_Inicio.getText() == null || Fecha_Inicio.getText().length() == 0) {
            errorMessage += "Fecha Inicio no válida!\n";
        }
        
        if (Fecha_Terminacion.getText() == null || Fecha_Terminacion.getText().length() == 0) {
            errorMessage += "Fecha Terminacion no válida!\n";
        }
        if (Fecha_Final.getText() == null || Fecha_Final.getText().length() == 0) {
            errorMessage += "Fecha Final no válida!\n";
        }
        
        if (Dias_Semana.getText() == null || Dias_Semana.getText().length() == 0) {
            errorMessage += "Dias Semana no válidas!\n";
        }
        
        if (Tipo_Horario.getText() == null || Tipo_Horario.getText().length() == 0) {
            errorMessage += "Tipo Horario no válidas!\n";
        }
        if (Horas_al_dia.getText() == null || Horas_al_dia.getText().length() == 0) {
            errorMessage += "Horas al dia no válidas!\n";
        }
        
        if (Total_horas.getText() == null || Total_horas.getText().length() == 0) {
            errorMessage += "Total de horas no válidas!\n";
        }
        
        if (Hora_Inicio.getText() == null || Hora_Inicio.getText().length() == 0) {
            errorMessage += "Hora de Inicio no válida!\n";
        }
        
        if (Hora_terminacion.getText() == null || Hora_terminacion.getText().length() == 0) {
            errorMessage += "Hora de terminacion no válida!\n";
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
