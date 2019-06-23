package ar.com.medicinas.authserver.dao;

import ar.com.medicinas.authserver.model.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerDao extends LogicalDeleteableBeanDao<Answer> {
	List<Answer> findAllByUser_IdAndActiveIsTrue(Long userId);

	Optional<Answer> findByActiveIsTrueAndUser_IdAndQuestion_IdAndResponse(Long userId, Long questionId, String response);

	List<Answer> findByActiveIsTrueAndUser_Id(Long id);

	void deleteAllByUser_Id(Long userId);
}
