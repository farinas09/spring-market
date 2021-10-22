package com.farinas.market.security.repository;

import com.farinas.market.security.entity.Role;
import com.farinas.market.security.enums.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
