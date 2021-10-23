package com.farinas.market.domain.dto;

import com.sun.istack.NotNull;

import java.util.HashSet;
import java.util.Set;

public class UserRegister {

    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;
    //User role as default
    private Set<String> roles = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
