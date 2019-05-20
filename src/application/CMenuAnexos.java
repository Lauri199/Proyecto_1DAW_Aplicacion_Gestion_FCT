package application;

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

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class CMenuAnexos {
	
	Main ProgramaSecundario;
	TestConexion conexionbbdd;
	Alumno alumno;
	
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
	private TableColumn<Alumno,String>DNI_TE;
	
	@FXML
	private Button GenerarAnexos;
	
	private ObservableList<Alumno> data = FXCollections.observableArrayList();
	
	@FXML
	public void initialize(){
		DNI_ALUM.setCellValueFactory(new PropertyValueFactory<Alumno,String>("dni_alum"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("nombre"));
		Apellido.setCellValueFactory(new PropertyValueFactory<Alumno,String>("apellido"));
		Tiempo_Empleado.setCellValueFactory(new PropertyValueFactory<Alumno,String>("tiempo_empleado"));
		DNI_TC.setCellValueFactory(new PropertyValueFactory<Alumno,String>("dni_tc"));
		DNI_TE.setCellValueFactory(new PropertyValueFactory<Alumno,String>("dni_te"));
		
		conexionbbdd = new TestConexion();
		Tabla.setItems(conexionbbdd.ConsultaAlumno());
	}
	
	//Direccion de donde se guardan los anexos
	//C:\Users\Laura\git\Proyecto_1DAW_Aplicacion_Gestion_FCT\Proyecto_1DAW_Aplicacion_Gestion_FCT 
		public void GenerarAnexos() throws FileNotFoundException, DocumentException {
			System.out.println("Metodo generar anexos");
			TestConexion conexionbbdd = new TestConexion();
			
			Alumno selectedAlumno = Tabla.getSelectionModel().getSelectedItem();
			
			AnexoI anexoI = conexionbbdd.ConsultaAnexoI(selectedAlumno.dni_alum);
			AnexoII anexoII =conexionbbdd.ConsultaAnexoII(selectedAlumno.dni_alum);
			anexoI.generarAnexoI("AnexoI", "C:\\Users\\Laura\\Desktop\\DAW1\\PROYECTO\\ANEXOS\\");
			anexoII.generarAnexoII("AnexoII", "C:\\Users\\Laura\\Desktop\\DAW1\\PROYECTO\\ANEXOS\\");

		}
		
		public void setMain(Main ProgramaSecundario) {
			// TODO Auto-generated method stub
			System.out.println("setMain");
			this.ProgramaSecundario = ProgramaSecundario;
		}
		public void setListaAlumno(ObservableList<Alumno> listaAlumno){
			this.data = listaAlumno;
		}
		
		

	

}
