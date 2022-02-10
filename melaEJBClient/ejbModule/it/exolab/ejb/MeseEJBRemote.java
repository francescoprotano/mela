package it.exolab.ejb;

import javax.ejb.Remote;

import it.exolab.dto.Esito;
import it.exolab.model.Mese;

@Remote
public interface MeseEJBRemote {
	
	
	Esito findAll();
	Esito updateChiuso(Mese mese);

}
