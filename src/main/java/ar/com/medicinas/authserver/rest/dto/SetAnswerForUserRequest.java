package ar.com.medicinas.authserver.rest.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SetAnswerForUserRequest {
	@Size(min = 3, max = 3)
	@Valid
	List<SetAnswer> answerList;
}
