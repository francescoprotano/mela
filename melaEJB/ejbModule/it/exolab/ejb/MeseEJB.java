package it.exolab.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;

import it.exolab.dao.MeseDAO;
import it.exolab.dto.Esito;
import it.exolab.model.Mese;

/**
 * Session Bean implementation class MeseEJB
 */
@Stateless
@LocalBean
public class MeseEJB implements MeseEJBRemote {
	
	Esito esito;
    /**
     * Default constructor. 
     */
    public MeseEJB() {
        
    }

	@Override
	public Esito findAll() {
		esito = new Esito();
		try {
		 esito.setData(MeseDAO.findAll());
		 esito.setSuccess(true);
		}catch (NotFoundException nfe) {
			nfe.printStackTrace();
			esito.setErrCode("303");
			esito.setError(nfe.getMessage());
			return esito;
		}catch(Exception e) {
			e.printStackTrace();
			esito.setErrCode("303");
			esito.setError("Errore nel findAll dei mesi");
			return esito;
		}
		return esito;

	}

	@Override
	public Esito updateChiuso(Mese mese) {
		esito = new Esito();
		try {
			MeseDAO.updateChiuso(mese);
			esito.setData(mese);
			esito.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			esito.setErrCode("403");
			esito.setError("Errore nell'update lo stato del mese da aperto a chiuso, o viceversa");
			return esito;
		}
		return esito;
	}
    
    


}
