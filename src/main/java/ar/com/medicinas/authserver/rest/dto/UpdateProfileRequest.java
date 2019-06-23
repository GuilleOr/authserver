package ar.com.medicinas.authserver.rest.dto;

import ar.com.medicinas.authserver.exception.PasswordNotAreTheSameException;

import java.util.Objects;

public class UpdateProfileRequest {
	private String username;
	private String email;
	private String password;
	private String repeatPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (!Objects.equals(password, repeatPassword)) {
			throw new PasswordNotAreTheSameException();
		}
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	@Override
	public String toString() {
		return "UpdateProfileRequest{" +
				"username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", repeatPassword='" + repeatPassword + '\'' +
				'}';
	}
}
