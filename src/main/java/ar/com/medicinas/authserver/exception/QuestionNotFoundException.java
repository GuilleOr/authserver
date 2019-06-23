package ar.com.medicinas.authserver.exception;

public class QuestionNotFoundException extends NotFoundException {
	public QuestionNotFoundException(String identifier) {
		super("", "", new String[]{identifier}, "", null);
	}
}
