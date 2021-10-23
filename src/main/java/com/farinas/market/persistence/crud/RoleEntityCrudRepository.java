package com.farinas.market.persistence.crud;

import com.farinas.market.persistence.entity.RoleEntity;
import com.farinas.market.security.enums.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleEntityCrudRepository extends CrudRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByRoleName(RoleName roleName);
}
