package ar.com.medicinas.authserver.service;

import ar.com.medicinas.authserver.model.Answer;
import ar.com.medicinas.authserver.model.User;

import java.util.List;

public interface AnswerService {
	Boolean areCorrectTheAnswersForUser(List<Answer> answers, User user);

	List<Answer> setAnswers(List<Answer> answers);

	List<Answer> updateAnswer(List<Answer> answers);
}
