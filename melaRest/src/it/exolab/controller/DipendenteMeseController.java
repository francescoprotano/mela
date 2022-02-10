package it.exolab.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.dto.Esito;
import it.exolab.ejb.DipendenteMeseEJBRemote;
import it.exolab.model.DipendenteMese;
import it.exolab.richiamaejb.RichiamaEJBDipendenteMese;

@Path("/dipendentemesi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DipendenteMeseController {
	Esito esito;
	RichiamaEJBDipendenteMese richiama = new RichiamaEJBDipendenteMese();
	DipendenteMeseEJBRemote EJBDipMese;
	
	
	@POST
	@Path("updatestato")
	public Esito updateStato(DipendenteMese dipendenteMese) {
		System.out.println("Dentro updateStato");
		esito = new Esito();
		EJBDipMese = richiama.lookupOnRemote();
		esito = EJBDipMese.updateStato(dipendenteMese);
		
		return esito;
	}
	
	

}
