package it.exolab.ejb;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.DipendenteMeseDAO;
import it.exolab.dao.MeseDAO;
import it.exolab.dao.PresenzaDAO;
import it.exolab.dto.Esito;
import it.exolab.exception.FailedInsertException;
import it.exolab.exception.NotFoundException;
import it.exolab.model.DipendenteMese;
import it.exolab.model.Mese;
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
    		
    		// assegna la data della presenza all'oggetto mese
    		Mese m = new Mese();  
    		m.setMese(presenza.getData());
    		m = MeseDAO.find(m);
    		System.out.println("ID del mese trovato con MeseDAO.find(m) = " + m.getId_mese());
    		
    		//qui assegno il mese che corrisponde alla data della presenza
    		//al mese_fk della presenza
    		presenza.setMese_fk(m);
    		
    		//Ora posso effettuare l'insert della presenza
    		//con anche l'id del mese, cioe' mese_fk
    		PresenzaDAO.add(presenza);
    		
    		//inserisco anche il mese relativo al dipendente
    		//nella tabella dipendente_mesi, solo se 
    		//non è già stato aggiunto
    		DipendenteMese dipendenteMese = new DipendenteMese();
    		dipendenteMese.setId_dipendente_fk(presenza.getId_dipendente_fk().getId_dipendente());
    		dipendenteMese.setId_mese_fk(presenza.getMese_fk().getId_mese());
    		
    		DipendenteMese dipMese = DipendenteMeseDAO.find(dipendenteMese);
    		if(dipMese == null) {
        		DipendenteMeseDAO.add(presenza);
    		}

    		esito.setData(presenza);
        	esito.setSuccess(true);
    	}catch(FailedInsertException fie) {
    		fie.printStackTrace();
			esito.setErrCode("204");
    		esito.setError(fie.getMessage());
    	}catch(NotFoundException nfe) {
    		nfe.printStackTrace();
			esito.setErrCode("204");
    		esito.setError(nfe.getMessage());
    	}catch(Exception e) {
    		e.printStackTrace();
			esito.setErrCode("204");
    		esito.setError("Errore nell'add presenza");
    	}
    	return esito;
    }

}
