package com.farinas.market.persistence.mapper;

import com.farinas.market.domain.dto.Role;
import com.farinas.market.persistence.entity.RoleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "roleName", target = "roleName"),
    }
    )
    Role toRole(RoleEntity roleEntity);
    List<Role> toRoles(List<RoleEntity> roleEntities);

    @InheritInverseConfiguration
    RoleEntity toRoleEntity(Role role);
}