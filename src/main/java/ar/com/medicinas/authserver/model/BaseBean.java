package ar.com.medicinas.authserver.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public abstract class BaseBean extends TimestampBean {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String uuid;
}

