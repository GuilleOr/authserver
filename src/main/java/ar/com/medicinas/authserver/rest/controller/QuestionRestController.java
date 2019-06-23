package ar.com.medicinas.authserver.rest.controller;

import ar.com.medicinas.authserver.model.Question;
import ar.com.medicinas.authserver.rest.dto.CreateQuestionRequest;
import ar.com.medicinas.authserver.rest.dto.QuestionDTO;
import ar.com.medicinas.authserver.rest.dto.QuestionListDTO;
import ar.com.medicinas.authserver.rest.dto.UpdateQuestionRequest;
import ar.com.medicinas.authserver.service.QuestionService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private MapperFacade orikaMapper;
	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public List<QuestionListDTO> getQuestions() {
		List<QuestionListDTO> questions = orikaMapper.mapAsList(questionService.getQuestions(), QuestionListDTO.class);
		questions.forEach(question -> question.setQuestionCode(messageSource.getMessage(question.getQuestionCode(), null, Locale.getDefault())));
		return questions;
	}

	@GetMapping("/{id}")
	public QuestionDTO getQuestion(@PathVariable @NotNull Long id) {
		return orikaMapper.map(questionService.getQuestionById(id), QuestionDTO.class);
	}

	@PostMapping
	public QuestionDTO createQuestion(@RequestBody @NotNull @Valid CreateQuestionRequest request) {
		return orikaMapper.map(questionService.createQuestion(orikaMapper.map(request, Question.class)), QuestionDTO.class);
	}

	@PutMapping
	public QuestionDTO updateQuestion(@RequestBody @NotNull @Valid UpdateQuestionRequest request) {
		return orikaMapper.map(questionService.updateQuestion(orikaMapper.map(request, Question.class)), QuestionDTO.class);
	}

}
