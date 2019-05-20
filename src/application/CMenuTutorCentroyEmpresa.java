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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CMenuTutorCentroyEmpresa {
	
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
	private Button Borrar_TC;
	
	@FXML
	private Button Agregar_TC;
	
	@FXML
	private Button Modificar_TC;
	
	
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
	private Button Borrar_TE;
	
	@FXML
	private Button Agregar_TE;
	
	@FXML
	private Button Modificar_TE;
	
	TestConexion conexionbbdd;
	
	Main ProgramaSecundario;
	
	private boolean okClicked = false;
	
	TutorCentro tutorcentro;
	TutorEmpresa tutorempresa;
	
private ObservableList<TutorCentro> data1 = FXCollections.observableArrayList();
private ObservableList<TutorEmpresa> data2 = FXCollections.observableArrayList();
	
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
		
		conexionbbdd = new TestConexion();
		
		Tabla_TC.setItems(conexionbbdd.ConsultaTutorCentro());
		Tabla_TE.setItems(conexionbbdd.ConsultaTodosTutorEmpresa());
		
	}
	
	public void setMain(Main ProgramaSecundario) {
		// TODO Auto-generated method stub
		System.out.println("setMain");
		this.ProgramaSecundario = ProgramaSecundario;
	}
	
	public void ContactoTutorCentro(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoTutor.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
        Stage ventana = new Stage();
        ventana.setTitle("Venta Dos");
        Scene scene = new Scene(ventanaDos);
        ventana.setScene(scene);
        scene.getStylesheets().add("MiHojaEstilos.css");
        ventana.show();
        
	}
		
	
	@FXML
	public void ActualizaTablaTutorCentro(){
		conexionbbdd = new TestConexion();
		Tabla_TC.setItems(conexionbbdd.ConsultaTutorCentro());
	}
	
	
	@FXML
	public void EditarTutorCentro() throws IOException {
		TutorCentro selectedTC = Tabla_TC.getSelectionModel().getSelectedItem();
		if (selectedTC != null) {
			System.out.println("editar Tutor Centro");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoModificarTutorCentro.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
	        Stage ventana = new Stage();
	        ventana.setTitle("Venta Dos");
	        Scene scene = new Scene(ventanaDos);
	        CContactoModificarTutorCentro tutorcentroseleccionado = loader.getController();
	        tutorcentroseleccionado.setTutorCentro(selectedTC);
	        ventana.setScene(scene);
	        scene.getStylesheets().add("MiHojaEstilos.css");
	        ventana.show();
        }
        else
        {
        	// No se ha seleccionado nada.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionTutorCentro(alert);
        }
		
	}
	
	@FXML
	public void BorrarTablaTC() throws SQLException{
		TutorCentro selectedTC = Tabla_TC.getSelectionModel().getSelectedItem();
		if (selectedTC != null) {
			System.out.println("borrar Tutor Centro");
			conexionbbdd = new TestConexion();
			try {
				if(conexionbbdd.BorrarTutorCentro(selectedTC.getDni())>0)
				{
					Alert alert = new Alert(AlertType.INFORMATION);
		        	ShowAlertBorradoTC(alert);
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.INFORMATION);
	        	ShowAlertErrorBorradoTC(alert);
			}
			
		}else
        {
        	// Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionTutorCentro(alert);
        }
		
	}
	
	
	public void ContactoTutorEmpresa(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoTutorEmpresa.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
        Stage ventana = new Stage();
        ventana.setTitle("Venta Dos");
        Scene scene = new Scene(ventanaDos);
        ventana.setScene(scene);
        scene.getStylesheets().add("MiHojaEstilos.css");
        ventana.show();
	}
		
	
	@FXML
	public void ActualizaTablaTutorEmpresa(){
		conexionbbdd = new TestConexion();
		Tabla_TE.setItems(conexionbbdd.ConsultaTodosTutorEmpresa());
	}
	
	
	@FXML
	public void EditarTutorEmpresa() throws IOException {
		TutorEmpresa selectedTE = Tabla_TE.getSelectionModel().getSelectedItem();
		if (selectedTE != null) {
			System.out.println("editar Tutor Centro");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoModificarTutorEmpresa.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
	        Stage ventana = new Stage();
	        ventana.setTitle("Venta Dos");
	        Scene scene = new Scene(ventanaDos);
	        CContactoModificarTutorEmpresa tutorcentroseleccionado = loader.getController();
	        tutorcentroseleccionado.setTutorEmpresa(selectedTE);
	        ventana.setScene(scene);
	        scene.getStylesheets().add("MiHojaEstilos.css");
	        ventana.show();
        }
        else
        {
        	// No se ha seleccionado nada.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionTutorEmpresa(alert);
        }
		
	}
	
	@FXML
	public void BorrarTablaTE() throws SQLException{
		TutorEmpresa selectedTE = Tabla_TE.getSelectionModel().getSelectedItem();
		if (selectedTE != null) {
			System.out.println("borrar Tutor Empresa");
			conexionbbdd = new TestConexion();
			try {
				if(conexionbbdd.BorrarTutorEmpresa(selectedTE.getDni())>0)
				{
					Alert alert = new Alert(AlertType.INFORMATION);
		        	ShowAlertBorradoTE(alert);
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.INFORMATION);
	        	ShowAlertErrorBorradoTE(alert);
			}
			
		}else
        {
        	// Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionTutorEmpresa(alert);
        }
		
	}
	
	
	
	private void ShowAlertNoSelectionTutorEmpresa(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Tutor de Empresa no seleccionado");
        alert.setContentText("Por favor!!! Seleccione un tutor de empresa de la tabla");

        alert.showAndWait();
    }
	
	private void ShowAlertErrorBorradoTE(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Ha ocurrido un error al borrar este Tutor de la Empresa");
        alert.setContentText("Hay tutores que estan a cargo de varios alumnos, no se puede borrar");

        alert.showAndWait();
		
	}
	
	private void ShowAlertBorradoTE(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Tutor de la empresa borrado");
        alert.setContentText("El tutor ha sido borrado");

        alert.showAndWait();
		
	}
	
	private void ShowAlertNoSelectionTutorCentro(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Tutor de centro no seleccionado");
        alert.setContentText("Por favor!!! Seleccione un tutor de centro de la tabla");

        alert.showAndWait();
    }
	
	private void ShowAlertErrorBorradoTC(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Ha ocurrido un error al borrar este Tutor del Centro");
        alert.setContentText("Hay tutores que estan a cargo de varios alumnos, no se puede borrar");

        alert.showAndWait();
		
	}
	
	private void ShowAlertBorradoTC(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Tutor del centro borrado");
        alert.setContentText("El tutor ha sido borrado");

        alert.showAndWait();
		
	}
	
	public boolean isOkClicked() {
    	return okClicked;
    }
	
	
	public void setListaTC(ObservableList<TutorCentro> listaTC){
		this.data1 = listaTC;
	}
	
}
