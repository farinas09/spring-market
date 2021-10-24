package com.farinas.market.security.entity;

import com.farinas.market.domain.dto.User;
import com.farinas.market.persistence.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMain implements UserDetails {

    private String name;
    private String username;
    private String password;
    private boolean isActive;
    private Collection<? extends GrantedAuthority> authorities;

    public UserMain(String name, String username, String password, boolean isActive, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.authorities = authorities;
    }

    public static UserMain build(User user){
        List<GrantedAuthority> authorities =
                user.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                        .collect(Collectors.toList());
        return new UserMain(user.getName(), user.getUsername(), user.getPassword(), user.getActive(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
    public String getName() {
        return name;
    }

    public String getUserName() {
        return username;
    }
}
