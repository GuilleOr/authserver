package ar.com.medicinas.authserver.model;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@SQLDelete(sql = "update user set active = 0 where id = ?1")
public class User extends LogicalDeleteableBean {

	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String taxId;
	@Enumerated(EnumType.STRING)
	private UserTypeEnum userType;
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String username;
	@NotNull
	@NotEmpty
	private String password;
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String email;
	private String phone;
	private Date lastLogin;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
			joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<Role> roles;
	@NotNull
	private Boolean locked;
	@NotNull
	private Integer badLogin;

	public void addBadLogin() {
		this.badLogin++;
	}

	public void restoreBadLogin() {
		this.badLogin = 0;
	}
}
