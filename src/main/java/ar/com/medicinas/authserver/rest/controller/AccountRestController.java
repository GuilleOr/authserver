package ar.com.medicinas.authserver.rest.controller;

import ar.com.medicinas.authserver.model.User;
import ar.com.medicinas.authserver.rest.dto.CreateUserRequest;
import ar.com.medicinas.authserver.rest.dto.UpdateProfileRequest;
import ar.com.medicinas.authserver.rest.dto.UserDTO;
import ar.com.medicinas.authserver.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {

	@Autowired
	private UserService userService;
	@Autowired
	private MapperFacade orikaMapper;

	@PreAuthorize("isAuthenticated()")
	@GetMapping
	public UserDTO getMyUserProfile() {
		return orikaMapper.map(userService.getAuthenticatedUser().orElseThrow(() -> new UsernameNotFoundException("unknow")), UserDTO.class);
	}

	@PostMapping
	public UserDTO createUser(@RequestBody @Valid CreateUserRequest request) {
		return orikaMapper.map(userService.createClientUser(orikaMapper.map(request, User.class)), UserDTO.class);
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping
	public UserDTO updateUserProfile(@NotNull @Valid @RequestBody UpdateProfileRequest request) {
		return orikaMapper.map(userService.updateUserProfile(orikaMapper.map(request, User.class)), UserDTO.class);
	}

	@PreAuthorize("isAUthenticated()")
	@DeleteMapping
	public void disableAccount() {
		userService.disableAccount();
	}

}
