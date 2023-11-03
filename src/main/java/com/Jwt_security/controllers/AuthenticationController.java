package com.Jwt_security.controllers;

import com.Jwt_security.dtos.AuthenticationRequest;
import com.Jwt_security.exceptions.EmailAlreadyExistsException;
import com.Jwt_security.repositories.AuthenticationResponse;
import com.Jwt_security.services.AuthenticationService;
import com.Jwt_security.dtos.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
          @Valid @RequestBody RegisterRequest request
    ) throws EmailAlreadyExistsException {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @Valid @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.login(request));
    }
}
