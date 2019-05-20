package application;

import java.io.IOException;
import java.sql.SQLException;

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
	
	public void ContactoAlumno(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoAlumno.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
        Stage ventana = new Stage();
        ventana.setTitle("Venta Dos");
        Scene scene = new Scene(ventanaDos);
        ventana.setScene(scene);
        ventana.show();
	}
		
	
	@FXML
	public void ActualizaTabla(){
		conexionbbdd = new TestConexion();
		Tabla.setItems(conexionbbdd.ConsultaAlumno());
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
	        CContactoModificarAlumno alumnoseleccionado = loader.getController();
	        alumnoseleccionado.setAlumno(selectedAlumno);
	        ventana.setScene(scene);
	        ventana.show();
        	
        }
        else
        {
        	// No se ha seleccionado nada.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionAlumno(alert);
        }
		
	}
	
	
	@FXML
	public void BorrarTabla() throws SQLException{
		Alumno selectedAlumno = Tabla.getSelectionModel().getSelectedItem();
		if (selectedAlumno != null) {
			System.out.println("borrar Empresa");
			conexionbbdd = new TestConexion();
			try {
				if(conexionbbdd.BorrarAlumno(selectedAlumno.getDni_alum())>0)
				{
					Alert alert = new Alert(AlertType.INFORMATION);
					ShowAlertBorradoAlumno(alert);
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.INFORMATION);
				ShowAlertErrorBorradoAlumno(alert);
			}
			
		}else
        {
        	// Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionAlumno(alert);
        }
		
	}
	
	private void ShowAlertErrorBorradoAlumno(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Ha ocurrido un error al borrar este alumno");
        alert.setContentText("Este alumno esta cursando un ciclo, no se puede borrar");

        alert.showAndWait();
		
	}
	
	private void ShowAlertBorradoAlumno(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Alumno Borrado");
        alert.setContentText("El alumno ha sido borrado");

        alert.showAndWait();
		
	}
	
	
	
	
	private void ShowAlertNoSelectionAlumno(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Alumno no seleccionado");
        alert.setContentText("Por favor!!! Seleccione un Alumno de la tabla");

        alert.showAndWait();
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }
	
	
	public void setListaAlumno(ObservableList<Alumno> listaAlumno){
		this.data = listaAlumno;
	}

}
