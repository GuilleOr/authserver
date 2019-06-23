package ar.com.medicinas.authserver.service.impl;

import ar.com.medicinas.authserver.dao.QuestionDao;
import ar.com.medicinas.authserver.exception.QuestionNotFoundException;
import ar.com.medicinas.authserver.model.Question;
import ar.com.medicinas.authserver.model.User;
import ar.com.medicinas.authserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl extends BaseBeanService<Question> implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Override
	public Page<Question> getQuestions(Pageable pageable) {
		return questionDao.findAll(pageable);
	}

	@Override
	public List<Question> getQuestions() {
		return questionDao.findAll();
	}

	@Override
	public Optional<Question> getQuestionById(Long id) {
		return questionDao.findById(id);
	}

	@Override
	public Question createQuestion(Question question) {
		return questionDao.save(prepareToCreate(question));
	}

	@Override
	public Question updateQuestion(Question question) {
		Question persistedObject = questionDao.findById(question.getId()).orElseThrow(() -> new QuestionNotFoundException(question.getId().toString()));
		persistedObject.setQuestionCode(question.getQuestionCode());
		return questionDao.save(prepareToUpdate(persistedObject));
	}

	@Override
	public List<Question> readQuestionForUser(User user) {
		return questionDao.findAllByAnswers(user.getId());
	}
}
