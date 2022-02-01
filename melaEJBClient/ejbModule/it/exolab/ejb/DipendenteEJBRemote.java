package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.model.Dipendente;

@Remote
public interface DipendenteEJBRemote {
	
	void add(Dipendente dipendente);
	List<Dipendente> findAll();

}
