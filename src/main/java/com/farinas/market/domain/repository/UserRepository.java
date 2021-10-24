package com.farinas.market.domain.repository;

import com.farinas.market.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
        List<User> getAll();
        Optional<User> getById(int userId);
        Optional<User> getByUsername(String username);
        User saveUser(User user);
        Optional<User> updateUserStatus(int userId);
        Boolean existsByUsername(String username);
}
