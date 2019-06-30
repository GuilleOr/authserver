package ar.com.medicinas.authserver.rest.dto;

import ar.com.medicinas.authserver.model.UserRoleEnum;
import ar.com.medicinas.authserver.model.UserTypeEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateUserRequest {
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String documentNumber;
	@NotNull
	private Long documentTypeId;
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
	private String repeatPassword;
	@NotNull
	@NotEmpty
	private String email;
	@Enumerated(EnumType.STRING)
	@NotNull
	private UserRoleEnum userRole;
}
