package com.Jwt_security.controllers;

import com.Jwt_security.entities.User;
import com.Jwt_security.exceptions.UserNotFoundException;
import com.Jwt_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<Optional<User>> getProfile() throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserByToken());
    }
}
