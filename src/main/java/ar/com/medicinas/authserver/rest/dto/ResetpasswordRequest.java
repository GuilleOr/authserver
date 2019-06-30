package ar.com.medicinas.authserver.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ResetpasswordRequest {
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private List<AnsweredQuestionDTO> answeredQuestions;
}
