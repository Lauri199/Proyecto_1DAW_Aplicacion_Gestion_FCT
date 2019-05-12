package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	
	public void ContactoCentro(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoCentro.fxml"));
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
		Tabla.setItems(conexionbbdd.ConsultaCentro());
	}
	
	
	public void setListaCentro(ObservableList<Centro> listaCentro){
		this.data = listaCentro;
	}

}
