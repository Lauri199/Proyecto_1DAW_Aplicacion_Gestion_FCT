package application;

public class Ciclo {
	
	String Clave_Ciclo;
	String Nom_Ciclo;
	String Familia_prof;
	int Num_cursos;
	String Period_Pract;
	String Capac_term;
	String Act_Form;
	String Criterios_eva;
	int Cod_Centro;
	
	
	public Ciclo(String clave_Ciclo, String nom_Ciclo, String familia_prof, int num_cursos, String period_Pract,
			String capac_term, String act_Form, String criterios_eva, int cod_Centro) {
		super();
		Clave_Ciclo = clave_Ciclo;
		Nom_Ciclo = nom_Ciclo;
		Familia_prof = familia_prof;
		Num_cursos = num_cursos;
		Period_Pract = period_Pract;
		Capac_term = capac_term;
		Act_Form = act_Form;
		Criterios_eva = criterios_eva;
		Cod_Centro = cod_Centro;
	}
	
	
	public String getClave_Ciclo() {
		return Clave_Ciclo;
	}
	public void setClave_Ciclo(String clave_Ciclo) {
		Clave_Ciclo = clave_Ciclo;
	}
	public String getNom_Ciclo() {
		return Nom_Ciclo;
	}
	public void setNom_Ciclo(String nom_Ciclo) {
		Nom_Ciclo = nom_Ciclo;
	}
	public String getFamilia_prof() {
		return Familia_prof;
	}
	public void setFamilia_prof(String familia_prof) {
		Familia_prof = familia_prof;
	}
	public int getNum_cursos() {
		return Num_cursos;
	}
	public void setNum_cursos(int num_cursos) {
		Num_cursos = num_cursos;
	}
	public String getPeriod_Pract() {
		return Period_Pract;
	}
	public void setPeriod_Pract(String period_Pract) {
		Period_Pract = period_Pract;
	}
	public String getCapac_term() {
		return Capac_term;
	}
	public void setCapac_term(String capac_term) {
		Capac_term = capac_term;
	}
	public String getAct_Form() {
		return Act_Form;
	}
	public void setAct_Form(String act_Form) {
		Act_Form = act_Form;
	}
	public String getCriterios_eva() {
		return Criterios_eva;
	}
	public void setCriterios_eva(String criterios_eva) {
		Criterios_eva = criterios_eva;
	}
	public int getCod_Centro() {
		return Cod_Centro;
	}
	public void setCod_Centro(int cod_Centro) {
		Cod_Centro = cod_Centro;
	}
	
	

}
