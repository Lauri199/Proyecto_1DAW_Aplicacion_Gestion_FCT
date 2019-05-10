package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TestConexion {

	private String bd;
	private String url= "";
	private String usr = "";
	private String pwd = "";
	private static String esquema="";
	private static Connection conexion;
	

	public TestConexion()  {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		
		try {
			
			File miFichero = new File("src/Configuracion.ini");
			if(miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url = propiedades.getProperty("url");
				usr = propiedades.getProperty("usr");
				pwd = propiedades.getProperty("pwd");
				esquema = propiedades.getProperty("esquema");
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(url, usr, pwd);
				
				
			}else {
				System.out.println("Fichero no encontrado");
			}
			if(!conexion.isClosed()) {
				System.out.println("Conexión establecida");
				//conexion.close();
			}
			else
				System.out.println("Fallo en Conexión");	
			

		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");	
			e.printStackTrace();
		}finally {
			if(entrada !=null) {
				try {
					entrada.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
		
	public ObservableList<Ciclo> Consulta() {
		
		ObservableList<Ciclo> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM " +esquema +".Ciclos" );
			while(rset.next()) {
				
				String Clave = rset.getString(1);
				String Nombre = rset.getString(2);
				String Familia = rset.getString(3);
				String Num_Cursos = rset.getString(4);
				String Period_Practicas = rset.getString(5);
				String Capacidades = rset.getString(6);
				String Act_Form = rset.getString(7);
				String Criterios = rset.getString(8);
				String programa_formativo = rset.getString(9);
				String Cod_Centro = rset.getString(10);
				
				
				System.out.println(Clave + ", " + Nombre + ", " +Familia + ", " +Num_Cursos + ", " +Period_Practicas  + ", " + Capacidades  + ", " + Act_Form  + ", " + Criterios  + ", " + programa_formativo  + ", " + Cod_Centro );
				Ciclo auxCiclo = new Ciclo(Clave, Nombre, Familia, Num_Cursos, Period_Practicas, Capacidades, Act_Form, Criterios, programa_formativo, Cod_Centro);
				aux.add(auxCiclo);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}
	
	
	/*public static int InsertCiclo() throws SQLException{
		System.out.println("Voy a hacer un insert en la tabla Ciclos");
		Statement stmt = conexion.createStatement();
		
		int num = stmt.executeUpdate("INSERT INTO " + esquema +".USUARIO2 VALUES (Clave_Ciclo.getText(), Nombre_Ciclo.getText(), Familia_Profesional.getText(), Num_Cursos.getText(), Periodo_Practicas.getText(), Capacidades_terminales.getText(), Act_Activo_Formativas.getText(), Criterios_Evaluacion.getText(), ProgramaFormativo.getText(), Cod_Centro.getText())");
		return num;
		
	}*/
	
	public static int InsertCiclo(String Clave_Ciclo, String Nombre_Ciclo, String Familia_Profesional, String Num_Cursos, String Periodo_Practicas, String Capacidades_terminales, String Act_Activo_Formativas, String Criterios_Evaluacion, String ProgramaFormativo, String Cod_Centro ) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla 	USUARIO2");
		
		Statement stmt = conexion.createStatement();//Introduce los datos
		
		//INSERT INTO SCHEMA.NOMBRE_TABLA VALUES ();
		
		
		System.out.println("INSERT INTO " + esquema + ".USUARIO2 VALUES (" +"'" + Clave_Ciclo + "'"+  "," +"'"+Nombre_Ciclo+ "'" + "," +"'"+Familia_Profesional+ "'" + "," +Num_Cursos + "," + "'" + Periodo_Practicas + "'" + "," +"'"+Capacidades_terminales+ "'" + "," +"'"+Act_Activo_Formativas+ "'" + ","+ "'" + Criterios_Evaluacion + "'"  + "," +"'"+ProgramaFormativo+ "'" + "," + Cod_Centro +")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".USUARIO2 VALUES (" +"'" + Clave_Ciclo + "'"+  "," +"'"+Nombre_Ciclo+ "'" + "," +"'"+Familia_Profesional+ "'" + "," +Num_Cursos + "," + "'" + Periodo_Practicas + "'" + "," +"'"+Capacidades_terminales+ "'" + "," +"'"+Act_Activo_Formativas+ "'" + ","+ "'" + Criterios_Evaluacion + "'"  + "," +"'"+ProgramaFormativo+ "'" + "," + Cod_Centro +")");
		return num;
	}
	
	

}