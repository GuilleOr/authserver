package ar.com.medicinas.authserver.exception;

import org.springframework.http.HttpStatus;

public class AnswerAreNotCorrectException extends BusinessException {
	public AnswerAreNotCorrectException() {
		super("", "", null, "", null, HttpStatus.FORBIDDEN);
	}
}
