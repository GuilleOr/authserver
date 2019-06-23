package ar.com.medicinas.authserver.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Question extends BaseBean {
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String questionCode;
	@OneToMany
	private List<Answer> answers;
}
