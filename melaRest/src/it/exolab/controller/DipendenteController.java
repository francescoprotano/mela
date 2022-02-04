package it.exolab.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.dto.Esito;
import it.exolab.ejb.DipendenteEJBRemote;
import it.exolab.model.Dipendente;
import it.exolab.richiamaejb.RichiamaEJBDipendente;

@Path("/dipendenti")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DipendenteController {
	
	private RichiamaEJBDipendente richiamaEJBDipendente = new RichiamaEJBDipendente();
	DipendenteEJBRemote EJBDipendente;
	Esito esito;
	//eventualmente aggiungere il ritorno per il frontend Esito<T>
	
	@GET
	@Path("/findall")
	public Esito findAll(){
		EJBDipendente = richiamaEJBDipendente.callEJBDipendente();
		System.out.println("dentro find all");
		esito = new Esito();
		esito = EJBDipendente.findAll();
		System.out.println(esito.getData().toString());
		
		return esito;
	}
	
	
	@POST
	@Path("/add")
	public Esito add(Dipendente dipendente) {
		System.out.println("Dentro add");
		EJBDipendente = richiamaEJBDipendente.callEJBDipendente();
		esito = new Esito();
		esito = EJBDipendente.add(dipendente);
		
		return esito;
	}
	
	@GET
	@Path("/tuttodeldipendente/{id_dipendente}")
	public Esito tuttoDelDipendente(@PathParam("id_dipendente") String id_dipendente){
		EJBDipendente = richiamaEJBDipendente.callEJBDipendente();
		System.out.println("dentro tuttoDelDipendente");
		esito = new Esito();
		esito = EJBDipendente.tuttoDelDipendente(id_dipendente);
		
		return esito;
	}
	
	
	@POST
	@Path("login")
	public Esito findByEmailAndPassword(Dipendente dipendente) {
		EJBDipendente = richiamaEJBDipendente.callEJBDipendente();
		System.out.println("dentro findByEmailAndPassword");
		esito = new Esito();
		esito = EJBDipendente.findByEmailAndPassword(dipendente);
		
		return esito;
	}
	
	@GET
	@Path("dipendenteconcontrattoattuale/{id_dipendente}")
	public Esito dipendenteConContrattoAttuale(@PathParam("id_dipendente") String id_dipendente) {
		EJBDipendente = richiamaEJBDipendente.callEJBDipendente();
		System.out.println("dentro dipendenteConContrattoAttuale");
		esito = new Esito();
		esito = EJBDipendente.dipendenteConContrattoAttuale(id_dipendente);
		System.out.println(esito.getData().toString());
		
		return esito;
	}
	


}
