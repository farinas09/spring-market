package com.farinas.market.domain.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthResponse {

    private String token;
    private String bearer = "Bearer";
    private User user;

    public AuthResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
