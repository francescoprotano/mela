package it.exolab.exception;

public class FailedInsertException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5511809478076764629L;
	
	public FailedInsertException() {
		super("Inserimento fallito");
	}
	
	public FailedInsertException(String message) {
		super(message);
	}

}
