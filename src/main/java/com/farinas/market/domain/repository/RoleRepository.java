package com.farinas.market.domain.repository;

import com.farinas.market.domain.dto.Role;
import com.farinas.market.security.enums.RoleName;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    List<Role> getAll();
    Optional<Role> getById(int roleId);
    Optional<Role> getByRoleName(RoleName roleName);
    Role saveRole(Role role);
}
