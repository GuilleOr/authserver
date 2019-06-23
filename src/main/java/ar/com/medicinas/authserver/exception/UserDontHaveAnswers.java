package ar.com.medicinas.authserver.exception;

import org.springframework.http.HttpStatus;

public class UserDontHaveAnswers extends BusinessException {
	public UserDontHaveAnswers() {
		super("", "", null, "", null, HttpStatus.CONFLICT);
	}
}
