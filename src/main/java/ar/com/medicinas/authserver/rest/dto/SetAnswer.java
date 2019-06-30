package ar.com.medicinas.authserver.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SetAnswer {
	@NotNull
	private Long questionId;
	@NotNull
	@NotEmpty
	private String answer;
}
