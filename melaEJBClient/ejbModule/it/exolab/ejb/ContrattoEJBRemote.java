package it.exolab.ejb;

import javax.ejb.Remote;

import it.exolab.dto.Esito;

@Remote
public interface ContrattoEJBRemote {
	
	Esito findAll();

}
