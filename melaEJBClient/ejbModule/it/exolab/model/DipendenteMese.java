package it.exolab.model;

public class DipendenteMese {
	
	private int id_dipendente_fk;
	private int id_mese_fk;
	private int stato;
	//0-> COMPILABILE dal dipendente
	//1-> INVIATO dal dipendente
	//2-> CONTROLLATO dal responsabile
	
	
	public int getId_dipendente_fk() {
		return id_dipendente_fk;
	}
	public void setId_dipendente_fk(int id_dipendente_fk) {
		this.id_dipendente_fk = id_dipendente_fk;
	}
	public int getId_mese_fk() {
		return id_mese_fk;
	}
	public void setId_mese_fk(int id_mese_fk) {
		this.id_mese_fk = id_mese_fk;
	}
	public int getStato() {
		return stato;
	}
	public void setStato(int stato) {
		this.stato = stato;
	}
	
	

}
