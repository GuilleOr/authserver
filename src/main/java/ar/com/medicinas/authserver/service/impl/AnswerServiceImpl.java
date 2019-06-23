package ar.com.medicinas.authserver.service.impl;

import ar.com.medicinas.authserver.dao.AnswerDao;
import ar.com.medicinas.authserver.exception.ImpossibleToSetAnswers;
import ar.com.medicinas.authserver.exception.UserDontHaveAnswers;
import ar.com.medicinas.authserver.model.Answer;
import ar.com.medicinas.authserver.model.User;
import ar.com.medicinas.authserver.securty.helper.PasswordEncoderHelper;
import ar.com.medicinas.authserver.service.AnswerService;
import ar.com.medicinas.authserver.service.UserService;
import org.bouncycastle.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AnswerServiceImpl extends LogicalDeleteableBeanService<Answer> implements AnswerService {

	private static final Logger LOG = LoggerFactory.getLogger(AnswerServiceImpl.class);
	PasswordEncoder passwordEncoder = PasswordEncoderHelper.getBCryptPasswordEncoder();
	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private UserService userService;

	@Override
	public Boolean areCorrectTheAnswersForUser(List<Answer> answers, User user) {
		List<Answer> result = answerDao.findByActiveIsTrueAndUser_Id(user.getId());
		AtomicReference<Boolean> flag = new AtomicReference<>(true);
		if (result.isEmpty()) {
			throw new UserDontHaveAnswers();
		}
		result.stream().forEach(answer -> flag.set(flag.get() && comprobeIfHaveCorrectAnswer(answer, answers)));
		return flag.get();
	}

	private Boolean comprobeIfHaveCorrectAnswer(Answer answerToComprobe, List<Answer> answers) {
		return answers.stream().filter(answer -> answerToComprobe.getId().equals(answer.getId()) && passwordEncoder.matches(prepareResponseToBePersisted(answer.getResponse()), answerToComprobe.getResponse())).findFirst().isPresent();
	}

	private String prepareResponseToBePersisted(String response) {
		return response.trim().toLowerCase();
	}

	@Override
	protected Answer prepareToCreate(Answer answer) {
		answer.setResponse(this.prepareResponseToBePersisted(answer.getResponse()));
		return super.prepareToCreate(answer);
	}

	@Override
	public List<Answer> setAnswers(List<Answer> answers) {
		Optional<User> user = userService.getAuthenticatedUser();
		if (!user.isPresent()) {
			LOG.error("No se pudo encontrar al usuario intentando settear las preguntas");
			throw new ImpossibleToSetAnswers();
		}
		answers.forEach(answer -> {
			answer.setUser(user.get());
			answer.setResponse(passwordEncoder.encode(Strings.toLowerCase(answer.getResponse())));
		});
		return answerDao.saveAll(prepareToCreate(answers));
	}

	private List<Answer> prepareToCreate(List<Answer> answers) {
		answers.forEach(answer -> this.prepareToCreate(answer));
		return answers;
	}

	@Override
	public List<Answer> updateAnswer(List<Answer> answers) {
		Optional<User> user = userService.getAuthenticatedUser();
		if (!user.isPresent()) {
			LOG.error("No se pudo encontrar al usuario intentando settear las preguntas");
			throw new ImpossibleToSetAnswers();
		}
		answerDao.deleteAllByUser_Id(user.get().getId());
		answers.forEach(answer -> {
			answer.setUser(user.get());
			answer.setResponse(passwordEncoder.encode(Strings.toLowerCase(answer.getResponse())));
		});
		return answerDao.saveAll(prepareToCreate(answers));
	}
}
