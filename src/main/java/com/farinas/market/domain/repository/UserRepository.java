package com.farinas.market.domain.repository;

import com.farinas.market.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
        List<User> getAll();
        //Optional<List<User>> getByRole(int roleId);
        Optional<User> getByUsername(String username);
        User saveUser(User user);
        void deleteUser(int id);
        Boolean existsByUsername(String username);
}
