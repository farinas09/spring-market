package com.farinas.market.web.controller;

import com.farinas.market.domain.dto.*;
import com.farinas.market.security.enums.RoleName;
import com.farinas.market.security.jwt.JwtEntryPoint;
import com.farinas.market.security.jwt.JwtProvider;
import com.farinas.market.domain.service.RoleService;
import com.farinas.market.domain.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(tags = { "Auth" })
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

    private final static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegister newUSer,
                                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.error("Register bad request: Incorrect fields");
            return new ResponseEntity<>("Incorrect fields", HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByUsername(newUSer.getUsername())){
            logger.error("Register bad request: Username " + newUSer.getUsername() + " already exists");
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }

        User user = new User(newUSer.getName(), newUSer.getUsername(), passwordEncoder.encode(newUSer.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
        if(newUSer.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
        user.setRoles(roles);

        userService.save(user);
        logger.info("Register: User " + user.getUsername() + " created");

        return new ResponseEntity<>(new Message("User created"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("Register bad request: Incorrect fields");
            return new ResponseEntity<>(new Message("Bad request"), HttpStatus.BAD_REQUEST);
        }
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
            user.setLastLogin(LocalDateTime.now());
            userService.save(user);
            logger.info("Login: User " + user.getUsername() + " logged in");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            logger.error("Login: User not found");
            return new ResponseEntity<>(new Message("User not found"), HttpStatus.NOT_FOUND);
        }

    }
}
