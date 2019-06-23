package ar.com.medicinas.authserver.exception;

import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends BusinessException {

	public NotFoundException(String code, String message, String[] messageArguments, String description, String[] descriptionArguments) {
		super(code, message, messageArguments, description, descriptionArguments, HttpStatus.NOT_FOUND);
	}

}
