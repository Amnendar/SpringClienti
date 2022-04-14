package it.springclienti.exception;

public class OrdineException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrdineException(String messagge) {
		super(messagge);
	}
}
