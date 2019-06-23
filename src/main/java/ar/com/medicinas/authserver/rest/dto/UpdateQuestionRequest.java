package ar.com.medicinas.authserver.rest.dto;

public class UpdateQuestionRequest extends CreateQuestionRequest {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
