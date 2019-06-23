package ar.com.medicinas.authserver.service;

import ar.com.medicinas.authserver.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

	List<Role> readAllRoles();

	List<Role> readAllRoleMatchName(String name);

	Optional<Role> readRoleByName(String name);

	Optional<Role> readRoleById(Long id);

	Optional<Role> readRoleByUuid(String uuid);

	Role createRole(Role role);

	Role updateRole(Role role);

	void deleteRoleById(Long id);

	void deleteRoleByUuid(String uuid);

	void deleteRoleByName(String name);

}
