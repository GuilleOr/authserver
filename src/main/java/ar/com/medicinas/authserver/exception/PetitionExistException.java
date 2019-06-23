package ar.com.medicinas.authserver.exception;

public class PetitionExistException extends ElementExistException {
	public PetitionExistException(String email) {
		super("", "", new String[]{email}, "", null);
	}
}
