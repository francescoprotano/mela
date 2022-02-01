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
	private Date ora_entrata;
	private Date ora_uscita;
	private String motivazione_assenza;

	public int getId_presenza() {
		return id_presenza;
	}
	public void setId_presenza(int id_presenza) {
		this.id_presenza = id_presenza;
	}
	public Date getOra_entrata() {
		return ora_entrata;
	}
	public void setOra_entrata(Date ora_entrata) {
		this.ora_entrata = ora_entrata;
	}
	public Date getOra_uscita() {
		return ora_uscita;
	}
	public void setOra_uscita(Date ora_uscita) {
		this.ora_uscita = ora_uscita;
	}
	public String getMotivazione_assenza() {
		return motivazione_assenza;
	}
	public void setMotivazione_assenza(String motivazione_assenza) {
		this.motivazione_assenza = motivazione_assenza;
	}
	
	
	@Override
	public String toString() {
		return "Presenza [id_presenza=" + id_presenza + ", ora_entrata=" + ora_entrata + ", ora_uscita=" + ora_uscita
				+ ", motivazione_assenza=" + motivazione_assenza + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_presenza;
		result = prime * result + ((motivazione_assenza == null) ? 0 : motivazione_assenza.hashCode());
		result = prime * result + ((ora_entrata == null) ? 0 : ora_entrata.hashCode());
		result = prime * result + ((ora_uscita == null) ? 0 : ora_uscita.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Presenza other = (Presenza) obj;
		if (id_presenza != other.id_presenza)
			return false;
		if (motivazione_assenza == null) {
			if (other.motivazione_assenza != null)
				return false;
		} else if (!motivazione_assenza.equals(other.motivazione_assenza))
			return false;
		if (ora_entrata == null) {
			if (other.ora_entrata != null)
				return false;
		} else if (!ora_entrata.equals(other.ora_entrata))
			return false;
		if (ora_uscita == null) {
			if (other.ora_uscita != null)
				return false;
		} else if (!ora_uscita.equals(other.ora_uscita))
			return false;
		return true;
	}
	
	
	

}
