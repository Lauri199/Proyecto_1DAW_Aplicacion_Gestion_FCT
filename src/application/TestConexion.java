package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
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
	 * ANEXOS
	 */
	
	public AnexoI ConsultaAnexoI() {
	
		AnexoI aux = null;
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT Empresa.Num_Convenio, Centro.Representante_Centro, Centro.NIF, Centro.NombreCentro, Centro.Cod_Centro, Centro.Ciudad, Centro.Provincia, Centro.Calle, Centro.Codigo_Postal, Centro.CIF, Centro.Telefono, Centro.Fax, Centro.DAT, Empresa.Representante_Empresa, Empresa.NIF, Empresa.Nombre_Empresa, Empresa.Localidad, Empresa.Provincia, Empresa.Pais, Empresa.Calle, Empresa.Codigo_Postal, Empresa.CIF, Empresa.Telefono, Empresa.Fax FROM " + esquema + ".Empresa, " + esquema + ".Centro, " + esquema + ".Ciclos, " + esquema + ".Cursan, " + esquema + ".Alumnos, " + esquema + ".Asignan WHERE Centro.Cod_Centro=Ciclos.Cod_Centro AND Ciclos.Clave_Ciclo=Cursan.Clave_Ciclo AND Cursan.DNI_ALUM=Alumnos.DNI_ALUM AND Alumnos.DNI_ALUM=Asignan.DNI_ALUM AND Asignan.Num_Convenio=Empresa.Num_Convenio AND Empresa.Num_Convenio='12345G'\r\n" + 
					"" );
			while(rset.next()) {
				
				String Num_Convenio = rset.getString(1);
				String Representante_Centro = rset.getString(2);
				String Apellidos = "";
				String NIF = rset.getString(3);
				String NombreCentro = rset.getString(4);
				String Cod_Centro = rset.getString(5);
				String Ciudad = rset.getString(6);
				String Provincia = rset.getString(7);
				String Calle = rset.getString(8);
				String Codigo_Postal = rset.getString(9);
				String CIF = rset.getString(10);
				String Telefono = rset.getString(11);
				String Fax = rset.getString(12);
				String DAT = rset.getString(12);
				String Representante_Empresa = rset.getString(13);
				String Apellido_Representante_Empresa="";
				String NIF_Empresa = rset.getString(14);
				String Nombre_Empresa = rset.getString(15);
				String Localidad = rset.getString(16);
				String Provincia_Empresa = rset.getString(17);
				String Pais = rset.getString(18);
				String Calle_Empresa = rset.getString(19);
				String Codigo_Postal_Empresa = rset.getString(20);
				String CIF_Empresa = rset.getString(21);
				String Telefono_Empresa = rset.getString(22);
				String Fax_Empresa = rset.getString(23);
				
	
				DatosColegio auxDatosColegio = new DatosColegio(Representante_Centro, Apellidos, NIF, NombreCentro, Cod_Centro, Provincia, Calle, Codigo_Postal, CIF, Telefono, Fax, Ciudad, DAT);
				DatosEmpresa auxDatosEmpresa = new DatosEmpresa(Representante_Empresa, Apellido_Representante_Empresa, NIF_Empresa, Nombre_Empresa, Num_Convenio, Provincia_Empresa, Calle_Empresa, Codigo_Postal_Empresa, CIF_Empresa, Telefono_Empresa, Fax_Empresa, Localidad);
				//AnexoI auxAnexo = new AnexoI(Num_Convenio, Representante_Centro, NIF, NombreCentro, Cod_Centro, Ciudad, Provincia, Calle, Codigo_Postal, CIF, Telefono, Fax, Representante_Centro, NIF_Empresa, Nombre_Empresa, Localidad, Provincia_Empresa, Pais, Calle_Empresa, Codigo_Postal_Empresa, CIF_Empresa, Telefono_Empresa, Fax_Empresa);
				
				aux = new AnexoI(auxDatosColegio, auxDatosEmpresa);
				
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}
	
	
	public AnexoII ConsultaAnexoII() {
		
		AnexoII aux = null;
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT Ce.DAT, E.Num_Convenio, Ce.NombreCentro, E.Nombre_Empresa, Ci.Clave_Ciclo, Ci.Nombre_Ciclo, A.Fecha_Inicio, A.Fecha_Terminacion, A.Dias_Semana, A.Tipo_Horario, A.Horas_al_dia, a.Total_horas, A.Hora_Inicio, A.Hora_terminacion, E.Localidad, E.Calle, Ce.NIF, TE.Nombre, TE.Apellido, E.CiudadFirmaConvenio, E.FechaFirmaConvenio, Ce.Representante_Centro, E.Representante_Empresa, Ce.Cod_Centro, Ce.Provincia, E.NIF, Ce.Codigo_Postal, Ce.CIF, Ce.Telefono, Ce.Fax, Ce.Ciudad, E.Provincia, E.Codigo_Postal, E.CIF, E.Telefono, E.Fax, C.Curso, Ce.Calle, Alum.Nombre, Alum.Apellido, Alum.DNI_ALUM, TC.DNI_TC, TC.Nombre, TC.Apellido, TE.DNI_TE FROM "+ esquema + ".Empresa E, " + esquema + ".Centro Ce, " + esquema + ".Ciclos Ci, " + esquema + ".Cursan C, "+ esquema + ".Alumnos Alum, "+ esquema + ".Asignan A, "+ esquema + ".Tutor_Empresa TE, " + esquema + ".Tutor_Centro TC WHERE Ce.Cod_Centro=Ci.Cod_Centro AND Ci.Clave_Ciclo=C.Clave_Ciclo AND C.DNI_ALUM=Alum.DNI_ALUM AND Alum.DNI_ALUM=A.DNI_ALUM AND A.Num_Convenio=E.Num_Convenio AND TE.Num_Convenio=E.Num_Convenio AND TC.DNI_TC=Alum.DNI_TC AND E.Num_Convenio='12345G'");
			while(rset.next()) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				String DAT = rset.getString(1);
				String Num_Convenio = rset.getString(2);
				String NombreCentro = rset.getString(3);
				String Nombre_Empresa = rset.getString(4);
				String Clave_Ciclo = rset.getString(5);
				String Nombre_Ciclo = rset.getString(6);
				String FechaInicio = sdf.format(rset.getDate(7));
				String Fecha_Terminacion = sdf.format(rset.getDate(8));
				String Dias_Semana = rset.getString(9);
				String Tipo_Horario = rset.getString(10);
				int Horas_al_dia = rset.getInt(11);
				int Total_horas = rset.getInt(12);
				String Hora_Inicio = rset.getString(13);
				String Hora_terminacion = rset.getString(14);
				String horainiciotarde="";
				String horafintarde="";
				String Localidad = rset.getString(15);
				String Calle_Empresa = rset.getString(16);
				String NIF = rset.getString(17);
				String Nombre_TE = rset.getString(18);
				String Apellidos_TE = rset.getString(19);
				String CiudadFirmaConvenio = rset.getString(20);
				String FechaFirmaConvenio = rset.getString(21);
				String Representante_Centro = rset.getString(22);
				String Apellidos = "";
				String Representante_Empresa = rset.getString(23);
				String Apellido_Representante_Empresa="";
				String Cod_Centro = rset.getString(24);
				String Provincia = rset.getString(25);
				String NIF_Empresa = rset.getString(26);
				String Codigo_Postal = rset.getString(27);
				String CIF = rset.getString(28);
				String Telefono = rset.getString(29);
				String Fax = rset.getString(30);
				String Ciudad = rset.getString(31);
				String Provincia_Empresa = rset.getString(32);
				String Codigo_Postal_Empresa = rset.getString(33);
				String CIF_Empresa = rset.getString(34);
				String Telefono_Empresa = rset.getString(35);
				String Fax_Empresa = rset.getString(36);
				String Curso = rset.getString(36);
				String Calle = rset.getString(37);
				String Nombre_Alum = rset.getString(38);
				String Apellido_Alum = rset.getString(39);
				String DNI_ALUM = rset.getString(40);
				String DNI_TC = rset.getString(41);
				String Nombre_TC = rset.getString(42);
				String Apellido_TC = rset.getString(43);
				String DNI_TE = rset.getString(44);
				
				
				DatosColegio auxDatosColegio = new DatosColegio(Representante_Centro, Apellidos, NIF, NombreCentro, Cod_Centro, Provincia, Calle, Codigo_Postal, CIF, Telefono, Fax, Ciudad, DAT);
				DatosEmpresa auxDatosEmpresa = new DatosEmpresa(Representante_Empresa, Apellido_Representante_Empresa, NIF_Empresa, Nombre_Empresa, Num_Convenio, Provincia_Empresa, Calle_Empresa, Codigo_Postal_Empresa, CIF_Empresa, Telefono_Empresa, Fax_Empresa, Localidad);
				DatosAlumnos auxDatosAlumnos = new DatosAlumnos(Curso, Clave_Ciclo, Nombre_Ciclo, FechaInicio, Fecha_Terminacion, Dias_Semana, Hora_Inicio, horainiciotarde, Hora_terminacion, horafintarde, Horas_al_dia, Total_horas, Localidad, Calle, Nombre_Alum, Apellido_Alum, DNI_ALUM, Nombre_TC, Apellido_TC, DNI_TC, Nombre_TE, Apellidos_TE);
				//AnexoI auxAnexo = new AnexoI(Num_Convenio, Representante_Centro, NIF, NombreCentro, Cod_Centro, Ciudad, Provincia, Calle, Codigo_Postal, CIF, Telefono, Fax, Representante_Centro, NIF_Empresa, Nombre_Empresa, Localidad, Provincia_Empresa, Pais, Calle_Empresa, Codigo_Postal_Empresa, CIF_Empresa, Telefono_Empresa, Fax_Empresa);
				
				aux = new AnexoII(auxDatosColegio, auxDatosEmpresa, auxDatosAlumnos);
				
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
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
	
	public static int InsertCiclo(String Clave_Ciclo, String Nombre_Ciclo, String Familia_Profesional, String Num_Cursos, String Periodo_Practicas, String ProgramaFormativo, String Cod_Centro) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Ciclos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("INSERT INTO " + esquema + ".CICLOS VALUES (" +"'" + Clave_Ciclo + "'"+  "," +"'"+Nombre_Ciclo+ "'" + "," +"'"+ Familia_Profesional+ "'" + "," +Num_Cursos + "," + "'" + Periodo_Practicas + "'"+  "," +"'"+"'" + "," +"'"+"'" + "," +"'"+"'" + "," + "'" + ProgramaFormativo+ "'" + ", " + Cod_Centro + ")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".CICLOS VALUES (" +"'" + Clave_Ciclo + "'"+  "," +"'"+Nombre_Ciclo+ "'" + "," +"'"+ Familia_Profesional+ "'" + "," +Num_Cursos + "," + "'" + Periodo_Practicas + "'"+  "," +"'"+"'" + "," +"'"+"'" + "," +"'"+"'" + "," + "'" + ProgramaFormativo+ "'" + ", " + Cod_Centro + ")");
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
		
		System.out.println("DELETE FROM " + esquema + ".CICLOS WHERE clave_Ciclo=" + "'"+ clave_Ciclo +"'");
		int num = stmt.executeUpdate("DELETE FROM " + esquema + ".CICLOS WHERE clave_Ciclo=" + "'"+ clave_Ciclo +"'");
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
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
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
					String FechaFirmaConvenio = sdf.format(rset.getDate(14));
					
					
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
	
	public static int BorrarEmpresa(String Num_Convenio) throws SQLException{
		
		System.out.println("Voy a borrar un elemento en la tabla Empresa");
		
		Statement stmt = conexion.createStatement();
		
		System.out.println("DELETE FROM " + esquema + ".EMPRESA WHERE Num_Convenio='" + Num_Convenio + "'");
		int num = stmt.executeUpdate("DELETE FROM " + esquema + ".EMPRESA WHERE Num_Convenio='" + Num_Convenio + "'");
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
	public static int BorrarCentro(String Cod_Centro) throws SQLException{
		
		System.out.println("Voy a borrar un elemento en la tabla Centro");
		
		Statement stmt = conexion.createStatement();
		
		System.out.println("DELETE FROM " + esquema + ".Centro WHERE Cod_Centro='" + Cod_Centro + "'");
		int num = stmt.executeUpdate("DELETE FROM " + esquema + ".Centro WHERE Cod_Centro='" + Cod_Centro + "'");
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
	public static int BorrarTutorCentro(String DNI_TC ) throws SQLException{
		
		System.out.println("Voy a borrar un elemento en la tabla Tutor_Centro");
		
		Statement stmt = conexion.createStatement();
		
		System.out.println("DELETE FROM " + esquema + ".Tutor_Centro WHERE DNI_TC ='" + DNI_TC + "'");
		int num = stmt.executeUpdate("DELETE FROM " + esquema + ".Tutor_Centro WHERE DNI_TC ='" + DNI_TC + "'");
		return num;
	}
	
	
	

	
	
	
	
	
	/**
	 * TUTOR EMPRESA
	 */
	
	
	public ObservableList<TutorEmpresa> ConsultaTodosTutorEmpresa() {
		
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
	
	public ObservableList<TutorEmpresa> ConsultaTutorEmpresaSeleccionado(String nombreempresa) {
		
		ObservableList<TutorEmpresa> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ esquema + ".Tutor_Empresa, " + esquema + ".Empresa WHERE Empresa.Num_Convenio = Tutor_Empresa.Num_Convenio AND Empresa.Nombre_Empresa = '" + nombreempresa +"'");
			while(rset.next()) {
				
				String DNI_TE = rset.getString(1);
				String Nombre = rset.getString(2);
				String Apellido = rset.getString(3);
				String Telefono = rset.getString(4);
				String Gmail = rset.getString(5);
				String Num_Convenio = rset.getString(6);
				
				
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
	
	public ObservableList<Empresa> ConsultaEmpresasParaContactoTE(String nombreempresas) {
		
		ObservableList<Empresa> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ esquema + ".Empresa, " + esquema + ".Tutor_Empresa WHERE Empresa.Num_Convenio = Tutor_Empresa.Num_Convenio AND Empresa.Nombre_Empresa = '" + nombreempresas +"'");
			while(rset.next()) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
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
				String FechaFirmaConvenio = sdf.format(rset.getDate(14));
				
				
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
	
	public static int BorrarTutorEmpresa(String DNI_TE ) throws SQLException{
		
		System.out.println("Voy a borrar un elemento en la tabla Tutor_Empresa");
		
		Statement stmt = conexion.createStatement();
		
		System.out.println("DELETE FROM " + esquema + ".Tutor_Empresa WHERE DNI_TE ='" + DNI_TE + "'");
		int num = stmt.executeUpdate("DELETE FROM " + esquema + ".Tutor_Empresa WHERE DNI_TE ='" + DNI_TE + "'");
		return num;
	}
	
	public ObservableList<String> ConsultaNombreEmpresas() {
		
		ObservableList<String> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "  + esquema + ".Empresa" );
			while(rset.next()) {
				aux.add(rset.getString(3));

			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}
	
	
	/**
	 * ALUMNOS
	 */
	
	public ObservableList<Alumno> ConsultaAlumno() {
		
		ObservableList<Alumno> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM " +esquema +".Alumnos" );
			while(rset.next()) {
				
				String DNI_ALUM = rset.getString(1);
				String Nombre = rset.getString(2);
				String Apellido = rset.getString(3);
				String TiempoEmpleado = rset.getString(4);
				String DNI_TC  = rset.getString(5);
				String DNI_TE  = rset.getString(6);
				
				
				System.out.println(DNI_ALUM + ", " + Nombre + ", " +Apellido + ", " +TiempoEmpleado + ", " +DNI_TC + ", " +DNI_TE );
				Alumno auxTC = new Alumno(DNI_ALUM, Nombre, Apellido, TiempoEmpleado, DNI_TC, DNI_TE  );
				aux.add(auxTC);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}

	public static int InsertAlumno(String DNI_ALUM, String Nombre, String Apellido, String TiempoEmpleado, String DNI_TC, String DNI_TE ) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Alumnos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("INSERT INTO " + esquema + ".Alumnos VALUES (" +"'" + DNI_ALUM + "'"+  "," +"'"+Nombre+ "'" + "," +"'"+Apellido+ "'" + "," +"'"+TiempoEmpleado + "'" + "," + "'" + DNI_TC + "'"+"," + "'" + DNI_TE + "'"+ ")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".Alumnos VALUES (" +"'" + DNI_ALUM + "'"+  "," +"'"+Nombre+ "'" + "," +"'"+Apellido+ "'" + "," +"'"+TiempoEmpleado + "'" + "," + "'" + DNI_TC + "'"+"," + "'" + DNI_TE + "'"+ ")");
		return num;
	}
	
	public static int ModificarAlumno(String DNI_ALUM, String Nombre, String Apellido, String TiempoEmpleado, String DNI_TC, String DNI_TE ) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Alumnos modificando sus datos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("UPDATE " + esquema + ".Alumnos SET " +"DNI_ALUM='" + DNI_ALUM + "'"+  ", " +"Nombre='"+Nombre+ "'" + ", " +"Apellido='"+Apellido+ "'" + ", " +"Tiempo_Empleado ='"+TiempoEmpleado + "'"+", " + "DNI_TC='" + DNI_TC + "'"+", " + "DNI_TE='" + DNI_TE + "'"+ " WHERE DNI_ALUM='" + DNI_ALUM + "'");
		int num = stmt.executeUpdate("UPDATE " + esquema + ".Alumnos SET " +"DNI_ALUM='" + DNI_ALUM + "'"+  ", " +"Nombre='"+Nombre+ "'" + ", " +"Apellido='"+Apellido+ "'" + ", " +"Tiempo_Empleado  ='"+TiempoEmpleado + "'"+", " + "DNI_TC='" + DNI_TC + "'"+", " + "DNI_TE='" + DNI_TE + "'"+ " WHERE DNI_ALUM='" + DNI_ALUM + "'");
		return num;
	}
	
	public static int BorrarAlumno(String DNI_ALUM ) throws SQLException{
		
		System.out.println("Voy a borrar un elemento en la tabla Alumnos");
		
		Statement stmt = conexion.createStatement();
		
		System.out.println("DELETE FROM " + esquema + ".Alumnos WHERE DNI_ALUM ='" + DNI_ALUM + "'");
		int num = stmt.executeUpdate("DELETE FROM " + esquema + ".Alumnos WHERE DNI_ALUM ='" + DNI_ALUM + "'");
		return num;
	}
	
	/**
	 * CURSAN
	 */
	
	public static int InsertCursan(String Clave_Ciclo, String DNI_ALUM , String Curso) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Tutor Centro");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("INSERT INTO " + esquema + ".Cursan VALUES (" +"'" + Clave_Ciclo + "'"+  "," +"'"+DNI_ALUM+ "'" + "," +"'"+Curso+ "'" + ")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".Cursan VALUES (" +"'" + Clave_Ciclo + "'"+  "," +"'"+DNI_ALUM+ "'" + "," +"'"+Curso+ "'" + ")");
		return num;
	}
	
	public static int ModificarCursan(String Clave_Ciclo, String DNI_ALUM , String Curso) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Tutor Centro modificando sus datos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("UPDATE " + esquema + ".Cursan SET " +"Clave_Ciclo='" + Clave_Ciclo + "'"+  ", " +"DNI_ALUM='"+DNI_ALUM+ "'" + ", " +"Curso='"+Curso+ "'" + " WHERE DNI_ALUM='" + DNI_ALUM + "'" + " AND " + "Clave_Ciclo='" + Clave_Ciclo + "'");
		int num = stmt.executeUpdate("UPDATE " + esquema + ".Cursan SET " +"Clave_Ciclo='" + Clave_Ciclo + "'"+  ", " +"DNI_ALUM='"+DNI_ALUM+ "'" + ", " +"Curso='"+Curso+ "'" + " WHERE DNI_ALUM='" + DNI_ALUM + "'" + " AND " + "Clave_Ciclo='" + Clave_Ciclo + "'");
		return num;
	}
	
	
	public ObservableList<Practicas> ConsultaPracticas() {
		
		ObservableList<Practicas> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM " +esquema +".Asignan" );
			while(rset.next()) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				
				String Num_Convenio = rset.getString(1);
				String DNI_ALUM = rset.getString(2);
				String Fecha_Inicio = sdf.format(rset.getDate(3));
				String Fecha_Terminacion  = sdf.format(rset.getDate(4));
				String Fecha_Final = sdf.format(rset.getDate(5));
				String Dias_Semana = rset.getString(6);
				String Tipo_Horario = rset.getString(7);
				String Horas_al_dia = rset.getString(8);
				String Total_horas = rset.getString(9);
				String Hora_Inicio = rset.getString(10);
				String Hora_terminacion = rset.getString(11);
				
				
				System.out.println(Num_Convenio + ", " + DNI_ALUM  + ", " +Fecha_Inicio  + ", " +Fecha_Terminacion  + ", " +Fecha_Final   + ", " + Dias_Semana   + ", " + Tipo_Horario   + ", " + Horas_al_dia   + ", " + Total_horas   + ", " + Hora_Inicio + ", "+ Hora_terminacion);
				Practicas auxPracticas = new Practicas(Num_Convenio, DNI_ALUM , Fecha_Inicio , Fecha_Terminacion , Fecha_Final , Dias_Semana , Tipo_Horario , Horas_al_dia , Total_horas , Hora_Inicio, Hora_terminacion  );
				aux.add(auxPracticas);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}
	
	public static int InsertPracticas(String Num_Convenio, String DNI_ALUM, String Fecha_Inicio, String Fecha_Terminacion, String Fecha_Final, String Dias_Semana, String Tipo_Horario, String Horas_al_dia, String Total_horas, String Hora_Inicio, String Hora_terminacion) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Ciclos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("INSERT INTO " + esquema + ".Asignan VALUES (" +"'" + Num_Convenio + "'"+  "," +"'"+DNI_ALUM+ "'" + "," +"'"+ Fecha_Inicio+ "'" + "," +Fecha_Terminacion + "'" + "," + "'" + Fecha_Final + "'"+  "," +"'"+Dias_Semana+"'" + "," +"'"+Tipo_Horario+"'" + "," +"'"+Horas_al_dia+"'" + "," + "'" + Total_horas+ "'" + ", " + Hora_Inicio + "'" + ", " + "'" + Hora_terminacion+"'"+")");
		int num = stmt.executeUpdate("INSERT INTO " + esquema + ".Asignan VALUES (" +"'" + Num_Convenio + "'"+  "," +"'"+DNI_ALUM+ "'" + "," +"'"+ Fecha_Inicio+ "'" + "," +Fecha_Terminacion + "," + "'" + Fecha_Final + "'"+  "," +"'"+Dias_Semana+"'" + "," +"'"+Tipo_Horario+"'" + "," +"'"+Horas_al_dia+"'" + "," + "'" + Total_horas+ "'" + ", " + Hora_Inicio + "'" + ", " + "'" + Hora_terminacion+"'"+")");
		return num;
	}
	
	public static int ModificarPracticas(String Num_Convenio, String DNI_ALUM, String Fecha_Inicio, String Fecha_Terminacion, String Fecha_Final, String Dias_Semana, String Tipo_Horario, String Horas_al_dia, String Total_horas, String Hora_Inicio, String Hora_terminacion) throws SQLException{
		
		System.out.println("Voy a hacer un insert en la tabla Ciclos modificando sus datos");
		
		Statement stmt = conexion.createStatement();
		
		
		System.out.println("UPDATE " + esquema + ".Asignan SET " +"Num_Convenio='" + Num_Convenio + "'"+  ", " +"DNI_ALUM='"+DNI_ALUM+ "'" + ", " +"Fecha_Inicio='"+Fecha_Inicio+ "'" + ", " +"Fecha_Terminacion='"+Fecha_Terminacion + "'" + ", " + "Fecha_Final='" + Fecha_Final + "'"+  ", " +"Dias_Semana='"+Dias_Semana+"'" + ", " +"Tipo_Horario='"+Tipo_Horario+"'" + ", " +"Horas_al_dia="+Horas_al_dia + ", " + "Total_horas=" + Total_horas+ ", " + "Hora_Inicio='"+ Hora_Inicio + "'" + ", " + "Hora_terminacion='"+ Hora_terminacion+ "'" +" WHERE Num_Convenio='" + Num_Convenio + "'");
		int num = stmt.executeUpdate("UPDATE " + esquema + ".Asignan SET " +"Num_Convenio='" + Num_Convenio + "'"+  ", " +"DNI_ALUM='"+DNI_ALUM+ "'" + ", " +"Fecha_Inicio='"+Fecha_Inicio+ "'" + ", " +"Fecha_Terminacion='"+Fecha_Terminacion + "'" + ", " + "Fecha_Final='" + Fecha_Final + "'"+  ", " +"Dias_Semana='"+Dias_Semana+"'" + ", " +"Tipo_Horario='"+Tipo_Horario+"'" + ", " +"Horas_al_dia="+Horas_al_dia + ", " + "Total_horas=" + Total_horas+ ", " + "Hora_Inicio='"+ Hora_Inicio + "'" + ", " + "Hora_terminacion='"+ Hora_terminacion+ "'" +" WHERE Num_Convenio='" + Num_Convenio + "'");
		return num;
		
		
	}
	
	public static int BorrarPractica(String DNI_ALUM, String Num_Convenio) throws SQLException{
		
		System.out.println("Voy a borrar un elemento en la tabla Asignan");
		
		Statement stmt = conexion.createStatement();
		
		System.out.println("DELETE FROM " + esquema + ".Asignan WHERE DNI_ALUM ='" + DNI_ALUM + "'" + "Num_Convenio ='" + Num_Convenio + "'");
		int num = stmt.executeUpdate("DELETE FROM " + esquema + ".Asignan WHERE DNI_ALUM ='" + DNI_ALUM + "'" + "Num_Convenio ='" + Num_Convenio + "'");
		return num;
	}

	


	

}