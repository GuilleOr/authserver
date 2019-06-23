package ar.com.medicinas.authserver.rest.controller;

import ar.com.medicinas.authserver.exception.AnswerAreNotCorrectException;
import ar.com.medicinas.authserver.exception.CantAccessToUserAuthenticated;
import ar.com.medicinas.authserver.exception.PasswordNotAreTheSameException;
import ar.com.medicinas.authserver.exception.UserNotFoundException;
import ar.com.medicinas.authserver.model.Answer;
import ar.com.medicinas.authserver.model.Question;
import ar.com.medicinas.authserver.model.User;
import ar.com.medicinas.authserver.rest.dto.ChangePasswordRequest;
import ar.com.medicinas.authserver.rest.dto.QuestionDTO;
import ar.com.medicinas.authserver.rest.dto.ResetpasswordRequest;
import ar.com.medicinas.authserver.service.AnswerService;
import ar.com.medicinas.authserver.service.QuestionService;
import ar.com.medicinas.authserver.service.ResetPasswordPetitionService;
import ar.com.medicinas.authserver.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/api/account/password")
@RestController
public class PasswordRestController {
	private static final Logger LOG = LoggerFactory.getLogger(PasswordRestController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private ResetPasswordPetitionService resetPasswordService;
	@Autowired
	private MapperFacade orikaMapper;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private QuestionService questionService;

	@PatchMapping
	public void updatePassword(@NotNull @Valid @RequestBody ChangePasswordRequest request) {
		if (!Objects.equals(request.getNewPassword(), request.getRepeatNewPassword())) {
			LOG.info("El usuario no puede cambiar la password al menos que ambas coincidan");
			throw new PasswordNotAreTheSameException();
		}
		userService.updateUserPassword(request.getOldPassword(), request.getNewPassword());
	}

	@GetMapping
	public List<QuestionDTO> getQuestions() {
		Optional<User> user = userService.getAuthenticatedUser();
		if (!user.isPresent()) {
			LOG.error("Cant access to the authenticated user");
			throw new CantAccessToUserAuthenticated();
		}
		return questionService.readQuestionForUser(user.get()).stream().map(question -> mapQuestion(question)).collect(Collectors.toList());
	}

	@PostMapping(value = "/reset", consumes = APPLICATION_JSON_VALUE)
	public void resetPassword(@RequestBody @Valid @NotNull ResetpasswordRequest resetpasswordRequest) {
		User user = userService.readUserByEmail(resetpasswordRequest.getEmail()).orElseThrow(() -> {
			LOG.info("The user that someone is trying to reset is not found");
			return new UserNotFoundException(resetpasswordRequest.getEmail());
		});
		if (!answerService.areCorrectTheAnswersForUser(orikaMapper.mapAsList(resetpasswordRequest.getAnsweredQuestions(), Answer.class), user)) {
			throw new AnswerAreNotCorrectException();
		}
		resetPasswordService.resetPassword(user);
	}

	private QuestionDTO mapQuestion(Question question) {
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setQuestion(messageSource.getMessage(question.getQuestionCode(), null, Locale.getDefault()));
		questionDTO.setId(question.getId());
		return questionDTO;
	}

}
