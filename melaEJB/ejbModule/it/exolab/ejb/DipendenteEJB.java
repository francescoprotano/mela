package it.exolab.ejb;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.DipendenteDAO;
import it.exolab.dto.Esito;
import it.exolab.exception.EmptyTextException;
import it.exolab.exception.NotFoundException;
import it.exolab.model.Dipendente;
import it.exolab.validation.Validation;

/**
 * Session Bean implementation class DipendenteEJB
 */
@Stateless
@LocalBean
public class DipendenteEJB implements DipendenteEJBRemote {
	Esito esito;
	Validation validation = new Validation();

	public DipendenteEJB() {
	}

	@Override
	public Esito add(Dipendente dipendente) {
		esito = new Esito();
		if (!validation.checkNominativo(dipendente.getNome(), dipendente.getCognome())) {
			esito.setError("Nome o cognome in un formato non valido"); 
			// eventualmente aggiungere una exception nominativo nn valido
			return esito;
		} else if (validation.checkEmailAndPassword(dipendente.getEmail(), dipendente.getPassword())) {
			esito.setError("Email o password non validi. La password deve essere di almeno sei caratteri."); 
			// eventualmente aggiungere una exception emailpassword non validi
			return esito;
		}
		try {
			DipendenteDAO.add(dipendente);
		} catch (EmptyTextException ete) {
			ete.printStackTrace();
			esito.setError(ete.getMessage());
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			esito.setError("Hai compilato i campi?");
			return esito;
		} catch (Exception e) {
			e.printStackTrace();
			esito.setError("Errore nell'insert del dipendente");
			return esito;
		}
		esito.setSuccess(true);
		esito.setData(dipendente);
		return esito;
	}

	@Override
	public Esito findAll() {
		esito = new Esito();
		try {
			esito.setData(DipendenteDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			esito.setError("Errore nel findAll dei dipendenti");
			return esito;
		}
		esito.setSuccess(true);
		return esito;
	}

	@Override
	public Esito tuttoDelDipendente(String id_dipendente) {
		esito = new Esito();
		try {
			esito.setData(DipendenteDAO.tuttoDelDipendente(id_dipendente));
		} catch (NotFoundException nfe) {
			nfe.printStackTrace();
			esito.setError(nfe.getMessage());
			return esito;
		} catch (Exception e) {
			e.printStackTrace();
			esito.setError("Errore nel tuttoDelDipendente");
			return esito;
		}

		esito.setSuccess(true);
		return esito;
	}

	@Override
	public Esito findByEmailAndPassword(Dipendente dipendente) {
		esito = new Esito();
		try {
			esito.setData(DipendenteDAO.findByEmailAndPassword(dipendente));
		} catch (NotFoundException nfe) {
			nfe.printStackTrace();
			esito.setError("Dipendente non ancora registrato.  " + nfe.getMessage());
			return esito;
		} catch (Exception e) {
			e.printStackTrace();
			esito.setError("Errore nel findDipendente");
			return esito;
		}
		esito.setSuccess(true);
		return esito;
	}

	@Override
	public Esito dipendenteConContrattoAttuale(String id_dipendente) {
		esito = new Esito();
		try {
			esito.setData(DipendenteDAO.dipendenteConContrattoAttuale(id_dipendente));
		} catch (NotFoundException nfe) {
			nfe.printStackTrace();
			esito.setError(nfe.getMessage());
			return esito;
		} catch (Exception e) {
			e.printStackTrace();
			esito.setError("Errore nel dipendenteConContrattoAttuale");
			return esito;
		}
		esito.setSuccess(true);
		return esito;
	}

	@Override
	public Esito findById(String id_dipendente) {
		esito = new Esito();
		Dipendente dip = null;
		Date date = new Date();

		try {
			 esito.setData(DipendenteDAO.findById(id_dipendente));
			 dip = DipendenteDAO.dipendenteConContrattoAttualeSenzaException(id_dipendente);

			 if(dip.getContratto().getData_scadenza().after(date)) {
				esito.setError("Il dipendente ha già un contratto");
				esito.setErrCode("27");
				return esito;
			}
			 //se l'id_dipendente esiste e ha un contratto non scaduto, torna errCode 27.
			 //se l'id_dipendente non esiste, notFoundException
			 //se l'id_dipendente esiste, ma non ha un contratto, il getContratto farà scattare una nullPointerException benvoluta
			 //il frontend dunque gestisce
		} catch(NullPointerException npe){ 
			esito.setSuccess(true);
			return esito;
		} catch (NotFoundException nfe) {
			nfe.printStackTrace();
			esito.setError(nfe.getMessage());
			return esito;
		} catch (Exception e) {
			e.printStackTrace();
			esito.setError("Errore nel findById del dipendente");
			return esito;
		}
		return esito;

	}

}
