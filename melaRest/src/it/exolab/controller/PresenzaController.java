package it.exolab.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.dto.Esito;
import it.exolab.ejb.PresenzaEJBRemote;
import it.exolab.model.Presenza;
import it.exolab.richiamaejb.RichiamaEJBPresenza;

@Path("/presenze")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PresenzaController {
	RichiamaEJBPresenza richiama = new RichiamaEJBPresenza();
	PresenzaEJBRemote presenzaEJB;
	Esito esito;
	
	@POST
	@Path("/add")
	public Esito add(Presenza presenza) {
		System.out.println("Dentro add presenza");
		esito = new Esito();
		presenzaEJB = richiama.doLookupOnEJBRemoteInterface();
		esito = presenzaEJB.add(presenza);
		
		return esito;
	}
	
	

}
