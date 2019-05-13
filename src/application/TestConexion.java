package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

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
	
	/**
	 * CICLO
	 */
		
	public ObservableList<Ciclo> ConsultaCiclos() {
		
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
	
	public static int InsertCiclo(String Clave_Ciclo, String Nombre_Ciclo, String Familia_Profesional, String Num_Cursos, String Periodo_Practicas, String ProgramaFormativo, String Cod_Centro ) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Ciclos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("INSERT INTO " + esquema + ".CICLOS VALUES (" +"'" + Clave_Ciclo + "'"+  "," +"'"+Nombre_Ciclo+ "'" + "," +"'"+Familia_Profesional+ "'" + "," +Num_Cursos + "," + "'" + Periodo_Practicas + "'"+  "," +"'"+"'" + "," +"'"+"'" + "," +"'"+"'" + "," + "'" + ProgramaFormativo+ "'" + "," + Cod_Centro +")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".CICLOS VALUES ("+"'" + Clave_Ciclo + "'"+  "," +"'"+Nombre_Ciclo+ "'" + "," +"'"+Familia_Profesional+ "'" + "," +Num_Cursos + "," + "'" + Periodo_Practicas + "'"+  "," +"'"+"'" + "," +"'"+"'" + "," +"'"+"'" + "," + "'"+ ProgramaFormativo+ "'" + "," + Cod_Centro +")");
		return num;
	}
	
	public static int ModificarCiclo(String Clave_Ciclo, String Nombre_Ciclo, String Familia_Profesional, String Num_Cursos, String Periodo_Practicas, String ProgramaFormativo, String Cod_Centro ) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Ciclos modificando sus datos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("UPDATE " + esquema + ".CICLOS SET (" +"Clave_Ciclo='" + Clave_Ciclo + "'"+  ", " +"Nombre_Ciclo='"+Nombre_Ciclo+ "'" + ", " +"Familia_Profesional='"+Familia_Profesional+ "'" + ", " +"Num_Cursos="+Num_Cursos + ", " + "Periodo_Practicas='" + Periodo_Practicas + "'"+  ", " +"Capacidades_terminales='"+"'" + ", " +"Act_Activo_Formativas='"+"'" + ", " +"Criterios_Evaluacion='"+"'" + ", " + "ProgramaFormativo='" + ProgramaFormativo+ "'" + ", " + "Cod_Centro="+ Cod_Centro +") WHERE Clave_Ciclo='" + Clave_Ciclo + "'");
		int num = stmt.executeUpdate("UPDATE " + esquema + ".CICLOS SET " +"Clave_Ciclo='" + Clave_Ciclo + "'"+  ", " +"Nombre_Ciclo='"+Nombre_Ciclo+ "'" + ", " +"Familia_Profesional='"+Familia_Profesional+ "'" + ", " +"Num_Cursos="+Num_Cursos + ", " + "Periodo_Practicas='" + Periodo_Practicas + "'"+  ", " +"Capacidades_terminales='"+"'" + ", " +"Act_Activo_Formativas='"+"'" + ", " +"Criterios_Evaluacion='"+"'" + ", " + "ProgramaFormativo='" + ProgramaFormativo+ "'" + ", " + "Cod_Centro="+ Cod_Centro +" WHERE Clave_Ciclo='" + Clave_Ciclo + "'");
		return num;
	}
	
	public static int BorrarCiclo(String clave_Ciclo, String Nombre_Ciclo, String Familia_Profesional, String Num_Cursos, String Periodo_Practicas, String Capacidades_terminales, String Act_Activo_Formativas, String Criterios_Evaluacion, String ProgramaFormativo, String Cod_Centro) throws SQLException{
		
		System.out.println("Voy a borrar un elemento en la tabla Ciclos");
		
		Statement stmt = conexion.createStatement();
		
		System.out.println("DELETE Employees WHERE EmployeeID = 9");
		System.out.println("DELETE " + esquema + ".CICLOS WHERE CLAVE_CICLO LIKE" + "'"+ clave_Ciclo +"'" + ", " +"Nombre_Ciclo LIKE '"+Nombre_Ciclo+ "'" + ", " +"Familia_Profesional LIKE '"+Familia_Profesional+ "'" + ", " +"Num_Cursos="+Num_Cursos + ", " + "Periodo_Practicas LIKE '" + Periodo_Practicas + "'"+  ", " +"Capacidades_terminales LIKE '"+"'" + ", " +"Act_Activo_Formativas LIKE'"+"'" + ", " +"Criterios_Evaluacion LIKE '"+"'" + ", " + "ProgramaFormativo LIKE '" + ProgramaFormativo+ "'" + ", " + "Cod_Centro="+ Cod_Centro );
		int num = stmt.executeUpdate("DELETE " + esquema + ".CICLOS WHERE CLAVE_CICLO LIKE" + "'"+ clave_Ciclo +"'" + ", " +"Nombre_Ciclo LIKE '"+Nombre_Ciclo+ "'" + ", " +"Familia_Profesional LIKE '"+Familia_Profesional+ "'" + ", " +"Num_Cursos="+Num_Cursos + ", " + "Periodo_Practicas LIKE '" + Periodo_Practicas + "'"+  ", " +"Capacidades_terminales LIKE '"+"'" + ", " +"Act_Activo_Formativas LIKE'"+"'" + ", " +"Criterios_Evaluacion LIKE '"+"'" + ", " + "ProgramaFormativo LIKE '" + ProgramaFormativo+ "'" + ", " + "Cod_Centro="+ Cod_Centro );
		return num;
	}
	
	
	
	/**
	 * EMPRESA
	 */
	
	public ObservableList<Empresa> ConsultaEmpresas() {
			
			ObservableList<Empresa> aux = FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM " +esquema +".Empresa" );
				while(rset.next()) {
					
					String Num_Convenio = rset.getString(1);
					String NIF = rset.getString(2);
					String Nombre_Empresa = rset.getString(3);
					String Representante_Empresa = rset.getString(4);
					String Localidad = rset.getString(5);
					String Provincia = rset.getString(6);
					String Pais = rset.getString(7);
					String Calle = rset.getString(8);
					String Codigo_postal = rset.getString(9);
					String CIF = rset.getString(10);
					String Telefono = rset.getString(11);
					String Fax = rset.getString(12);
					String CiudadFirmaConvenio = rset.getString(13);
					String FechaFirmaConvenio = rset.getString(14);
					
					
					System.out.println(Num_Convenio + ", " + NIF + ", " +Nombre_Empresa + ", " +Representante_Empresa + ", " +Localidad  + ", " + Provincia  + ", " + Pais  + ", " + Calle  + ", " + Codigo_postal  + ", " + CIF + ", " + Telefono +  ", " + Fax + ", " + CiudadFirmaConvenio  + ", " + FechaFirmaConvenio );
					Empresa auxEmpresa = new Empresa(Num_Convenio, NIF, Nombre_Empresa, Representante_Empresa, Localidad, Provincia, Pais, Calle, Codigo_postal, CIF, Telefono, Fax, CiudadFirmaConvenio, FechaFirmaConvenio);
					aux.add(auxEmpresa);
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			return aux;
			
		}
	
	public static int InsertEmpresa(String Num_Convenio, String NIF, String Nombre_Empresa, String Representante_Empresa , String Localidad, String Provincia, String Pais, String Calle, String Codigo_postal, String CIF, String Telefono, String Fax, String CiudadFirmaConvenio, String FechaFirmaConvenio) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Empresa");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("INSERT INTO " + esquema + ".EMPRESA VALUES ("+"'" + Num_Convenio + "'"+  "," +"'"+ NIF + "'" + "," +"'"+ Nombre_Empresa + "'" + "," +"'"+ Representante_Empresa + "'" + "," + "'" + Localidad + "'"+  "," +"'"+ Provincia+ "'" + "," +"'"+ Pais+ "'" + "," +"'"+ Calle +"'" + "," + "'"+ Codigo_postal + "'" + "," + "'"+ CIF + "'" + "," +"'"+ Telefono + "'" + "," +"'"+ Fax + "'" + "," + "'"+ CiudadFirmaConvenio +"'" +  "," +"'"+ FechaFirmaConvenio + "'" +")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".EMPRESA VALUES ("+"'" + Num_Convenio + "'"+  "," +"'"+ NIF + "'" + "," +"'"+ Nombre_Empresa + "'" + ","  +"'"+ Representante_Empresa + "'" + "," + "'" + Localidad + "'"+  "," +"'"+ Provincia+ "'" + "," +"'"+ Pais+ "'" + "," +"'"+ Calle +"'" + "," + "'"+ Codigo_postal + "'" + "," + "'"+ CIF + "'" + "," +"'"+ Telefono + "'" + "," +"'"+ Fax + "'" + "," + "'"+ CiudadFirmaConvenio +"'" +  "," +"'"+ FechaFirmaConvenio + "'" +")");
		return num;
	}
	
	public static int ModificarEmpresa(String Num_Convenio, String NIF, String Nombre_Empresa, String Representante_Empresa , String Localidad, String Provincia, String Pais, String Calle, String Codigo_postal, String CIF, String Telefono, String Fax, String CiudadFirmaConvenio, String FechaFirmaConvenio) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Ciclos modificando sus datos");
		
		Statement stmt = conexion.createStatement();
		
		System.out.println("UPDATE " + esquema + ".EMPRESA SET " +"Num_Convenio='" + Num_Convenio + "'"+  ", " +"NIF='"+NIF+ "'" + ", " +"Nombre_Empresa='"+Nombre_Empresa+ "'" + ", " + "Familia_Profesional='" + "'" + "+ " +"Representante_Empresa='"+Representante_Empresa + "'"+ ", " + "Localidad='" + Localidad + "'"+  ", " +"Provincia='"+ Provincia +"'" + ", " +"Pais='"+Pais+"'" + ", " +"Calle='"+Calle+"'" + ", " + "Codigo_postal='" + Codigo_postal+ "'" + ", " + "CIF='"+ CIF + "'"+ ", " + "Telefono='"+ Telefono + "'" + ", "+ "Fax='"+ Fax + "'" + ", "+ "CiudadFirmaConvenio='"+ CiudadFirmaConvenio + "'" + ", "+ "FechaFirmaConvenio='"+ FechaFirmaConvenio + "'" +" WHERE Num_Convenio='" + Num_Convenio + "'");
		int num = stmt.executeUpdate("UPDATE " + esquema + ".EMPRESA SET " +"Num_Convenio='" + Num_Convenio + "'"+  ", " +"NIF='"+NIF+ "'" + ", " +"Nombre_Empresa='"+Nombre_Empresa+ "'" + ", " +"Representante_Empresa='"+Representante_Empresa + "'"+ ", " + "Localidad='" + Localidad + "'"+  ", " +"Provincia='"+ Provincia +"'" + ", " +"Pais='"+Pais+"'" + ", " +"Calle='"+Calle+"'" + ", " + "Codigo_postal='" + Codigo_postal+ "'" + ", " + "CIF='"+ CIF + "'"+ ", " + "Telefono='"+ Telefono + "'" + ", "+ "Fax='"+ Fax + "'" + ", "+ "CiudadFirmaConvenio='"+ CiudadFirmaConvenio + "'" + ", "+ "FechaFirmaConvenio='"+ FechaFirmaConvenio + "'" +" WHERE Num_Convenio='" + Num_Convenio + "'");
		return num;
	}
	
	
	
	/**
	 * CENTRO
	 */
	
	public ObservableList<Centro> ConsultaCentro() {
		
		ObservableList<Centro> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			System.out.println("Consulta centro");
			ResultSet rset = stmt.executeQuery("SELECT * FROM " +esquema +".Centro" );
			while(rset.next()) {
				
				String Cod_Centro = rset.getString(1);
				String Representante_Centro = rset.getString(2);
				String NIF = rset.getString(3);
				String NombreCentro = rset.getString(4);
				String Ciudad = rset.getString(5);
				String Provincia = rset.getString(6);
				String Calle = rset.getString(7);
				String Codigo_Postal = rset.getString(8);
				String CIF = rset.getString(9);
				String Telefono = rset.getString(10);
				String Fax = rset.getString(11);
				String DAT = rset.getString(12);
				
				
				System.out.println(Cod_Centro + ", " + Representante_Centro + ", " +NIF + ", " +NombreCentro + ", " +Ciudad  + ", " + Provincia + ", " + Calle  + ", " + Codigo_Postal  + ", " + CIF + ", " + Telefono + ", " + Fax + ", " + DAT  );
				Centro auxCentro = new Centro(Cod_Centro, Representante_Centro, NIF, NombreCentro, Ciudad, Provincia, Calle, Codigo_Postal, CIF, Telefono, Fax, DAT);
				aux.add(auxCentro);
				System.out.println("Ya se ha hecho la consulta");
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}

	public static int InsertCentro(String Cod_Centro, String Representante_Centro, String NIF, String NombreCentro , String Ciudad, String Provincia, String Calle, String Codigo_postal, String CIF, String Telefono, String Fax, String DAT) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Empresa");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("INSERT INTO " + esquema + ".CENTRO VALUES ("+"'" + Cod_Centro + "'"+  "," +"'"+ Representante_Centro + "'" + "," +"'"+ NIF + "'" +  "," +"'"+ NombreCentro + "'" + "," + "'" + Ciudad + "'"+  "," +"'"+ Provincia+ "'" + "," +"'"+ Calle +"'" + "," + "'"+ Codigo_postal + "'" + "," + "'"+ CIF + "'" + "," +"'"+ Telefono + "'" + "," +"'"+ Fax + "'" + "," + "'"+ DAT +"'" +")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".CENTRO VALUES ("+"'" + Cod_Centro + "'"+  "," +"'"+ Representante_Centro + "'" + "," +"'"+ NIF + "'"  +  "," +"'"+ NombreCentro + "'" + "," + "'" + Ciudad + "'"+  "," +"'"+ Provincia+ "'" + "," +"'"+ Calle +"'" + "," + "'"+ Codigo_postal + "'" + "," + "'"+ CIF + "'" + "," +"'"+ Telefono + "'" + "," +"'"+ Fax + "'" + "," + "'"+ DAT +"'" +")");
		return num;
	}
	
	
	public static int ModificarCentro(String Cod_Centro, String Representante_Centro, String NIF, String NombreCentro , String Ciudad, String Provincia, String Calle, String Codigo_postal, String CIF, String Telefono, String Fax, String DAT) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Ciclos modificando sus datos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("UPDATE " + esquema + ".Centro SET " +"Cod_Centro=" + Cod_Centro +  ", " +"Representante_Centro='"+Representante_Centro+ "'" + ", " +"NIF='"+NIF+ "'" + ", " +"NombreCentro='"+NombreCentro + "'" + ", " + "Ciudad='" + Ciudad + "'"+  ", " +"Provincia='"+Provincia+"'" + ", " +"Calle='"+Calle+"'" + ", " +"Codigo_postal='"+Codigo_postal+"'" + ", " + "CIF='" + CIF+ "'" + ", " + "Telefono='"+ Telefono + "'" + ", " + "Fax='"+ Fax + "'" + ", " + "DAT='"+ DAT + "'" + " WHERE Cod_Centro=" + Cod_Centro );
		int num = stmt.executeUpdate("UPDATE " + esquema + ".Centro SET " +"Cod_Centro=" + Cod_Centro + ", " +"Representante_Centro='"+Representante_Centro+ "'" + ", " +"NIF='"+NIF+ "'" + ", " +"NombreCentro='"+NombreCentro + "'" + ", " + "Ciudad='" + Ciudad + "'"+  ", " +"Provincia='"+Provincia+"'" + ", " +"Calle='"+Calle+"'" + ", " +"Codigo_postal='"+Codigo_postal+"'" + ", " + "CIF='" + CIF+ "'" + ", " + "Telefono='"+ Telefono + "'" + ", " + "Fax='"+ Fax + "'" + ", " + "DAT='"+ DAT + "'" + " WHERE Cod_Centro=" + Cod_Centro);
		return num;
	}





