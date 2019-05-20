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

public class CMenuPracticas {

	@FXML
	private TableView<Practicas> Tabla;
	
	@FXML
	private TableColumn<Practicas,String> Num_Convenio;

	@FXML
	private TableColumn<Practicas,String> DNI_ALUM;

	@FXML
	private TableColumn<Practicas,String> Fecha_Inicio;
	
	@FXML
	private TableColumn<Practicas,String> Fecha_Terminacion;
	
	@FXML
	private TableColumn<Practicas,String> Fecha_Final;
	
	@FXML
	private TableColumn<Practicas,String> Dias_Semana;
	
	@FXML
	private TableColumn<Practicas,String> Tipo_Horario;
	
	@FXML
	private TableColumn<Practicas,String> Horas_al_dia;
	
	@FXML
	private TableColumn<Practicas,String> Total_horas;
	
	@FXML
	private TableColumn<Practicas,String> Hora_Inicio;
	
	@FXML
	private TableColumn<Practicas,String> Hora_terminacion;
	
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
	
	Practicas practica;
	
	
	private ObservableList<Practicas> data = FXCollections.observableArrayList();
	
	@FXML
	public void initialize(){
		Num_Convenio.setCellValueFactory(new PropertyValueFactory<Practicas,String>("num_convenio"));
		DNI_ALUM.setCellValueFactory(new PropertyValueFactory<Practicas,String>("dni_alum"));
		Fecha_Inicio.setCellValueFactory(new PropertyValueFactory<Practicas,String>("fecha_inicio"));
		Fecha_Terminacion.setCellValueFactory(new PropertyValueFactory<Practicas,String>("fecha_terminacion"));
		Fecha_Final.setCellValueFactory(new PropertyValueFactory<Practicas,String>("fecha_final"));
		Dias_Semana.setCellValueFactory(new PropertyValueFactory<Practicas,String>("dias_semana"));
		Tipo_Horario.setCellValueFactory(new PropertyValueFactory<Practicas,String>("tipo_horario"));
		Horas_al_dia.setCellValueFactory(new PropertyValueFactory<Practicas,String>("horas_al_dia"));
		Total_horas.setCellValueFactory(new PropertyValueFactory<Practicas,String>("total_horas"));
		Hora_Inicio.setCellValueFactory(new PropertyValueFactory<Practicas,String>("hora_inicio"));
		Hora_terminacion.setCellValueFactory(new PropertyValueFactory<Practicas,String>("hora_terminacion"));
		
	}
	
	public void setMain(Main ProgramaSecundario) {
		// TODO Auto-generated method stub
		System.out.println("setMain");
		this.ProgramaSecundario = ProgramaSecundario;
	}
	
	public void ContactoPracticas(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoPracticas.fxml"));
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
		Tabla.setItems(conexionbbdd.ConsultaPracticas());
	}
	
	
	@FXML
	public void EditarPractica() throws IOException {
		Practicas selectedPractica = Tabla.getSelectionModel().getSelectedItem();
		if (selectedPractica != null) {
			System.out.println("editar ciclo");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoModificarPractica.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
	        Stage ventana = new Stage();
	        ventana.setTitle("Venta Dos");
	        Scene scene = new Scene(ventanaDos);
	        CContactoModificarPractica cicloseleccionado = loader.getController();
	        cicloseleccionado.setPractica(selectedPractica);
	        ventana.setScene(scene);
	        ventana.show();
        	
		}
        else
        {
        	// No se ha seleccionado nada.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionPractica(alert);
        }
		
	}
	
	@FXML
	public void BorrarTabla() throws SQLException{
		Practicas selectedPractica = Tabla.getSelectionModel().getSelectedItem();
		if (selectedPractica != null) {
			System.out.println("borrar Practica");
			conexionbbdd = new TestConexion();
			try {
				if(conexionbbdd.BorrarPractica(selectedPractica.getDni_alum(), selectedPractica.getNum_convenio() )>0)
				{
					Alert alert = new Alert(AlertType.INFORMATION);
					ShowAlertBorradoPractica(alert);
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.INFORMATION);
				ShowAlertErrorBorradoPractica(alert);
			}
			
		}else
        {
        	// Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionPractica(alert);
        }
		
	}
	
	private void ShowAlertErrorBorradoPractica(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Ha ocurrido un error al borrar esta practica");
        alert.setContentText("Estos Alumnos siguen haciendo estas practicas, no se pueden borrar");

        alert.showAndWait();
		
	}
	
	private void ShowAlertBorradoPractica(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Practica Borrada");
        alert.setContentText("La practica ha sido borrada");

        alert.showAndWait();
		
	}
	

	private void ShowAlertNoSelectionPractica(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Elemento no seleccionado");
        alert.setContentText("Por favor!!! Seleccione un elemento de la tabla");

        alert.showAndWait();
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }
	
	
	public void setListaPractica(ObservableList<Practicas> listaPractica){
		this.data = listaPractica;
	}

}
