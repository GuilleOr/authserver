package ar.com.medicinas.authserver.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Permission extends LogicalDeleteableBean implements GrantedAuthority {

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String name;
	@NotNull
	@NotEmpty
	private String description;
	@NotNull
	@Enumerated(EnumType.STRING)
	private AppLevelEnum level;

	@Override
	public String getAuthority() {
		return this.name;
	}
}
