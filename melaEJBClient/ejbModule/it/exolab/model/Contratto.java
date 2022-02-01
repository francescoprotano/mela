package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;

public class Contratto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6722824349753760030L;
	
	
	public Contratto() {
	}
	
	private int id_contratto;
	private Date data_assunzione;
	private Date data_scadenza;
	private String tipologia;


	public int getId_contratto() {
		return id_contratto;
	}
	public void setId_contratto(int id_contratto) {
		this.id_contratto = id_contratto;
	}
	public Date getData_assunzione() {
		return data_assunzione;
	}
	public void setData_assunzione(Date data_assunzione) {
		this.data_assunzione = data_assunzione;
	}
	public Date getData_scadenza() {
		return data_scadenza;
	}
	public void setData_scadenza(Date data_scadenza) {
		this.data_scadenza = data_scadenza;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	
	@Override
	public String toString() {
		return "Contratto [id_contratto=" + id_contratto + ", data_assunzione=" + data_assunzione + ", data_scadenza="
				+ data_scadenza + ", tipologia=" + tipologia + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_assunzione == null) ? 0 : data_assunzione.hashCode());
		result = prime * result + ((data_scadenza == null) ? 0 : data_scadenza.hashCode());
		result = prime * result + id_contratto;
		result = prime * result + ((tipologia == null) ? 0 : tipologia.hashCode());
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
		Contratto other = (Contratto) obj;
		if (data_assunzione == null) {
			if (other.data_assunzione != null)
				return false;
		} else if (!data_assunzione.equals(other.data_assunzione))
			return false;
		if (data_scadenza == null) {
			if (other.data_scadenza != null)
				return false;
		} else if (!data_scadenza.equals(other.data_scadenza))
			return false;
		if (id_contratto != other.id_contratto)
			return false;
		if (tipologia == null) {
			if (other.tipologia != null)
				return false;
		} else if (!tipologia.equals(other.tipologia))
			return false;
		return true;
	}
	
	
	
	
	

}