/**
 * TUTOR CENTRO
 */
	public ObservableList<TutorCentro> ConsultaTutorCentro() {
		
		ObservableList<TutorCentro> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM " +esquema +".Tutor_Centro" );
			while(rset.next()) {
				
				String DNI_TC = rset.getString(1);
				String Nombre = rset.getString(2);
				String Apellido = rset.getString(3);
				String Telefono = rset.getString(4);
				String Gmail = rset.getString(5);
				
				
				System.out.println(DNI_TC + ", " + Nombre + ", " +Apellido + ", " +Telefono + ", " +Gmail);
				TutorCentro auxTC = new TutorCentro(DNI_TC, Nombre, Apellido, Telefono, Gmail);
				aux.add(auxTC);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}
	
	public static int InsertTutorCentro(String DNI_TC, String Nombre, String Apellido, String Telefono, String Gmail) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Tutor Centro");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("INSERT INTO " + esquema + ".Tutor_Centro VALUES (" +"'" + DNI_TC + "'"+  "," +"'"+Nombre+ "'" + "," +"'"+Apellido+ "'" + "," +"'"+Telefono + "'" + "," + "'" + Gmail + "'"+ ")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".Tutor_Centro VALUES (" +"'" + DNI_TC + "'"+  "," +"'"+Nombre+ "'" + "," +"'"+Apellido+ "'" + "," +"'"+Telefono + "'" + "," + "'" + Gmail + "'"+ ")");
		return num;
	}
	
	public static int ModificarTutorCentro(String DNI_TC, String Nombre, String Apellido, String Telefono, String Gmail ) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Tutor Centro modificando sus datos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("UPDATE " + esquema + ".Tutor_Centro SET " +"DNI_TC='" + DNI_TC + "'"+  ", " +"Nombre='"+Nombre+ "'" + ", " +"Apellido='"+Apellido+ "'" + ", " +"Telefono='"+Telefono + "'"+", " + "Gmail='" + Gmail + "'"+ " WHERE DNI_TC='" + DNI_TC + "'");
		int num = stmt.executeUpdate("UPDATE " + esquema + ".Tutor_Centro SET " +"DNI_TC='" + DNI_TC + "'"+  ", " +"Nombre='"+Nombre+ "'" + ", " +"Apellido='"+Apellido+ "'" + ", " +"Telefono='"+Telefono + "'"+", " + "Gmail='" + Gmail + "'"+ " WHERE DNI_TC='" + DNI_TC + "'");
		return num;
	}
	
	
	/**
	 * TUTOR EMPRESA
	 */
	
	public ObservableList<TutorEmpresa> ConsultaTutorEmpresa() {
		
		ObservableList<TutorEmpresa> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM " +esquema +".Tutor_Empresa" );
			while(rset.next()) {
				
				String DNI_TE = rset.getString(1);
				String Nombre = rset.getString(2);
				String Apellido = rset.getString(3);
				String Telefono = rset.getString(4);
				String Gmail = rset.getString(5);
				String Num_Convenio = rset.getString(5);
				
				
				System.out.println(DNI_TE + ", " + Nombre + ", " +Apellido + ", " +Telefono + ", " +Gmail + ", " +Num_Convenio);
				TutorEmpresa auxTC = new TutorEmpresa(DNI_TE, Nombre, Apellido, Telefono, Gmail, Num_Convenio );
				aux.add(auxTC);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}
	
	public static int InsertTutorEmpresa(String DNI_TC, String Nombre, String Apellido, String Telefono, String Gmail, String Num_Convenio ) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Tutor Centro");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("INSERT INTO " + esquema + ".Tutor_Empresa VALUES (" +"'" + DNI_TC + "'"+  "," +"'"+Nombre+ "'" + "," +"'"+Apellido+ "'" + "," +"'"+Telefono + "'" + "," + "'" + Gmail + "'"+"," + "'" + Num_Convenio + "'"+ ")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".Tutor_Empresa VALUES (" +"'" + DNI_TC + "'"+  "," +"'"+Nombre+ "'" + "," +"'"+Apellido+ "'" + "," +"'"+Telefono + "'" + "," + "'" + Gmail + "'"+"," + "'" + Num_Convenio + "'"+ ")");
		return num;
	}
	
	public static int ModificarTutorEmpresa(String DNI_TE, String Nombre, String Apellido, String Telefono, String Gmail, String Num_Convenio ) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Tutor Centro modificando sus datos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("UPDATE " + esquema + ".Tutor_Empresa SET " +"DNI_TE='" + DNI_TE + "'"+  ", " +"Nombre='"+Nombre+ "'" + ", " +"Apellido='"+Apellido+ "'" + ", " +"Telefono='"+Telefono + "'"+", " + "Gmail='" + Gmail + "'"+", " + "Num_Convenio='" + Num_Convenio + "'"+ " WHERE DNI_TE='" + DNI_TE + "'");
		int num = stmt.executeUpdate("UPDATE " + esquema + ".Tutor_Empresa SET " +"DNI_TE='" + DNI_TE + "'"+  ", " +"Nombre='"+Nombre+ "'" + ", " +"Apellido='"+Apellido+ "'" + ", " +"Telefono='"+Telefono + "'"+", " + "Gmail='" + Gmail + "'"+", " + "Num_Convenio='" + Num_Convenio + "'"+ " WHERE DNI_TE='" + DNI_TE + "'");
		return num;
	}


	

}