package ar.com.medicinas.authserver.exception;

public class PetitionNotFoundException extends NotFoundException {
	public PetitionNotFoundException(String uuid) {
		super("", "", new String[]{uuid}, "", null);
	}
}
