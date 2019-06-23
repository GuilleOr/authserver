package ar.com.medicinas.authserver.rest.mapper;

import ar.com.medicinas.authserver.model.Answer;
import ar.com.medicinas.authserver.rest.dto.SetAnswer;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		configureSetAnswerToAnswer(orikaMapperFactory);
	}

	private void configureSetAnswerToAnswer(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(SetAnswer.class, Answer.class)
				.field("questionId", "question.id")
				.field("answer", "response")
				.byDefault()
				.register();
	}
}
