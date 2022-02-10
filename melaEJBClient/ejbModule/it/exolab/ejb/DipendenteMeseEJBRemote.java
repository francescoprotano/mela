package it.exolab.ejb;

import javax.ejb.Remote;

import it.exolab.dto.Esito;
import it.exolab.model.DipendenteMese;

@Remote
public interface DipendenteMeseEJBRemote {
	
	Esito updateStato(DipendenteMese dipendenteMese);

}
