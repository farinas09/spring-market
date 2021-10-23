package com.farinas.market.security.service;

import com.farinas.market.domain.dto.User;
import com.farinas.market.persistence.repository.UserEntityRepository;
import com.farinas.market.persistence.entity.UserEntity;
import com.farinas.market.security.entity.UserMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userEntityRepository.getByUsername(username).get();
        return UserMain.build(user);
    }
}
