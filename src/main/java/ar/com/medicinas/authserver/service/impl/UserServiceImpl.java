package ar.com.medicinas.authserver.service.impl;

import ar.com.medicinas.authserver.dao.UserDao;
import ar.com.medicinas.authserver.exception.*;
import ar.com.medicinas.authserver.model.AppLevelEnum;
import ar.com.medicinas.authserver.model.Role;
import ar.com.medicinas.authserver.model.User;
import ar.com.medicinas.authserver.securty.helper.PasswordEncoderHelper;
import ar.com.medicinas.authserver.service.RoleService;
import ar.com.medicinas.authserver.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends LogicalDeleteableBeanService<User> implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	private static final String ADMINISTRATOR = "administrator";
	private static final String CLIENT = "client";
	private static PasswordEncoder passwordEncoder = PasswordEncoderHelper.getBCryptPasswordEncoder();
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleService roleService;

	@Override
	public List<User> readAllActiveUsers() {
		return userDao.findAllByActiveIsTrue();
	}

	@Override
	public List<User> readAllUsers() {
		return userDao.findAll();
	}

	@Override
	public Collection<User> readAllAdministratorUsers(Boolean active) {
		return findUserByAppLevelAndActive(active, AppLevelEnum.ADMINISTRATOR);
	}

	@Override
	public Collection<User> readAllClientUsers(Boolean active) {
		return findUserByAppLevelAndActive(active, AppLevelEnum.CLIENT);
	}

	public Optional<User> readUserForLogin(String username) {
		return userDao.findUserByUsernameOrEmailAndActiveIsTrueAndLockedIsFalse(username, username);
	}

	@Override
	public Optional<User> readUserByEmail(String email) {
		return readOptUserByEmail(email);
	}

	@Override
	public Optional<User> readOptUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

	private User createUser(User user) {
		if (userDao.findUserByEmailAndUsername(user.getEmail(), user.getUsername()).isPresent()) {
			throw new UserExistException(user.getEmail());
		}
		return userDao.save(prepareToCreate(user));
	}

	@Override
	public User updateUser(User user) {
		Optional<User> optUser = userDao.findUserByEmail(user.getEmail());
		if (optUser.isPresent() && !optUser.get().getId().equals(user.getId())) {
			throw new UserExistException(user.getEmail());
		}
		return userDao.save(prepareToUpdate(user));
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public void deleteUser(String uuid) {
		userDao.deleteByUuid(uuid);
	}

	@Override
	public Optional<User> readUserById(@NotNull Long id) {
		return userDao.findById(id);
	}

	@Override
	public User createAdminUser(User user) {
		return createDefaultProfileUser(user, ADMINISTRATOR);
	}

	@Override
	public User createClientUser(User user) {
		return createDefaultProfileUser(user, CLIENT);
	}

	@Override
	public Optional<User> getAuthenticatedUser() {
		return userDao.findByUuid(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
	}

	@Override
	public User updateUserProfile(User user) {
		return null;
	}

	@Override
	public User updateUserPassword(String oldPassword, String newPassword) {
		Optional<User> user = userDao.findByUuid(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		if (!user.isPresent()) {
			LOG.info("No se puede encontrar el usuario correspondiente");
			throw new ImpossibleToUpdatePassword();
		}
		if (passwordEncoder.matches(oldPassword, user.get().getPassword())) {
			LOG.info("Las passwords no machearon correctamente");
			throw new OldPasswordDontMatchException();
		}
		user.get().setPassword(passwordEncoder.encode(newPassword));
		return userDao.save(super.prepareToUpdate(user.get()));
	}

	@Override
	public void disableAccount() {
		userDao.deleteByUuid(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
	}

	protected User createDefaultProfileUser(User user, String defaultRole) {
		String formatedRole = defaultRole.toLowerCase().trim();
		Role role = roleService.readRoleByName(formatedRole).orElseThrow(() -> {
			LOG.error(String.format("Error when I trying to read the %s role/profile ", formatedRole));
			return new RoleNotFoundException(formatedRole);
		});
		user.setRoles(Arrays.asList(role));
		return createUser(user);
	}

	@Override
	protected User prepareToCreate(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setBadLogin(0);
		user.setLocked(false);
		return super.prepareToCreate(user);
	}

	@Override
	protected User prepareToUpdate(User user) {
		User persistedUser = userDao.findById(user.getId()).orElseThrow(() -> new UserNotFoundException(user.getEmail()));
		persistedUser.setEmail(user.getEmail());
		persistedUser.setName(user.getName());
		if (!StringUtils.isNotEmpty(user.getPassword()) && !persistedUser.getPassword().equals(user.getPassword())) {
			persistedUser.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		return super.prepareToUpdate(persistedUser);
	}

	private Collection<User> findUserByAppLevelAndActive(Boolean active, AppLevelEnum level) {
		return active == null ? userDao.findAllByRoles(level) : userDao.findAllByRolesAndActive(active, level);
	}

}
