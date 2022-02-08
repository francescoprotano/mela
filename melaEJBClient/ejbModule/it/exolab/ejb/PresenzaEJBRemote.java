package it.exolab.ejb;

import javax.ejb.Remote;

import it.exolab.dto.Esito;
import it.exolab.model.Presenza;

@Remote
public interface PresenzaEJBRemote {
	
	Esito add(Presenza presenza);

}
