package it.springclienti.exception;

public class ClienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteException(String messagge) {
		super(messagge);
	}

}
