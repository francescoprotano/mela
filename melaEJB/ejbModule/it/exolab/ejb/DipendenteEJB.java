package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.DipendenteDAO;
import it.exolab.model.Dipendente;

/**
 * Session Bean implementation class DipendenteEJB
 */
@Stateless
@LocalBean
public class DipendenteEJB implements DipendenteEJBRemote {

  
    public DipendenteEJB() {
    }

	@Override
	public void add(Dipendente dipendente) {
		DipendenteDAO.add(dipendente);
		
	}

	@Override
	public List<Dipendente> findAll() {
		return DipendenteDAO.findAll();
	}

}
