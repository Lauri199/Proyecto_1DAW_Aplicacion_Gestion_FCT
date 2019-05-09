package application;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CMenuPrincipal {
	
	@FXML
	private Button Ciclo;
	
	@FXML
	private Button Nuevo;
	
	Main ProgramaPrincipal;
	
	
	@FXML
    private void nuevaVentana(ActionEvent event) throws IOException {
		System.out.println("Abriendo 2 ventana");
		this.ProgramaPrincipal.mostrarVentanaSecundaria();
    }
	
	
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
	
	

}
