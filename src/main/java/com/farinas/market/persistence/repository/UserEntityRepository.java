package com.farinas.market.persistence.repository;

import com.farinas.market.domain.dto.Product;
import com.farinas.market.domain.dto.User;
import com.farinas.market.domain.repository.ProductRepository;
import com.farinas.market.domain.repository.UserRepository;
import com.farinas.market.persistence.crud.ProductEntityCrudRepository;
import com.farinas.market.persistence.crud.UserEntityCrudRepository;
import com.farinas.market.persistence.entity.ProductEntity;
import com.farinas.market.persistence.entity.UserEntity;
import com.farinas.market.persistence.mapper.ProductMapper;
import com.farinas.market.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserEntityRepository implements UserRepository {
    @Autowired
    private UserEntityCrudRepository userEntityCrudRepository;
    @Autowired
    private UserMapper mapper;


    @Override
    public List<User> getAll() {
        List<UserEntity> userEntities =  (List<UserEntity>) userEntityCrudRepository.findAll();
        return mapper.toUsers(userEntities);
    }

    @Override
    public Optional<User> getById(int userId) {
        return userEntityCrudRepository.findById(userId).map(user -> mapper.toUser(user));
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userEntityCrudRepository.findByUsername(username).map(user -> mapper.toUser(user));
    }

    @Override
    public User saveUser(User user) {
        return mapper.toUser(userEntityCrudRepository.save(mapper.toUserEntity(user)));
    }

    @Override
    public Optional<User> updateUserStatus(int id) {
        return userEntityCrudRepository.findById(id).map(userEntity -> {
            userEntity.setStatus(!userEntity.getStatus());
            userEntityCrudRepository.save(userEntity);
            return mapper.toUser(userEntity);
        }
        );
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userEntityCrudRepository.existsByUsername(username);
    }
}
