package ar.com.medicinas.authserver.service;

import ar.com.medicinas.authserver.model.Question;
import ar.com.medicinas.authserver.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
	Page<Question> getQuestions(Pageable pageable);

	List<Question> getQuestions();

	Optional<Question> getQuestionById(Long id);

	Question createQuestion(Question question);

	Question updateQuestion(Question question);

	List<Question> readQuestionForUser(User user);
}
