package ar.com.medicinas.authserver.rest.dto;

import lombok.Data;

@Data
public class UpdateProfileRequest {
	private String username;
	private String email;
	private String password;
	private String repeatPassword;
}
