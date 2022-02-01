package it.exolab.richiamaejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.DipendenteEJBRemote;


public class RichiamaEJBDipendente {
	
private DipendenteEJBRemote EJBDipendente;
	
	public DipendenteEJBRemote callEJBDipendente() {

		Properties props;
		InitialContext ctx;

		props = new Properties();
		try {
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			ctx = new InitialContext(props);

			String mystring = "java:global/melaEJBEAR/melaEJB/DipendenteEJB!it.exolab.ejb.DipendenteEJBRemote";

			EJBDipendente = (DipendenteEJBRemote) ctx.lookup(mystring);
			return EJBDipendente;

		} catch (NamingException ex) {
			ex.printStackTrace();

		} catch (ClassCastException cce) {
			System.out.println("DipendenteEJB, cast non riuscito.");
			cce.printStackTrace();
		}

		return EJBDipendente;

	}

}
