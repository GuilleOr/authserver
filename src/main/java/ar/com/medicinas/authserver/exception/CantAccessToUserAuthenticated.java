package ar.com.medicinas.authserver.exception;

import org.springframework.http.HttpStatus;

public class CantAccessToUserAuthenticated extends BusinessException {

	public CantAccessToUserAuthenticated() {
		super("", "", null, "", null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
