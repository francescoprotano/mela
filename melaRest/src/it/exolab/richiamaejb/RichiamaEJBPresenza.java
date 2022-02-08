package it.exolab.richiamaejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.PresenzaEJBRemote;



public class RichiamaEJBPresenza {
	private PresenzaEJBRemote EJBPresenza;
	
	
	
	public PresenzaEJBRemote doLookupOnEJBRemoteInterface() {

		Properties props;
		InitialContext ctx;

		props = new Properties();
		try {
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			ctx = new InitialContext(props);

			String mystring = "java:global/melaEJBEAR/melaEJB/PresenzaEJB!it.exolab.ejb.PresenzaEJBRemote";

			EJBPresenza = (PresenzaEJBRemote) ctx.lookup(mystring);
			return EJBPresenza;

		} catch (NamingException ex) {
			ex.printStackTrace();

		} catch (ClassCastException cce) {
			System.out.println("PresenzaEJB, cast non riuscito.");
			cce.printStackTrace();
		}

		return EJBPresenza;

	}

}



