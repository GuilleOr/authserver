package ar.com.medicinas.authserver.exception;

public class UserApplicationExistException extends ElementExistException {
	public UserApplicationExistException() {
		super("001", "user.application.exist.exception.message", null, "user.application.exist.exception.description", null);
	}
}
