package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;

public class Presenza implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3949315710409440297L;
	
	public Presenza() {
	}
	
	private int id_presenza;
	private Date data;
	private String motivazione_assenza_fk;
	private Dipendente dipendente;
	private Mese mese_fk;
	private int ore_lavorate;
	private int ore_assenza;
	
	

	public Dipendente getDipendente() {
		return dipendente;
	}
	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
	public int getId_presenza() {
		return id_presenza;
	}
	public void setId_presenza(int id_presenza) {
		this.id_presenza = id_presenza;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getMotivazione_assenza_fk() {
		return motivazione_assenza_fk;
	}
	public void setMotivazione_assenza_fk(String motivazione_assenza_fk) {
		this.motivazione_assenza_fk = motivazione_assenza_fk;
	}
	public Mese getMese_fk() {
		return mese_fk;
	}
	public void setMese_fk(Mese mese_fk) {
		this.mese_fk = mese_fk;
	}
	public int getOre_lavorate() {
		return ore_lavorate;
	}
	public void setOre_lavorate(int ore_lavorate) {
		this.ore_lavorate = ore_lavorate;
	}
	public int getOre_assenza() {
		return ore_assenza;
	}
	public void setOre_assenza(int ore_assenza) {
		this.ore_assenza = ore_assenza;
	}
	
	

	
	
	
	

}
