package com.farinas.market.persistence.repository;

import com.farinas.market.domain.dto.Role;
import com.farinas.market.domain.repository.RoleRepository;
import com.farinas.market.persistence.crud.RoleEntityCrudRepository;
import com.farinas.market.persistence.crud.UserEntityCrudRepository;
import com.farinas.market.persistence.entity.RoleEntity;
import com.farinas.market.persistence.entity.UserEntity;
import com.farinas.market.persistence.mapper.RoleMapper;
import com.farinas.market.persistence.mapper.UserMapper;
import com.farinas.market.security.enums.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleEntityRepository implements RoleRepository {
    @Autowired
    private RoleEntityCrudRepository roleEntityCrudRepository;
    @Autowired
    private RoleMapper mapper;

    @Override
    public List<Role> getAll() {
        List<RoleEntity> roleEntities =  (List<RoleEntity>) roleEntityCrudRepository.findAll();
        return mapper.toRoles(roleEntities);
    }

    @Override
    public Optional<Role> getById(int roleId) {
        return roleEntityCrudRepository.findById(roleId).map(role -> mapper.toRole(role));
    }

    @Override
    public Optional<Role> getByRoleName(RoleName roleName) {
        return roleEntityCrudRepository.findByRoleName(roleName).map(role -> mapper.toRole(role));
    }

    @Override
    public Role saveRole(Role role) {
        return mapper.toRole(roleEntityCrudRepository.save(mapper.toRoleEntity(role)));
    }
}
