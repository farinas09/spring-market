package com.farinas.market.domain.service;

import com.farinas.market.domain.dto.Role;
import com.farinas.market.persistence.entity.RoleEntity;
import com.farinas.market.security.enums.RoleName;
import com.farinas.market.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleName roleName){
        return  roleRepository.getByRoleName(roleName);
    }

    public void save(Role roleEntity){
        roleRepository.saveRole(roleEntity);
    }
}
