package ar.com.medicinas.authserver.exception;

import org.springframework.http.HttpStatus;

public class OldPasswordDontMatchException extends BusinessException {
	public OldPasswordDontMatchException() {
		super("", "", null, "", null, HttpStatus.BAD_REQUEST);
	}
}
