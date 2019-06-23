package ar.com.medicinas.authserver.exception;

import org.springframework.http.HttpStatus;

public class ImpossibleToSetAnswers extends BusinessException {
	public ImpossibleToSetAnswers() {
		super("", "", null, "", null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
