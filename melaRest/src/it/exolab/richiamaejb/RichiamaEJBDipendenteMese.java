package it.exolab.richiamaejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.DipendenteMeseEJBRemote;


public class RichiamaEJBDipendenteMese {
	
private DipendenteMeseEJBRemote EJBDipendenteMese;
	
	public DipendenteMeseEJBRemote lookupOnRemote() {

		Properties props;
		InitialContext ctx;

		props = new Properties();
		try {
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			ctx = new InitialContext(props);

			String mystring = "java:global/melaEJBEAR/melaEJB/DipendenteMeseEJB!it.exolab.ejb.DipendenteMeseEJBRemote";

			EJBDipendenteMese = (DipendenteMeseEJBRemote) ctx.lookup(mystring);
			return EJBDipendenteMese;

		} catch (NamingException ex) {
			ex.printStackTrace();

		} catch (ClassCastException cce) {
			System.out.println("DipendenteMeseEJB, cast non riuscito.");
			cce.printStackTrace();
		}

		return EJBDipendenteMese;

	}

}
