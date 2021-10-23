package com.farinas.market.persistence.mapper;

import com.farinas.market.domain.dto.User;
import com.farinas.market.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "lastLogin", target = "lastLogin"),
            @Mapping(source = "roles", target = "roles")
    }
    )
    User toUser(UserEntity userEntity);
    List<User> toUsers(List<UserEntity> userEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "status", constant = "true")
    }
    )
    UserEntity toUserEntity(User user);
}