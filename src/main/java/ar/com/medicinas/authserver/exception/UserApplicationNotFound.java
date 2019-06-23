package ar.com.medicinas.authserver.exception;

import javax.validation.constraints.NotNull;

public class UserApplicationNotFound extends NotFoundException {
	public UserApplicationNotFound(@NotNull String uuid) {
		super("401", "user.application.not.found.exception.message", null, "user.application.not.found.exception.description", new String[]{uuid});
	}
}
