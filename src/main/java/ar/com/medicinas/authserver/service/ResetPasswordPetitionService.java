package ar.com.medicinas.authserver.service;

import ar.com.medicinas.authserver.model.ResetPasswordPetition;
import ar.com.medicinas.authserver.model.User;

import java.util.Optional;

public interface ResetPasswordPetitionService {
	ResetPasswordPetition resetPassword(User user);

	Optional<ResetPasswordPetition> findResetPasswordPetitionByValidUuid(String uuid);

	ResetPasswordPetition createResetPasswordPetition(String email);
}
