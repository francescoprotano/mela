package it.exolab.exception;

public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8751880977513865346L;
	
	public NotFoundException() {
		super("Dipendente non trovato");
	}

}
