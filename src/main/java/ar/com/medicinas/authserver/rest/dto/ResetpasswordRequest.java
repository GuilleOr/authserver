package ar.com.medicinas.authserver.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ResetpasswordRequest {
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private List<AnsweredQuestionDTO> answeredQuestions;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AnsweredQuestionDTO> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setAnsweredQuestions(List<AnsweredQuestionDTO> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	@Override
	public String toString() {
		return "ResetpasswordRequest{" +
				"email='" + email + '\'' +
				", answeredQuestions=" + answeredQuestions +
				'}';
	}
}
