package com.farinas.market.security.service;

import com.farinas.market.security.entity.User;
import com.farinas.market.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
