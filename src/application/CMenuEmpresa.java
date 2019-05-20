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

public class CMenuEmpresa {
	
	@FXML
	private TableView<Empresa> Tabla;
	
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
	private TableColumn<Empresa,String> Telefono;
	
	@FXML
	private TableColumn<Empresa,String> Fax;
	
	@FXML
	private TableColumn<Empresa,String> CiudadFirmaConvenio;
	
	@FXML
	private TableColumn<Empresa,String> FechaFirmaConvenio;
	
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
	
	
	private ObservableList<Empresa> data = FXCollections.observableArrayList();
	
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
		Telefono.setCellValueFactory(new PropertyValueFactory<Empresa,String>("telefono"));
		Fax.setCellValueFactory(new PropertyValueFactory<Empresa,String>("fax"));
		CiudadFirmaConvenio.setCellValueFactory(new PropertyValueFactory<Empresa,String>("ciudad_firma_convenio"));
		FechaFirmaConvenio.setCellValueFactory(new PropertyValueFactory<Empresa,String>("fecha_firma_convenio"));
		
		conexionbbdd = new TestConexion();
		Tabla.setItems(conexionbbdd.ConsultaEmpresas());
	}
	
	public void setMain(Main ProgramaSecundario) {
		// TODO Auto-generated method stub
		System.out.println("setMain");
		this.ProgramaSecundario = ProgramaSecundario;
	}
	
	public void ContactoEmpresa(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoEmpresa.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
        Stage ventana = new Stage();
        ventana.setTitle("Venta Dos");
        Scene scene = new Scene(ventanaDos);
        ventana.setScene(scene);
        scene.getStylesheets().add("MiHojaEstilos.css");
        ventana.show();
        
	}
	
	@FXML
	public void ActualizaTabla(){
		conexionbbdd = new TestConexion();
		Tabla.setItems(conexionbbdd.ConsultaEmpresas());
	}
	
	@FXML
	public void EditarEmpresa() throws IOException {
		Empresa selectedEmpresa = Tabla.getSelectionModel().getSelectedItem();
		if (selectedEmpresa != null) {
			System.out.println("editar empresa");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoModificarEmpresa.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
	        Stage ventana = new Stage();
	        ventana.setTitle("Venta Dos");
	        Scene scene = new Scene(ventanaDos);
	        CContactoModificarEmpresa empresaseleccionada = loader.getController();
	        empresaseleccionada.setEmpresa(selectedEmpresa);
	        ventana.setScene(scene);
	        scene.getStylesheets().add("MiHojaEstilos.css");
	        ventana.show();
        }
        else
        {
        	// No se ha seleccionado nada.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionEmpresa(alert);
        }
		
	}
	
	@FXML
	public void BorrarTabla() throws SQLException{
		Empresa selectedEmpresa = Tabla.getSelectionModel().getSelectedItem();
		if (selectedEmpresa != null) {
			System.out.println("borrar Empresa");
			conexionbbdd = new TestConexion();
			try {
				if(conexionbbdd.BorrarEmpresa(selectedEmpresa.getNum_convenio())>0)
				{
					Alert alert = new Alert(AlertType.INFORMATION);
		        	ShowAlertBorradoEmpresa(alert);
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.INFORMATION);
	        	ShowAlertErrorBorradoEmpresa(alert);
			}
			
		}else
        {
        	// Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionEmpresa(alert);
        }
		
	}
	
	private void ShowAlertErrorBorradoEmpresa(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Ha ocurrido un error al borrar esta empresa");
        alert.setContentText("Hay alumnos realizando las practicas en esta empresa, no se puede borrar");

        alert.showAndWait();
		
	}
	
	private void ShowAlertBorradoEmpresa(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Empresa Borrada");
        alert.setContentText("La empresa ha sido borrada");

        alert.showAndWait();
		
	}
	
	private void ShowAlertNoSelectionEmpresa(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Empresa no seleccionada");
        alert.setContentText("Por favor!!! Seleccione una empresa de la tabla");

        alert.showAndWait();
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }
	
	public void setListaEmpresa(ObservableList<Empresa> listaEmpresa){
		this.data = listaEmpresa;
	}
	

}
