package ar.com.medicinas.authserver.rest.dto;

import ar.com.medicinas.authserver.model.UserTypeEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateUserRequest {
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
	private String repeatPassword;
	@NotNull
	@NotEmpty
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CreateUserRequest{" +
				"name='" + name + '\'' +
				", taxId='" + taxId + '\'' +
				", userType=" + userType +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", repeatPassword='" + repeatPassword + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
