package ar.com.medicinas.authserver.rest.dto;

public class QuestionDTO {
	private Long id;
	private String question;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionDTO{" +
				"id=" + id +
				", question='" + question + '\'' +
				'}';
	}
}
