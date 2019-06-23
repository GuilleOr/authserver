package ar.com.medicinas.authserver.rest.dto;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

public class SetAnswerForUserRequest {
	@Size(min = 3, max = 3)
	@Valid
	List<SetAnswer> answerList;

	public List<SetAnswer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<SetAnswer> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "SetAnswerForUserRequest{" +
				"answerList=" + answerList +
				'}';
	}
}
