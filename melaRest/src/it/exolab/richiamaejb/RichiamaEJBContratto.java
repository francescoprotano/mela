package it.exolab.richiamaejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.ContrattoEJBRemote;


public class RichiamaEJBContratto {
	
private ContrattoEJBRemote EJBContratto;
	
	public ContrattoEJBRemote callEJBContratto() {

		Properties props;
		InitialContext ctx;

		props = new Properties();
		try {
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			ctx = new InitialContext(props);

			String mystring = "java:global/melaEJBEAR/melaEJB/ContrattoEJB!it.exolab.ejb.ContrattoEJBRemote";

			EJBContratto = (ContrattoEJBRemote) ctx.lookup(mystring);
			return EJBContratto;

		} catch (NamingException ex) {
			ex.printStackTrace();

		} catch (ClassCastException cce) {
			System.out.println("ContrattoEJB, cast non riuscito.");
			cce.printStackTrace();
		}

		return EJBContratto;

	}

}


