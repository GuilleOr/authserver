package ar.com.medicinas.authserver.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SetAnswer {
	@NotNull
	private Long questionId;
	@NotNull
	@NotEmpty
	private String answer;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "SetAnswer{" +
				"questionId=" + questionId +
				", answer='" + answer + '\'' +
				'}';
	}
}
