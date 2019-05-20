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
	            scene.getStylesheets().add("MiHojaEstilos.css");
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
		  scene.getStylesheets().add("MiHojaEstilos.css");
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
	 }
	 
	 public boolean NuevoContactoCiclo(Ciclo datosCicloaEditar) {
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
		  scene.getStylesheets().add("MiHojaEstilos.css");
	            
		  return controller.isOkClicked();
	  } catch(Exception e) {
		  e.printStackTrace();
		  return false;
	  }
	
	 }
	 
	 public boolean MostrarModificarContactoCiclo(Ciclo datosCicloaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoModificarCiclo.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoModificarCiclo controller = loader.getController();
			  controller.setCiclo(datosCicloaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		      return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
		   return false;
		  }
		
	 }
	 
	 /**
	  * EMPRESA
	  */
	 
	 public void MostrarMenuEmpresa() {
		  try {
		   
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIMenuEmpresa.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CMenuEmpresa controller = loader.getController();
			  //controller.setListaCiclo(listaCiclo);
			  controller.setMain(this);
		            
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	 }
		 
	 public boolean NuevoContactoEmpresa(Empresa datosEmpresaaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoEmpresa.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoEmpresa controller = loader.getController();
			  controller.setEmpresa(datosEmpresaaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		            
			  return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
			  return false;
		  }
		
	 }
	 
	 
	 public boolean ModificarContactoEmpresa(Empresa datosEmpresaaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoModificarEmpresa.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoModificarEmpresa controller = loader.getController();
			  controller.setEmpresa(datosEmpresaaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		      return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
		   return false;
		  }
		
	 }
	 
	 /**
	  * CENTRO
	  */
		 
	 public void MostrarMenuCentro() {
		  try {
		   
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIMenuCentro.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CMenuEmpresa controller = loader.getController();
			  //controller.setListaCiclo(listaCiclo);
			  controller.setMain(this);
		            
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	 }
		 
	 public boolean NuevoContactoCentro(Centro datosCentroaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoCentro.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoCentro controller = loader.getController();
			  controller.setCentro(datosCentroaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		            
			  return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
			  return false;
		  }
		
	 }
	 
	 public boolean ModificarContactoCentro(Centro datosCentroaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoModificarCentro.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoModificarCentro controller = loader.getController();
			  controller.setCentro(datosCentroaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		      return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
		   return false;
		  }
		
	 }
	 
	 
	 /**
	  * TUTOR CENTRO
	  */
	 public void MostrarMenuTutores() {
		  try {
		   
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIMenuTutores.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CMenuTutorCentroyEmpresa controller = loader.getController();
			  //controller.setListaCiclo(listaCiclo);
			  controller.setMain(this);
		            
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	 }
	 
	 public boolean NuevoContactoTutorCentro(TutorCentro datosTutorCentroaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoTutor.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoTutorCentro controller = loader.getController();
			  controller.setTutorCentro(datosTutorCentroaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		            
			  return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
			  return false;
		  }
		
	 }
	 
	 public boolean ModificarContactoTutorCentro(TutorCentro datosTutorCentroaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoModificarTutorCentro.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoModificarTutorCentro controller = loader.getController();
			  controller.setTutorCentro(datosTutorCentroaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		      return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
		   return false;
		  }
		
	 }
	 
	 /**
	  * TUTOR EMPRESA
	  */
	 
	 public boolean NuevoContactoTutorEmpresa(TutorEmpresa datosTutorCentroaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoTutorEmpresa.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoTutorEmpresa controller = loader.getController();
			  controller.setTutorEmpresa(datosTutorCentroaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		            
			  return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
			  return false;
		  }
		
	 }
	 
	 public boolean ModificarContactoTutorEmpresa(TutorEmpresa datosTutorEmpresaaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoModificarTutorEmpresa.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoModificarTutorEmpresa controller = loader.getController();
			  controller.setTutorEmpresa(datosTutorEmpresaaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		      return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
		   return false;
		  }
		
	 }
	 
	 
	 
	 
	 /**
	  * ALUMNO
	  */
	 
	 public void MostrarMenuAlumno() {
		  try {
		   
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIMenuAlumnos.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CMenuAlumnos controller = loader.getController();
			  //controller.setListaCiclo(listaCiclo);
			  controller.setMain(this);
		            
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	 }
	 
	 public boolean NuevoContactoAlumno(Alumno datosTutorCentroaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoTutorEmpresa.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoAlumno controller = loader.getController();
			  controller.setAlumno(datosTutorCentroaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		            
			  return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
			  return false;
		  }
		
	 }
	 
	 public boolean ModificarContactoAlumno(Alumno datosAlumnoaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoModificarAlumno.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoModificarAlumno controller = loader.getController();
			  controller.setAlumno(datosAlumnoaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		      return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
		   return false;
		  }
		
	 }
	 
	 /**
	  * PRACTICAS
	  */
	 
	 public void MostrarMenuPracticas() {
		  try {
		   
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIMenuAsignar.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CMenuAlumnos controller = loader.getController();
			  //controller.setListaCiclo(listaCiclo);
			  controller.setMain(this);
		            
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	 }
	 
	 public boolean NuevoContactoPracticas(Practicas datosPracticaaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoPracticas.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoPracticas controller = loader.getController();
			  controller.setPractica(datosPracticaaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
			  return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
			  return false;
		  }
		
	 }
	 
	 public boolean ModificarContactoPracticas(Practicas datosPracticaaEditar) {
		  try {
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIContactoModificarPractica.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CContactoModificarPractica controller = loader.getController();
			  controller.setPractica(datosPracticaaEditar);
			  controller.setStageSecundario(primaryStage);
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		      return controller.isOkClicked();
		  } catch(Exception e) {
			  e.printStackTrace();
		   return false;
		  }
		
	 }
	 
	 /**
	  * ANEXOS
	  */
	 public void MostrarMenuAnexos() {
		  try {
		   
		    // Load root layout from fxml file.
			  FXMLLoader loader = new FXMLLoader();
			  loader.setLocation(Main.class.getResource("UIMenuAnexos.fxml"));
			  rootLayout = (AnchorPane) loader.load();
			  // Show the scene containing the root layout.
			  Scene scene = new Scene(rootLayout);
			  primaryStage.setScene(scene);
		            
			  CMenuAnexos controller = loader.getController();
			  //controller.setListaCiclo(listaCiclo);
			  controller.setMain(this);
		            
		            
			  primaryStage.show();
			  scene.getStylesheets().add("MiHojaEstilos.css");
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	 }
	 
 
}

