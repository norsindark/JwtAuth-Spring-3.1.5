package com.Jwt_security.controllers;

import com.Jwt_security.entities.User;
import com.Jwt_security.exceptions.UserNotFoundException;
import com.Jwt_security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RestApiController {

    private final UserService userService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable int id ) throws UserNotFoundException {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }
}
