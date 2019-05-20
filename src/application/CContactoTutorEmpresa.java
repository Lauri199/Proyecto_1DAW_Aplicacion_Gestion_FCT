package application;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CContactoTutorEmpresa {
	
	@FXML
	private Button add;
	
	@FXML
	private TextField DNI_TE;
	
	@FXML
	private TextField Nombre;
	
	@FXML
	private TextField Apellido;
	
	@FXML
	private TextField Telefono;
	
	@FXML
	private TextField Gmail;
	
	
	
	
	@FXML
	private TableView<Empresa> Tabla;
	
	@FXML
	private TableColumn<Empresa,String> Num_ConvenioColum;

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
	private TableColumn<Empresa,String> TelefonoColum;
	
	@FXML
	private TableColumn<Empresa,String> Fax;
	
	@FXML
	private TableColumn<Empresa,String> CiudadFirmaConvenio;
	
	@FXML
	private TableColumn<Empresa,String> FechaFirmaConvenio;
	
	
	

	
	TestConexion conexionbbdd;
	
	private Stage ventanaTres;
    private TutorEmpresa tutorempresa;
    private boolean okClicked = false;
    
    @FXML
	public void initialize(){
		Num_ConvenioColum.setCellValueFactory(new PropertyValueFactory<Empresa,String>("num_convenio"));
		NIF.setCellValueFactory(new PropertyValueFactory<Empresa,String>("nif"));
		Nombre_Empresa.setCellValueFactory(new PropertyValueFactory<Empresa,String>("nombre"));
		Representante_Empresa.setCellValueFactory(new PropertyValueFactory<Empresa,String>("representante"));
		Localidad.setCellValueFactory(new PropertyValueFactory<Empresa,String>("localidad"));
		Provincia.setCellValueFactory(new PropertyValueFactory<Empresa,String>("provincia"));
		Pais.setCellValueFactory(new PropertyValueFactory<Empresa,String>("pais"));
		Calle.setCellValueFactory(new PropertyValueFactory<Empresa,String>("calle"));
		Codigo_postal.setCellValueFactory(new PropertyValueFactory<Empresa,String>("codigo_postal"));
		CIF.setCellValueFactory(new PropertyValueFactory<Empresa,String>("cif"));
		TelefonoColum.setCellValueFactory(new PropertyValueFactory<Empresa,String>("telefono"));
		Fax.setCellValueFactory(new PropertyValueFactory<Empresa,String>("fax"));
		CiudadFirmaConvenio.setCellValueFactory(new PropertyValueFactory<Empresa,String>("ciudad_firma_convenio"));
		FechaFirmaConvenio.setCellValueFactory(new PropertyValueFactory<Empresa,String>("fecha_firma_convenio"));
		
		conexionbbdd = new TestConexion();
		Tabla.setItems(conexionbbdd.ConsultaEmpresas());
	}
    

    public void setStageSecundario(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventanaTres = ventana;
	}
    
    	
	public void setTutorEmpresa(TutorEmpresa tutorempresa) {
        this.tutorempresa = tutorempresa;

        System.out.println("setTutorEmpresa");
        DNI_TE.setText(tutorempresa.getDni());
        Nombre.setText(tutorempresa.getNombre());
        Apellido.setText(tutorempresa.getApellido());
        Telefono.setText(tutorempresa.getTelefono());
        Gmail.setText(tutorempresa.getGmail());
        
        okClicked = true;
        
    }
	
	public boolean isOkClicked() {
    	return okClicked;
    }


    @FXML
    private void handleCancel() {
    	ventanaTres.close();
    }
    
    @FXML
    private void InsertarTutorCentro() throws SQLException {
    	conexionbbdd = new TestConexion();
    	
    	try {
    		
    		Empresa selectedEmpresa = Tabla.getSelectionModel().getSelectedItem();
    		if (selectedEmpresa != null) {
    			conexionbbdd.InsertTutorEmpresa(DNI_TE.getText(), Nombre.getText(), Apellido.getText(), Telefono.getText(), Gmail.getText(), selectedEmpresa.num_convenio);
    		}else {
    			Alert alert = new Alert(AlertType.ERROR);
            	ShowAlertNoSelectionEmpresa(alert);
    		}
    		
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			isInputValid();
		}

    }
    
    private void ShowAlertNoSelectionEmpresa(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Empresa no seleccionada");
        alert.setContentText("Por favor!!! Seleccione una empresa de la tabla");

        alert.showAndWait();
        isInputValid();
    }

    
    private void isInputValid() {
        String errorMessage = "";

        if (DNI_TE.getText() == null || DNI_TE.getText().length() == 0) {
            errorMessage += "DNI no válido!\n";
        }
        if (Nombre.getText() == null || Nombre.getText().length() == 0) {
            errorMessage += "Nombre no válido!\n";
        }
        if (Apellido.getText() == null || Apellido.getText().length() == 0) {
            errorMessage += "Apellido no válido!\n";
        }
        
        if (Telefono.getText() == null || Telefono.getText().length() == 0) {
            errorMessage += "Telefono no válido!\n";
        }
        if (Gmail.getText() == null || Gmail.getText().length() == 0) {
            errorMessage += "Gmail no válido!\n";
        }
        
        
        if (errorMessage.length() != 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos incorrectos!!");
            alert.setContentText("Por favor, corrija campos incorrectos");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            
        }
    }


}
