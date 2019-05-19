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
	ChoiceBox<String> NombreEmpresa;
	
	ObservableList<String> EmpresasList = FXCollections.observableArrayList("");
	
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
		
		EmpresasList = conexionbbdd.ConsultaNombreEmpresas();
		
		NombreEmpresa.setItems(EmpresasList);
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
	        ventana.show();
        }
        else
        {
        	// No se ha seleccionado nada.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionTutorCentro(alert);
        }
		
	}
	
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
	
	
	public void ContactoTutorEmpresa(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoTutorEmpresa.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
        Stage ventana = new Stage();
        ventana.setTitle("Venta Dos");
        Scene scene = new Scene(ventanaDos);
        ventana.setScene(scene);
        ventana.show();
	}
		
	
	@FXML
	public void ActualizaTablaTutorEmpresa(){
		conexionbbdd = new TestConexion();
		String aux = NombreEmpresa.getSelectionModel().getSelectedItem();
		System.out.println("se ha seleccionado  " + aux);
		
		Tabla_TE.setItems(conexionbbdd.ConsultaTutorEmpresaSeleccionado(aux));
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
	        ventana.show();
        }
        else
        {
        	// No se ha seleccionado nada.
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
	
	private void ShowAlertNoSelectionTutorCentro(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Tutor de centro no seleccionado");
        alert.setContentText("Por favor!!! Seleccione un tutor de centro de la tabla");

        alert.showAndWait();
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }
	
	
	public void setListaTC(ObservableList<TutorCentro> listaTC){
		this.data1 = listaTC;
	}
	
}
