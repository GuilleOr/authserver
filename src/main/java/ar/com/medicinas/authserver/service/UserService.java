package ar.com.medicinas.authserver.service;

import ar.com.medicinas.authserver.model.User;
import ar.com.medicinas.authserver.model.UserRoleEnum;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

	List<User> readAllActiveUsers();

	List<User> readAllUsers();

	Collection<User> readAllAdministratorUsers(Boolean active);

	Collection<User> readAllPacientUsers(Boolean active);

	Optional<User> readUserForLogin(String username);

	Optional<User> readUserByEmail(String email);

	Optional<User> readOptUserByEmail(String email);

	User updateUser(User user);

	void deleteUser(Long id);

	void deleteUser(String uuid);

	Optional<User> readUserById(@NotNull Long id);

	Optional<User> getAuthenticatedUser();

	User updateUserProfile(User user);

	User updateUserPassword(String oldPassword, String newPassword);

	void disableAccount();

	User createUser(User map, UserRoleEnum userRole);
}
