package ar.com.medicinas.authserver.rest.controller;

import ar.com.medicinas.authserver.rest.dto.PasswordResetRequest;
import ar.com.medicinas.authserver.service.ResetPasswordPetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/reset-petition/")
public class RestorePasswordController {
	@Autowired
	private ResetPasswordPetitionService resetPasswordPetitionService;

	@PostMapping
	@PermitAll
	public void createPetition(@RequestBody @Valid @NotNull PasswordResetRequest request) {
		resetPasswordPetitionService.createResetPasswordPetition(request.getEmail());
	}

}
