package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableColumn<Ciclo,String> Cod_Centro;
	
	@FXML
	private Button Actualizar;
	
	private Stage ventanaDos;
	
	TestConexion conexionbbdd;
	
	private boolean okClicked = false;
	
	private ObservableList<Ciclo> data = FXCollections.observableArrayList();
	
	@FXML
	public void initialize(){
		Clave_Ciclo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Clave_Ciclo"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Nom_Ciclo"));
		Fam_Prof.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Familia_prof"));
		Num_Cursos.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Num_cursos"));
		Period_Pract.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Period_Pract"));
		Cap_terminales.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Capac_term"));
		Act_Form.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Act_Form"));
		Criterio.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Criterios_eva"));
		Cod_Centro.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Cod_Centro"));
		
	}
	
	
	public boolean isOkClicked() {
    	return okClicked;
    }
	
	@FXML
	public void ActualizaTabla(){
		conexionbbdd = new TestConexion();
		Tabla.setItems(conexionbbdd.Consulta());
	}
	
	public void setListaCiclo(ObservableList<Ciclo> listaCiclo){
		this.data = listaCiclo;
	}
	
	
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaDos = ventana;
	}

}
