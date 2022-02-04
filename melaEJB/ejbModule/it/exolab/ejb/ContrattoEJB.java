package it.exolab.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.ContrattoDAO;
import it.exolab.dto.Esito;

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
    
    

}
