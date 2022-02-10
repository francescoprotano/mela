package it.exolab.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.PresenzaDAO;
import it.exolab.dto.Esito;
import it.exolab.model.Presenza;

/**
 * Session Bean implementation class PresenzaEJB
 */
@Stateless
@LocalBean
public class PresenzaEJB implements PresenzaEJBRemote {
	Esito esito;

    /**
     * Default constructor. 
     */
    public PresenzaEJB() {
    }
    
    
    public Esito add(Presenza presenza) {
    	esito = new Esito();
    	try {
    		PresenzaDAO.add(presenza);
    		esito.setData(presenza);
        	esito.setSuccess(true);
    	}catch(Exception e) {
    		e.printStackTrace();
    		esito.setError("Errore nell'add presenza");
    		return esito;
    	}
    	return esito;
    }

}
