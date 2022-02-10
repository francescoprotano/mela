package it.exolab.richiamaejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.MeseEJBRemote;



public class RichiamaEJBMese{
	
private MeseEJBRemote EJBMese;
	
	public MeseEJBRemote lookupOnRemote() {

		Properties props;
		InitialContext ctx;

		props = new Properties();
		try {
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			ctx = new InitialContext(props);

			String mystring = "java:global/melaEJBEAR/melaEJB/MeseEJB!it.exolab.ejb.MeseEJBRemote";

			EJBMese = (MeseEJBRemote) ctx.lookup(mystring);
			return EJBMese;

		} catch (NamingException ex) {
			ex.printStackTrace();

		} catch (ClassCastException cce) {
			System.out.println("MeseEJB, cast non riuscito.");
			cce.printStackTrace();
		}

		return EJBMese;

	}

}

