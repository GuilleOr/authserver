package ar.com.medicinas.authserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Petition extends BaseBean {
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String lastName;
}
