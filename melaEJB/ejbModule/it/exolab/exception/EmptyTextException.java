package it.exolab.exception;

public class EmptyTextException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5070272312815813557L;

	public EmptyTextException() {
		super("Devi inserire del testo nei campi");
	}
}
