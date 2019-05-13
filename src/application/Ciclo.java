package application;

import javafx.collections.ObservableList;

public class Ciclo {
	
	private ObservableList<Ciclo> ciclo;
	
	String clave_ciclo;
	String nom_ciclo;
	String familia_prof;
	String num_cursos;
	String period_pract;
	String capac_term;
	String act_form;
	String criterios_eva;
	String programa_formativo;
	String cod_centro;
	
	
	public Ciclo(String clave_ciclo, String nom_ciclo, String familia_prof, String num_cursos, String period_pract,
			String capac_term, String act_form, String criterios_eva, String programa_formativo, String cod_centro) {
		super();
		this.clave_ciclo = clave_ciclo;
		this.nom_ciclo = nom_ciclo;
		this.familia_prof = familia_prof;
		this.num_cursos = num_cursos;
		this.period_pract = period_pract;
		this.capac_term = capac_term;
		this.act_form = act_form;
		this.criterios_eva = criterios_eva;
		this.programa_formativo = programa_formativo;
		this.cod_centro = cod_centro;
	}


	public String getClave_ciclo() {
		return clave_ciclo;
	}


	public void setClave_ciclo(String clave_ciclo) {
		this.clave_ciclo = clave_ciclo;
	}


	public String getNom_ciclo() {
		return nom_ciclo;
	}


	public void setNom_ciclo(String nom_ciclo) {
		this.nom_ciclo = nom_ciclo;
	}


	public String getFamilia_prof() {
		return familia_prof;
	}


	public void setFamilia_prof(String familia_prof) {
		this.familia_prof = familia_prof;
	}


	public String getNum_cursos() {
		return num_cursos;
	}


	public void setNum_cursos(String num_cursos) {
		this.num_cursos = num_cursos;
	}


	public String getPeriod_pract() {
		return period_pract;
	}


	public void setPeriod_pract(String period_pract) {
		this.period_pract = period_pract;
	}


	public String getCapac_term() {
		return capac_term;
	}


	public void setCapac_term(String capac_term) {
		this.capac_term = capac_term;
	}


	public String getAct_form() {
		return act_form;
	}


	public void setAct_form(String act_form) {
		this.act_form = act_form;
	}


	public String getCriterios_eva() {
		return criterios_eva;
	}


	public void setCriterios_eva(String criterios_eva) {
		this.criterios_eva = criterios_eva;
	}


	public String getPrograma_formativo() {
		return programa_formativo;
	}


	public void setPrograma_formativo(String programa_formativo) {
		this.programa_formativo = programa_formativo;
	}


	public String getCod_centro() {
		return cod_centro;
	}


	public void setCod_centro(String cod_centro) {
		this.cod_centro = cod_centro;
	}
	
	public void addCiclo(Ciclo ciclo){
    	this.ciclo.add(ciclo);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
