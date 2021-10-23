package com.farinas.market.persistence.crud;

import com.farinas.market.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserEntityCrudRepository extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername (String username);
    //List<UserEntity> findByIdRole(int categoryId);
}