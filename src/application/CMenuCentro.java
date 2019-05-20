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

public class CMenuCentro {
	
	@FXML
	private TableView<Centro> Tabla;
	
	@FXML
	private TableColumn<Centro,String> Cod_Centro;

	@FXML
	private TableColumn<Centro,String> Representante_Centro;

	@FXML
	private TableColumn<Centro,String> NIF;
	
	@FXML
	private TableColumn<Centro,String> NombreCentro;
	
	@FXML
	private TableColumn<Centro,String> Ciudad;
	
	@FXML
	private TableColumn<Centro,String> Provincia;
	
	@FXML
	private TableColumn<Centro,String> Calle;
	
	@FXML
	private TableColumn<Centro,String> Codigo_Postal;
	
	@FXML
	private TableColumn<Centro,String> CIF;
	
	@FXML
	private TableColumn<Centro,String> Telefono;
	
	@FXML
	private TableColumn<Centro,String> Fax;
	
	@FXML
	private TableColumn<Centro,String> DAT;
	
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
	
	
	private ObservableList<Centro> data = FXCollections.observableArrayList();
	
	@FXML
	public void initialize(){
		Cod_Centro.setCellValueFactory(new PropertyValueFactory<Centro,String>("cod_centro"));
		Representante_Centro.setCellValueFactory(new PropertyValueFactory<Centro,String>("representante_centro"));
		NIF.setCellValueFactory(new PropertyValueFactory<Centro,String>("nif"));
		NombreCentro.setCellValueFactory(new PropertyValueFactory<Centro,String>("nombrecentro"));
		Ciudad.setCellValueFactory(new PropertyValueFactory<Centro,String>("ciudad"));
		Provincia.setCellValueFactory(new PropertyValueFactory<Centro,String>("provincia"));
		Calle.setCellValueFactory(new PropertyValueFactory<Centro,String>("calle"));
		Codigo_Postal.setCellValueFactory(new PropertyValueFactory<Centro,String>("codigo_postal"));
		CIF.setCellValueFactory(new PropertyValueFactory<Centro,String>("cif"));
		Telefono.setCellValueFactory(new PropertyValueFactory<Centro,String>("telefono"));
		Fax.setCellValueFactory(new PropertyValueFactory<Centro,String>("fax"));
		DAT.setCellValueFactory(new PropertyValueFactory<Centro,String>("dat"));
		
	}
	
	public void setMain(Main ProgramaSecundario) {
		// TODO Auto-generated method stub
		System.out.println("setMain");
		this.ProgramaSecundario = ProgramaSecundario;
	}
	
	public void ContactoCentro(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoCentro.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
        Stage ventana = new Stage();
        ventana.setTitle("V2 Centro");
        Scene scene = new Scene(ventanaDos);
        ventana.setScene(scene);
        ventana.show();
	}
	
	@FXML
	public void ActualizaTabla(){
		conexionbbdd = new TestConexion();
		Tabla.setItems(conexionbbdd.ConsultaCentro());
	}
	
	@FXML
	public void EditarCentro() throws IOException {
		Centro selectedCentro = Tabla.getSelectionModel().getSelectedItem();
		if (selectedCentro != null) {
			System.out.println("editar ciclo");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoModificarCentro.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
	        Stage ventana = new Stage();
	        ventana.setTitle("Venta Dos");
	        Scene scene = new Scene(ventanaDos);
	        CContactoModificarCentro centroseleccionado = loader.getController();
	        centroseleccionado.setCentro(selectedCentro);
	        ventana.setScene(scene);
	        ventana.show();
        	
           // Tabla.setItems(this.ciclo.getClave_ciclo(), this.ciclo.getNom_ciclo(), this.ciclo.getFamilia_prof(), this.ciclo.getNum_cursos(), this.ciclo.getPeriod_pract(), this.ciclo.getCapac_term(), this.ciclo.getAct_form(), this.ciclo.getCriterios_eva(), this.ciclo.getPrograma_formativo(), this.ciclo.getCod_centro());
        }
        else
        {
        	// No se ha seleccionado nada.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionCentro(alert);
        }
		
	}
	
	@FXML
	public void BorrarTabla() throws SQLException{
		Centro selectedCentro = Tabla.getSelectionModel().getSelectedItem();
		if (selectedCentro != null) {
			System.out.println("borrar ciclo");
			conexionbbdd = new TestConexion();
			try {
				if(conexionbbdd.BorrarCentro(selectedCentro.getCod_centro())>0)
				{
					Alert alert = new Alert(AlertType.INFORMATION);
		        	ShowAlertBorradoCiclo(alert);
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.INFORMATION);
	        	ShowAlertErrorBorradoCentro(alert);
			}
			//Tabla.setItems(conexionbbdd.BorrarCiclo(this.ciclo.getClave_ciclo(), this.ciclo.getNom_ciclo(), this.ciclo.getFamilia_prof(), this.ciclo.getNum_cursos(), this.ciclo.getPeriod_pract(), this.ciclo.getCapac_term(), this.ciclo.getAct_form(), this.ciclo.getCriterios_eva(), this.ciclo.getPrograma_formativo(), this.ciclo.getCod_centro()));
        	
           // Tabla.setItems(this.ciclo.getClave_ciclo(), this.ciclo.getNom_ciclo(), this.ciclo.getFamilia_prof(), this.ciclo.getNum_cursos(), this.ciclo.getPeriod_pract(), this.ciclo.getCapac_term(), this.ciclo.getAct_form(), this.ciclo.getCriterios_eva(), this.ciclo.getPrograma_formativo(), this.ciclo.getCod_centro());
        }else
        {
        	// Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionCentro(alert);
        }
		
	}
	
	
	
	private void ShowAlertErrorBorradoCentro(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Ha ocurrido un error al borrar este centro");
        alert.setContentText("Hay ciclos en este centro, no se puede borrar");

        alert.showAndWait();
		
	}

	private void ShowAlertBorradoCiclo(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Ciclo Borrado");
        alert.setContentText("El ciclo de ha sido borrado");

        alert.showAndWait();
		
	}
	
	
	
	private void ShowAlertNoSelectionCentro(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Centro no seleccionado");
        alert.setContentText("Por favor!!! Seleccione un centro de la tabla");

        alert.showAndWait();
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }
	
	
	public void setListaCentro(ObservableList<Centro> listaCentro){
		this.data = listaCentro;
	}

}
