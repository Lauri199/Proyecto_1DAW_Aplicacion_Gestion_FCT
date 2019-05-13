package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CMenuAlumnos {
	@FXML
	private TableView<Alumno> Tabla;
	
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
	
	@FXML
	private Button Actualizar;
	
	@FXML
	private Button Borrar;
	
	@FXML
	private Button Agregar;
	
	@FXML
	private Button Modificar;
	
	TestConexion conexionbbdd;
	
	Main ProgramaSecundario;
	
	private boolean okClicked = false;
	
	Alumno alumno;
	
	
	private ObservableList<Alumno> data = FXCollections.observableArrayList();
	
	@FXML
	public void initialize(){
		DNI_ALUM.setCellValueFactory(new PropertyValueFactory<Alumno,String>("dni_alum"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("nombre"));
		Apellido.setCellValueFactory(new PropertyValueFactory<Alumno,String>("apellido"));
		Tiempo_Empleado.setCellValueFactory(new PropertyValueFactory<Alumno,String>("tiempo_empleado"));
		DNI_TC.setCellValueFactory(new PropertyValueFactory<Alumno,String>("dni_tc"));
		DNI_TE.setCellValueFactory(new PropertyValueFactory<Alumno,String>("dni_te"));
		
	}
	
	public void setMain(Main ProgramaSecundario) {
		// TODO Auto-generated method stub
		System.out.println("setMain");
		this.ProgramaSecundario = ProgramaSecundario;
	}
	
	public void ContactoCiclo(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoAlumno.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
        Stage ventana = new Stage();
        ventana.setTitle("Venta Dos");
        Scene scene = new Scene(ventanaDos);
        ventana.setScene(scene);
        ventana.show();
	}
		
	
	/*@FXML
	public void ActualizaTabla(){
		conexionbbdd = new TestConexion();
		Tabla.setItems(conexionbbdd.ConsultaAlumnos());
	}
	
	
	@FXML
	public void EditarAlumno() throws IOException {
		Alumno selectedAlumno = Tabla.getSelectionModel().getSelectedItem();
		if (selectedAlumno != null) {
			System.out.println("editar Alumno");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoModificarAlumno.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
	        Stage ventana = new Stage();
	        ventana.setTitle("Venta Dos");
	        Scene scene = new Scene(ventanaDos);
	        CContactoModificarCiclo cicloseleccionado = loader.getController();
	        cicloseleccionado.setAlumno(selectedAlumno);
	        ventana.setScene(scene);
	        ventana.show();
        	
           // Tabla.setItems(this.ciclo.getClave_ciclo(), this.ciclo.getNom_ciclo(), this.ciclo.getFamilia_prof(), this.ciclo.getNum_cursos(), this.ciclo.getPeriod_pract(), this.ciclo.getCapac_term(), this.ciclo.getAct_form(), this.ciclo.getCriterios_eva(), this.ciclo.getPrograma_formativo(), this.ciclo.getCod_centro());
        }
        else
        {
        	// No se ha seleccionado nada.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionCiclo(alert);
        }
		
	}*/
	
	
	/*@FXML
	public void BorrarTabla(){
		Ciclo selectedCiclo = Tabla.getSelectionModel().getSelectedItem();
		if (selectedCiclo != null) {
			System.out.println("borrar ciclo");
			conexionbbdd = new TestConexion();
			Tabla.setItems(conexionbbdd.BorrarCiclo(this.ciclo.getClave_ciclo(), this.ciclo.getNom_ciclo(), this.ciclo.getFamilia_prof(), this.ciclo.getNum_cursos(), this.ciclo.getPeriod_pract(), this.ciclo.getCapac_term(), this.ciclo.getAct_form(), this.ciclo.getCriterios_eva(), this.ciclo.getPrograma_formativo(), this.ciclo.getCod_centro()));
        	
           // Tabla.setItems(this.ciclo.getClave_ciclo(), this.ciclo.getNom_ciclo(), this.ciclo.getFamilia_prof(), this.ciclo.getNum_cursos(), this.ciclo.getPeriod_pract(), this.ciclo.getCapac_term(), this.ciclo.getAct_form(), this.ciclo.getCriterios_eva(), this.ciclo.getPrograma_formativo(), this.ciclo.getCod_centro());
        }
        else
        {
        	// Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionCiclo(alert);
        }
		
	}*/
	
	
	
	
	private void ShowAlertNoSelectionCiclo(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Ciclo no seleccionado");
        alert.setContentText("Por favor!!! Seleccione un ciclo de la tabla");

        alert.showAndWait();
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }
	
	
	public void setListaAlumno(ObservableList<Alumno> listaAlumno){
		this.data = listaAlumno;
	}

}
