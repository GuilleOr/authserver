package ar.com.medicinas.authserver.securty;

import ar.com.medicinas.authserver.model.Permission;
import ar.com.medicinas.authserver.model.User;
import ar.com.medicinas.authserver.securty.helper.PasswordEncoderHelper;
import ar.com.medicinas.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		Optional<User> user = userService.readUserForLogin(username);
		if (!user.isPresent()) {
			throw new BadCredentialsException("Error trying to authenticate the user");
		}
		PasswordEncoder passwordEncoder = PasswordEncoderHelper.getBCryptPasswordEncoder();
		if (!passwordEncoder.matches(password, user.get().getPassword())) {
			user.get().addBadLogin();
			user.get().setLocked(Integer.valueOf(3).equals(user.get().getBadLogin()));
			userService.updateUser(user.get());
			throw new BadCredentialsException("The user or password is wrong");
		}
		user.get().restoreBadLogin();
		userService.updateUser(user.get());
		Set<Permission> authorities = user.get().getRoles().stream()
				.flatMap(roleDTO -> roleDTO.getPermissions().stream())
				.collect(Collectors.toSet());
		return new UsernamePasswordAuthenticationToken(user.get().getUuid(), user.get().getPassword(), authorities);
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}
}
