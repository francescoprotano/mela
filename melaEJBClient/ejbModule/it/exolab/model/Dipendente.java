package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Dipendente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5826930391396833232L;

	public Dipendente() {
	}

	private int id_dipendente;
	private String nome;
	private String cognome;
	private Date data_nascita;
	private String email;
	private String password;
	private String ruolo_fk;
	private List<Contratto> contratti = new ArrayList<>();
	private List<Presenza> presenze = new ArrayList<>();
	private Contratto contratto = new Contratto();


	public int getId_dipendente() {
		return id_dipendente;
	}

	public void setId_dipendente(int id_dipendente) {
		this.id_dipendente = id_dipendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Contratto> getContratti() {
		return contratti;
	}

	public void setContratti(List<Contratto> contratti) {
		this.contratti = contratti;
	}

	public List<Presenza> getPresenze() {
		return presenze;
	}

	public void setPresenze(List<Presenza> presenze) {
		this.presenze = presenze;
	}


	public String getRuolo_fk() {
		return ruolo_fk;
	}

	public void setRuolo_fk(String ruolo_fk) {
		this.ruolo_fk = ruolo_fk;
	}	

	public Contratto getContratto() {
		return contratto;
	}

	public void setContratto(Contratto contratto) {
		this.contratto = contratto;
	}

	

	@Override
	public String toString() {
		return "Dipendente [id_dipendente=" + id_dipendente + ", nome=" + nome + ", cognome=" + cognome
				+ ", data_nascita=" + data_nascita + ", email=" + email + ", password=" + password + ", ruolo_fk="
				+ ruolo_fk + ", contratti=" + contratti + ", presenze=" + presenze + ", contratto=" + contratto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((contratti == null) ? 0 : contratti.hashCode());
		result = prime * result + ((data_nascita == null) ? 0 : data_nascita.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id_dipendente;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((presenze == null) ? 0 : presenze.hashCode());
		result = prime * result + ((ruolo_fk == null) ? 0 : ruolo_fk.hashCode());
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
		Dipendente other = (Dipendente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (contratti == null) {
			if (other.contratti != null)
				return false;
		} else if (!contratti.equals(other.contratti))
			return false;
		if (data_nascita == null) {
			if (other.data_nascita != null)
				return false;
		} else if (!data_nascita.equals(other.data_nascita))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_dipendente != other.id_dipendente)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (presenze == null) {
			if (other.presenze != null)
				return false;
		} else if (!presenze.equals(other.presenze))
			return false;
		if (ruolo_fk == null) {
			if (other.ruolo_fk != null)
				return false;
		} else if (!ruolo_fk.equals(other.ruolo_fk))
			return false;
		return true;
	}

	
	
	
	
	

	
}
