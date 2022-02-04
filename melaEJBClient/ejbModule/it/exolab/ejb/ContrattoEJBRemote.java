package it.exolab.ejb;

import javax.ejb.Remote;

import it.exolab.dto.Esito;
import it.exolab.model.Contratto;

@Remote
public interface ContrattoEJBRemote {
	
	Esito findAll();
	Esito add(Contratto contratto);

}
