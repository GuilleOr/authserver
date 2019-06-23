package ar.com.medicinas.authserver.rest.controller;

import ar.com.medicinas.authserver.model.Answer;
import ar.com.medicinas.authserver.rest.dto.SetAnswerForUserRequest;
import ar.com.medicinas.authserver.service.AnswerService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/answer")
public class AnswerRestController {

	@Autowired
	private AnswerService answerService;
	@Autowired
	private MapperFacade orikaMapper;

	@PreAuthorize("isFullyAuthenticated()")
	@PostMapping
	public void createSecurityAnswers(@RequestBody @NotNull @NotEmpty SetAnswerForUserRequest request) {
		answerService.setAnswers(orikaMapper.mapAsList(request.getAnswerList(), Answer.class));
	}

	@PreAuthorize("isFullyAuthenticated()")
	@PutMapping
	public void updateSecurityAnswers(@RequestBody @NotNull @NotEmpty SetAnswerForUserRequest request) {
		answerService.updateAnswer(orikaMapper.mapAsList(request.getAnswerList(), Answer.class));
	}

}
