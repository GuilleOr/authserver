package ar.com.medicinas.authserver.securty.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class PasswordEncoderHelper {

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private PasswordEncoderHelper() {
	}

	public static PasswordEncoder getBCryptPasswordEncoder() {
		return passwordEncoder;
	}
}
