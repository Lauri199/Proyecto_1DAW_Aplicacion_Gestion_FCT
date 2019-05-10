package application;
	
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private static Stage stagePrincipal;
    private AnchorPane rootPane;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        Main.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIMenuPrincipal.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Ventana Principal");
            stagePrincipal.setScene(scene);
            CMenuPrincipal controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stagePrincipal.show();
        } catch (IOException e) {
            //tratar la excepción.
        }
   }

    public void mostrarMenuCiclos() {
        try {
        	System.out.println("Metodo mostrarVentanaSecundaria");
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIMenuCiclos.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Venta Dos");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);

            CMenuCiclo controller2 = loader.getController();
            controller2.setStagePrincipal(ventana);

            ventana.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    
    public void mostrarContactoCiclos() {
        try {
        	System.out.println("Metodo mostrarVentanaSecundaria");
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("UIContactoCiclo.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Venta Dos");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);

            CMenuCiclo controller2 = loader.getController();
            controller2.setStagePrincipal(ventana);

            ventana.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
}



