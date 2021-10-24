package com.farinas.market.web.controller;

import com.farinas.market.domain.dto.Message;
import com.farinas.market.domain.dto.User;
import com.farinas.market.domain.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@Api(tags = { "Users" })
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping()
    @ApiOperation("Get all users (requires ADMIN ROLE)")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation("Get user by Id (requires ADMIN ROLE)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@ApiParam(value = "The user id", required = true, example = "1") @PathVariable("id") int id) {
        return userService.getUser(id)
                .map(user -> new ResponseEntity<User>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation("Enable/Disable user by Id (requires ADMIN ROLE)")
    @PutMapping("/status/{id}")
    public ResponseEntity<?> disableUser(@PathVariable("id") int id) {
        return userService.updateUserStatus(id)
                .map(user -> new ResponseEntity<>(new Message(user.getActive()
                        ? "User enabled successfully"
                        : "User disabled successfully"),HttpStatus.OK))
                .orElse(new ResponseEntity<>(new Message("User not found"), HttpStatus.NOT_FOUND));
    }
}