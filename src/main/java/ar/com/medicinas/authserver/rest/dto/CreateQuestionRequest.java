package ar.com.medicinas.authserver.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateQuestionRequest {
	@NotNull
	@NotEmpty
	private String questionCode;

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	@Override
	public String toString() {
		return "CreateQuestionRequest{" +
				"questionCode='" + questionCode + '\'' +
				'}';
	}
}
