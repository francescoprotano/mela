package it.exolab.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import it.exolab.dao.ContrattoDAO;
import it.exolab.dto.Esito;
import it.exolab.model.Contratto;

// Session Bean implementation class ContrattoEJB
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
    		esito.setErrCode("302");
    		esito.setError("Errore nel findAll dei contratti");
    	}
    	esito.setSuccess(true);
    	return esito;
    }
    
    public Esito add(Contratto contratto) {
    	esito = new Esito();
    	if(contratto.getData_assunzione()==null) {
    		esito.setError("Devi inserire una data di assunzione");
    		return esito;
    	}
    	try {
    		ContrattoDAO.add(contratto);
    		System.out.println(contratto.getDipendente().toString());
    		ContrattoDAO.update(contratto); // update contratto_corrente_fk sul dipendente		
    		esito.setData(contratto);
    	}catch(Exception e) {
    		e.printStackTrace();
    		esito.setErrCode("202");
    		esito.setError("Errore nell'add contratto");
    		return esito;
    	}
    	esito.setSuccess(true);
    	return esito;
    }
    
    

}
