package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	 private Stage primaryStage;
	 private AnchorPane rootLayout;
	 
	 Ciclo ciclo;

	 
	 public static void main(String[] args) {
	  launch(args);
	 }
	 
	 @Override
	 public void start(Stage primaryStage) {
	  try {
	   this.primaryStage = primaryStage;
	   this.primaryStage.setTitle("Ventana Principal");
	    // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("UIMenuPrincipal.fxml"));
	            rootLayout = (AnchorPane) loader.load();
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	           } catch(Exception e) {
	   e.printStackTrace();
	  }
	 }
	 
	 
	 /**
	  * CICLO
	  */
	 public void MostrarMenuCiclo() {
	  try {
	   
	    // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("UIMenuCiclos.fxml"));
	            rootLayout = (AnchorPane) loader.load();
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            
	            CMenuCiclo controller = loader.getController();
	            //controller.setListaCiclo(listaCiclo);
	            controller.setMain(this);
	            
	            
	            primaryStage.show();
	           } catch(Exception e) {
	   e.printStackTrace();
	  }
	 }
	 
	 public boolean MostrarContactoCiclo(Ciclo datosCicloaEditar) {
	  try {
	    // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("UIContactoCiclo.fxml"));
	            rootLayout = (AnchorPane) loader.load();
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            
	            CContactoCiclo controller = loader.getController();
	            controller.setCiclo(datosCicloaEditar);
	            controller.setStageSecundario(primaryStage);
	            
	            primaryStage.show();
	            
	            
	            
	            return controller.isOkClicked();
	           } catch(Exception e) {
	   e.printStackTrace();
	   
	   return false;
	  }
	
	 }
	 
	 
	 public void NewCiclo(){
	    	Ciclo CicloNew = new Ciclo(null, null, null, null, null, null, null, null, null, null);
	    	if(MostrarContactoCiclo(CicloNew))
	    		this.ciclo.addCiclo(CicloNew);
	    }
	 
	 /**
	  * EMPRESA
	  */
	 
	 public void MostrarMenuEmpresa() {
		  try {
		   this.primaryStage = primaryStage;
		   this.primaryStage.setTitle("Ventana Secundaria");
		    // Load root layout from fxml file.
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(Main.class.getResource("UIMenuEmpresa.fxml"));
		            rootLayout = (AnchorPane) loader.load();
		            // Show the scene containing the root layout.
		            Scene scene = new Scene(rootLayout);
		            primaryStage.setScene(scene);
		            primaryStage.show();
		           } catch(Exception e) {
		   e.printStackTrace();
		  }
		 }
		 
	 public void MostrarContactoEmpresa() {
		  try {
		   this.primaryStage = primaryStage;
		   this.primaryStage.setTitle("Alumno");
		    // Load root layout from fxml file.
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(Main.class.getResource("UIContactoEmpresa.fxml"));
		            rootLayout = (AnchorPane) loader.load();
		            // Show the scene containing the root layout.
		            Scene scene = new Scene(rootLayout);
		            primaryStage.setScene(scene);
		            primaryStage.show();
		           } catch(Exception e) {
		   e.printStackTrace();
		  }
		 }
	 
	 /**
	  * CENTRO
	  */
		 
	 public void MostrarMenuCentro() {
		  try {
		   this.primaryStage = primaryStage;
		   this.primaryStage.setTitle("Ventana Secundaria");
		    // Load root layout from fxml file.
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(Main.class.getResource("UIMenuCentro.fxml"));
		            rootLayout = (AnchorPane) loader.load();
		            // Show the scene containing the root layout.
		            Scene scene = new Scene(rootLayout);
		            primaryStage.setScene(scene);
		            primaryStage.show();
		           } catch(Exception e) {
		   e.printStackTrace();
		  }
		 }
		 
		 public void MostrarContactoCentro() {
		  try {
		   this.primaryStage = primaryStage;
		   this.primaryStage.setTitle("Alumno");
		    // Load root layout from fxml file.
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(Main.class.getResource("UIContactoCentro.fxml"));
		            rootLayout = (AnchorPane) loader.load();
		            // Show the scene containing the root layout.
		            Scene scene = new Scene(rootLayout);
		            primaryStage.setScene(scene);
		            primaryStage.show();
		           } catch(Exception e) {
		   e.printStackTrace();
		  }
		 }
	 
	 
 
}

