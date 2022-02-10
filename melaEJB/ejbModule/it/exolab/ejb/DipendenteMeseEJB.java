package it.exolab.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.DipendenteMeseDAO;
import it.exolab.dto.Esito;
import it.exolab.model.DipendenteMese;

/**
 * Session Bean implementation class DipendenteMeseEJB
 */
@Stateless
@LocalBean
public class DipendenteMeseEJB implements DipendenteMeseEJBRemote {
	Esito esito;
    /**
     * Default constructor. 
     */
    public DipendenteMeseEJB() {
    }

	@Override
	public Esito updateStato(DipendenteMese dipendenteMese) {
		esito = new Esito();
		try {
		DipendenteMeseDAO.updateStato(dipendenteMese);
		}catch (Exception e) {
			e.printStackTrace();
			esito.setErrCode("405");
			esito.setError("Errore nell'updateStato DipendenteMese");
		}
		
		return esito;
		
		
	}



}
