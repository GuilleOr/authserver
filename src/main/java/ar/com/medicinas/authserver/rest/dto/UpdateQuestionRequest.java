package ar.com.medicinas.authserver.rest.dto;

import lombok.Data;

@Data
public class UpdateQuestionRequest extends CreateQuestionRequest {
	private Long id;
}
