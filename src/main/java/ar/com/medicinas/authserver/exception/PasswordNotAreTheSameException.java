package ar.com.medicinas.authserver.exception;

import org.springframework.http.HttpStatus;

public class PasswordNotAreTheSameException extends BusinessException {
	public PasswordNotAreTheSameException() {
		super("", "", null, "", null, HttpStatus.BAD_REQUEST);
	}
}
