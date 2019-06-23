package ar.com.medicinas.authserver.exception;

import org.springframework.http.HttpStatus;

public class ImpossibleToUpdatePassword extends BusinessException {
	public ImpossibleToUpdatePassword() {
		super("", "", null, "", null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
