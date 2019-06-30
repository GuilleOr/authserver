package ar.com.medicinas.authserver.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateQuestionRequest {
	@NotNull
	@NotEmpty
	private String questionCode;
}
