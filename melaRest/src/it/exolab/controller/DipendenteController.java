package it.exolab.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.ejb.DipendenteEJBRemote;
import it.exolab.model.Dipendente;
import it.exolab.richiamaejb.RichiamaEJBDipendente;

@Path("/dipendenti")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DipendenteController {
	
	private RichiamaEJBDipendente richiamaEJBDipendente = new RichiamaEJBDipendente();
	DipendenteEJBRemote EJBDipendente;
	
	
	@GET
	@Path("/findall")
	public List<Dipendente> findAll(){
		EJBDipendente = richiamaEJBDipendente.callEJBDipendente();
		System.out.println("dentro find all");
		List<Dipendente> dipendenti = EJBDipendente.findAll();
		System.out.println(dipendenti.toString());
		return dipendenti;
	}
	
	
	// solo prova!!! mockkato! da cambiare in POST quando arriverà la request dal frontend
	@GET
	@Path("/add")
	public void add() {
		EJBDipendente = richiamaEJBDipendente.callEJBDipendente();
		Dipendente dip = new Dipendente();
		dip.setEmail("fff");
		dip.setPassword("eee");
		EJBDipendente.add(dip);
	}

}
