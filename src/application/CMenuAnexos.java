package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class CMenuAnexos {
	
	Main ProgramaSecundario;
	
	private boolean okClicked = false;
	@FXML
	private Button GenerarAnexos;
	
	//Direccion de donde se guardan los anexos
	//C:\Users\Laura\git\Proyecto_1DAW_Aplicacion_Gestion_FCT\Proyecto_1DAW_Aplicacion_Gestion_FCT 
		public void GenerarAnexos() throws FileNotFoundException, DocumentException {
			System.out.println("Metodo generar anexos");
			TestConexion conexionbbdd = new TestConexion();
			
			AnexoI anexoI = conexionbbdd.ConsultaAnexoI();
			AnexoII anexoII =conexionbbdd.ConsultaAnexoII();
			anexoI.generarAnexoI("AnexoI", "C:\\Users\\daw1.AI-ROBOT-O7\\");
			anexoII.generarAnexoII("AnexoII", "C:\\Users\\daw1.AI-ROBOT-O7\\");

		}
		
		public void setMain(Main ProgramaSecundario) {
			// TODO Auto-generated method stub
			System.out.println("setMain");
			this.ProgramaSecundario = ProgramaSecundario;
		}
		
		public boolean isOkClicked() {
	    	return okClicked;
	    }

	

}
