package it.exolab.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.dto.Esito;
import it.exolab.ejb.ContrattoEJBRemote;
import it.exolab.model.Contratto;
import it.exolab.richiamaejb.RichiamaEJBContratto;

@Path("/contratti")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContrattoController {
	
	private RichiamaEJBContratto richiamaEJBContratto = new RichiamaEJBContratto();
	ContrattoEJBRemote EJBContratto;
	Esito esito;
	
	@GET
	@Path("/findall")
	public Esito findAll(){
		EJBContratto = richiamaEJBContratto.callEJBContratto();
		System.out.println("dentro findall dei contratti");
		esito = new Esito();
		esito = EJBContratto.findAll();
		System.out.println(esito.getData().toString());
		return esito;
	}
	
	@POST
	@Path("add")
	public Esito add(Contratto contratto) {		
		EJBContratto = richiamaEJBContratto.callEJBContratto();
		System.out.println("Dentro add contratto");
		esito = new Esito();
		esito = EJBContratto.add(contratto);
		
		return esito;
	}

}
