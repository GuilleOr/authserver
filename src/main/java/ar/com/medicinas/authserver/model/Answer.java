package ar.com.medicinas.authserver.model;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@SQLDelete(sql = "update answer set active = 0 where id = ?1")
@Data
public class Answer extends LogicalDeleteableBean {
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@NotNull
	@NotEmpty
	private String response;

}

