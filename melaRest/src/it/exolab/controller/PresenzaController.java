package it.exolab.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.dto.Esito;
import it.exolab.ejb.DipendenteEJBRemote;
import it.exolab.ejb.PresenzaEJBRemote;
import it.exolab.model.Presenza;
import it.exolab.richiamaejb.RichiamaEJBDipendente;
import it.exolab.richiamaejb.RichiamaEJBPresenza;

@Path("/presenze")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PresenzaController {
	RichiamaEJBPresenza richiama = new RichiamaEJBPresenza();
	PresenzaEJBRemote presenzaEJB;
	RichiamaEJBDipendente richiamaDip = new RichiamaEJBDipendente();
	DipendenteEJBRemote dipendenteEJB;
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
	
	@GET
	@Path("presenzedelmesedeldipendente/{id_dipendente}")
	public Esito findPresenzeRelativeAlDipendenteConStatoMeseAperto(@PathParam("id_dipendente") int id_dipendente) {
		System.out.println("Dentro findPresenzeRelativeAlDipendenteConStatoMeseAperto");
		dipendenteEJB = richiamaDip.callEJBDipendente();
		esito = new Esito();
		esito = dipendenteEJB.findPresenzeRelativeAlDipendenteConStatoMeseAperto(id_dipendente);
		
		return esito;
	}
	

}
