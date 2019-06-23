package ar.com.medicinas.authserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class QuestionListDTO {
	private Long id;
	private String questionCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonGetter("question")
	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	@Override
	public String toString() {
		return "QuestionListDTO{" +
				"id=" + id +
				", questionCode='" + questionCode + '\'' +
				'}';
	}
}
