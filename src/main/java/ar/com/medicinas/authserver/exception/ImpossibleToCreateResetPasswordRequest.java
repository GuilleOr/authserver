package ar.com.medicinas.authserver.exception;

import org.springframework.http.HttpStatus;

public class ImpossibleToCreateResetPasswordRequest extends BusinessException {

	public ImpossibleToCreateResetPasswordRequest() {
		super("", "", null, "", null, HttpStatus.CONFLICT);
	}

}
