package ar.com.medicinas.authserver.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Role extends LogicalDeleteableBean {

	@NotNull
	@NotEmpty
	@Column(unique = true)
	@Setter(AccessLevel.NONE)
	private String name;
	@NotNull
	@NotEmpty
	private String description;
	@NotEmpty
	@NotNull
	@Column(unique = true)
	@Setter(AccessLevel.NONE)
	private String normalizedName;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_permission",
			joinColumns = @JoinColumn(name = "ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID"))
	private List<Permission> permissions;
	@NotNull
	@Enumerated(EnumType.STRING)
	private AppLevelEnum level;

	public void setName(String name) {
		this.name = name;
		this.normalizedName = name.toLowerCase().trim();
	}
}
