package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.dto.Esito;
import it.exolab.model.Dipendente;

@Remote
public interface DipendenteEJBRemote {
	
	Esito add(Dipendente dipendente);
	Esito findAll();
	Esito tuttoDelDipendente(String id_dipendente);
	Esito findByEmailAndPassword(Dipendente dipendente);
	Esito dipendenteConContrattoAttuale(String id_dipendente);

}
