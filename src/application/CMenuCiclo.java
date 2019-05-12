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
		
	}
	
	public void ContactoCiclo(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoCiclo.fxml"));
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
		Tabla.setItems(conexionbbdd.ConsultaCiclos());
	}
	
	
	
	public void setListaCiclo(ObservableList<Ciclo> listaCiclo){
		this.data = listaCiclo;
	}

}
