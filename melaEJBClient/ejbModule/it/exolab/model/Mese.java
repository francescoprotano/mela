package it.exolab.model;

import java.sql.Date;

public class Mese {
	
	private int id_mese;
	private Date mese;
	private boolean chiuso;
	
	
	public int getId_mese() {
		return id_mese;
	}
	public void setId_mese(int id_mese) {
		this.id_mese = id_mese;
	}
	public Date getMese() {
		return mese;
	}
	public void setMese(Date mese) {
		this.mese = mese;
	}
	public boolean isChiuso() {
		return chiuso;
	}
	public void setChiuso(boolean chiuso) {
		this.chiuso = chiuso;
	}
	
	
	

}
