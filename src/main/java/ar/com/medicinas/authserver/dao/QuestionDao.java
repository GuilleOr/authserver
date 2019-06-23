package ar.com.medicinas.authserver.dao;

import ar.com.medicinas.authserver.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends BaseBeanDao<Question> {

	@Query(value = "SELECT * FROM QUESTION q INNER JOIN ANSWER a ON (q.id = a.question_id) WHERE a.user_id = ?0", nativeQuery = true)
	List<Question> findAllByAnswers(Long userId);

}
