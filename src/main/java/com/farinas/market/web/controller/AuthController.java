package com.farinas.market.web.controller;

import com.farinas.market.domain.dto.*;
import com.farinas.market.security.enums.RoleName;
import com.farinas.market.security.jwt.JwtProvider;
import com.farinas.market.domain.service.RoleService;
import com.farinas.market.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegister newUSer,
                                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Campos mal o email invalido", HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByUsername(newUSer.getUsername())){
            return new ResponseEntity<>("Ese nombre ya existe", HttpStatus.BAD_REQUEST);
        }

        User user = new User(newUSer.getName(), newUSer.getUsername(), passwordEncoder.encode(newUSer.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
        if(newUSer.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
        user.setRoles(roles);

        userService.save(user);

        return new ResponseEntity<>(new Message("User created"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Bad request"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(userLogin.getUsername(),
                                userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtValue = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.getByUsername(userDetails.getUsername()).orElse(null);

        if(user!=null) {
            AuthResponse response = new AuthResponse(jwtValue, user);
            Instant instant = Instant.now() ;
            user.setLastLogin(LocalDateTime.now());
            userService.save(user);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("User not found"), HttpStatus.NOT_FOUND);
        }

    }
}
