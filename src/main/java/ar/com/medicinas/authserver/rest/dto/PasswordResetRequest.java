package ar.com.medicinas.authserver.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PasswordResetRequest {
	@NotNull
	@NotEmpty
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PasswordResetRequest{" +
				"email='" + email + '\'' +
				'}';
	}
}
