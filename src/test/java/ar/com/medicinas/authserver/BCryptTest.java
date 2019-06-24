package ar.com.medicinas.authserver;

import ar.com.medicinas.authserver.securty.helper.PasswordEncoderHelper;
import org.junit.Test;

public class BCryptTest {
	@Test
	public void testPassword() {
		System.out.println(PasswordEncoderHelper.getBCryptPasswordEncoder().encode("Palmeras61212"));
	}
}
