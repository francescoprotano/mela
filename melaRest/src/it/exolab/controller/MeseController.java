package it.exolab.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.dto.Esito;
import it.exolab.ejb.MeseEJBRemote;
import it.exolab.model.Mese;
import it.exolab.richiamaejb.RichiamaEJBMese;

@Path("mesi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MeseController {
	
	private RichiamaEJBMese richiama = new RichiamaEJBMese();
	MeseEJBRemote EJBMese;
	Esito esito;
	
	
	@GET
	@Path("/findall")
	public Esito findAll() {
		EJBMese = richiama.lookupOnRemote();
		System.out.println("Dentro findAll mesi");
		esito = new Esito();
		esito = EJBMese.findAll();
		
		return esito;
	}
	
	@POST
	@Path("updatechiuso")
	public Esito updateChiuso(Mese mese) {
		EJBMese = richiama.lookupOnRemote();
		System.out.println("Dentro updateChiuso mese");
		esito = new Esito();
		esito = EJBMese.updateChiuso(mese);
		
		return esito;
	}

}
