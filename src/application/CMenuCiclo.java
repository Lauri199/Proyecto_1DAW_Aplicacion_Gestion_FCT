package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

public class CMenuCiclo {
	
	@FXML
	private TableView<Ciclo> Tabla;
	
	@FXML
	private TableColumn<Ciclo,String> Clave_Ciclo;

	@FXML
	private TableColumn<Ciclo,String> Nombre;

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
	
	Ciclo ciclo;
	
	
	private ObservableList<Ciclo> data = FXCollections.observableArrayList();
	
	@FXML
	public void initialize(){
		Clave_Ciclo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("clave_ciclo"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("nom_ciclo"));
		Fam_Prof.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("familia_prof"));
		Num_Cursos.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("num_cursos"));
		Period_Pract.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("period_pract"));
		Cap_terminales.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("capac_term"));
		Act_Form.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("act_form"));
		Criterio.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("criterios_eva"));
		Programa_Formativo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("programa_formativo"));
		Cod_Centro.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("cod_centro"));
		
		conexionbbdd = new TestConexion();
		Tabla.setItems(conexionbbdd.ConsultaCiclos());
		
	}
	
	public void setMain(Main ProgramaSecundario) {
		// TODO Auto-generated method stub
		System.out.println("setMain");
		this.ProgramaSecundario = ProgramaSecundario;
	}
	
	public void ContactoCiclo(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoCiclo.fxml"));
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
		Tabla.setItems(conexionbbdd.ConsultaCiclos());
	}
	
	
	@FXML
	public void EditarCiclo() throws IOException {
		Ciclo selectedCiclo = Tabla.getSelectionModel().getSelectedItem();
		if (selectedCiclo != null) {
			System.out.println("editar ciclo");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoModificarCiclo.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
	        Stage ventana = new Stage();
	        ventana.setTitle("Venta Dos");
	        Scene scene = new Scene(ventanaDos);
	        CContactoModificarCiclo cicloseleccionado = loader.getController();
	        cicloseleccionado.setCiclo(selectedCiclo);
	        ventana.setScene(scene);
	        scene.getStylesheets().add("MiHojaEstilos.css");
	        ventana.show();
        	
           // Tabla.setItems(this.ciclo.getClave_ciclo(), this.ciclo.getNom_ciclo(), this.ciclo.getFamilia_prof(), this.ciclo.getNum_cursos(), this.ciclo.getPeriod_pract(), this.ciclo.getCapac_term(), this.ciclo.getAct_form(), this.ciclo.getCriterios_eva(), this.ciclo.getPrograma_formativo(), this.ciclo.getCod_centro());
        }
        else
        {
        	// No se ha seleccionado nada.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionCiclo(alert);
        }
		
	}
	
	@FXML
	public void BorrarTabla() throws SQLException{
		Ciclo selectedCiclo = Tabla.getSelectionModel().getSelectedItem();
		if (selectedCiclo != null) {
			System.out.println("borrar ciclo");
			conexionbbdd = new TestConexion();
			try {
				if(conexionbbdd.BorrarCiclo(selectedCiclo.getClave_ciclo(), selectedCiclo.getNom_ciclo(), selectedCiclo.getFamilia_prof(), selectedCiclo.getNum_cursos(), selectedCiclo.getPeriod_pract(), selectedCiclo.getCapac_term(), selectedCiclo.getAct_form(), selectedCiclo.getCriterios_eva(), selectedCiclo.getPrograma_formativo(), selectedCiclo.getCod_centro())>0)
				{
					Alert alert = new Alert(AlertType.INFORMATION);
		        	ShowAlertBorradoCiclo(alert);
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.INFORMATION);
	        	ShowAlertErrorBorradoCiclo(alert);
			}
			
		}else
        {
        	// Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionCiclo(alert);
        }
		
	}
	
	
	
	private void ShowAlertErrorBorradoCiclo(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Ha ocurrido un error al borrar este ciclo");
        alert.setContentText("Hay alumnos estudiando este ciclo, no se puede borrar");

        alert.showAndWait();
		
	}

	private void ShowAlertBorradoCiclo(Alert alert) {
		// TODO Apéndice de método generado automáticamente
		alert.setTitle("Borrado");
        alert.setHeaderText("Ciclo Borrado");
        alert.setContentText("El ciclo de ha sido borrado");

        alert.showAndWait();
		
	}

	private void ShowAlertNoSelectionCiclo(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Ciclo no seleccionado");
        alert.setContentText("Por favor!!! Seleccione un ciclo de la tabla");

        alert.showAndWait();
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }
	
	
	public void setListaCiclo(ObservableList<Ciclo> listaCiclo){
		this.data = listaCiclo;
	}

}
