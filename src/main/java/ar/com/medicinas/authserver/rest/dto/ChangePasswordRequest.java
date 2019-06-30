package ar.com.medicinas.authserver.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ChangePasswordRequest {
	@NotNull
	@NotEmpty
	private String oldPassword;
	@NotNull
	@NotEmpty
	private String newPassword;
	@NotNull
	@NotEmpty
	private String repeatNewPassword;
}
