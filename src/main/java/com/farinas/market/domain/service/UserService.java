package com.farinas.market.domain.service;

import com.farinas.market.domain.dto.User;
import com.farinas.market.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> getByUsername(String username){
        return userRepository.getByUsername(username);
    }
    public Boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
    public void save(User user){
        userRepository.saveUser(user);
    }
    public List<User> getAll() { return userRepository.getAll(); }
    public Optional<User> getUser(int id){
        return userRepository.getById(id);
    }
    public Optional<User> updateUserStatus(int id) { return userRepository.updateUserStatus(id); }
}
