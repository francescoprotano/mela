package it.exolab.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.ContrattoDAO;
import it.exolab.dto.Esito;
import it.exolab.model.Contratto;

/**
 * Session Bean implementation class ContrattoEJB
 */
@Stateless
@LocalBean
public class ContrattoEJB implements ContrattoEJBRemote {
	Esito esito;
    
    public ContrattoEJB() {
    }
    
    
    public Esito findAll() {
    	esito = new Esito();
    	try {
    		esito.setData(ContrattoDAO.findAll());
    	}catch(Exception e) {
    		e.printStackTrace();
    		esito.setSuccess(false);
    		esito.setError("Errore nel findAll dei contratti");
    	}
    	esito.setSuccess(true);
    	return esito;
    }
    
    public Esito add(Contratto contratto) {
    	esito = new Esito();
    	try {
    		ContrattoDAO.add(contratto);
    		esito.setData(contratto);
    	}catch(Exception e) {
    		e.printStackTrace();
    		esito.setError("Errore nell'add contratto");
    	}
    	esito.setSuccess(true);
    	return esito;
    }
    
    

}
