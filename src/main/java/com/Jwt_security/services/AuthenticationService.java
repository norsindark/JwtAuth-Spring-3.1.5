package com.Jwt_security.services;

import com.Jwt_security.dtos.AuthenticationRequest;
import com.Jwt_security.dtos.RegisterRequest;
import com.Jwt_security.entities.Role;
import com.Jwt_security.entities.User;
import com.Jwt_security.exceptions.EmailAlreadyExistsException;
import com.Jwt_security.repositories.AuthenticationResponse;
import com.Jwt_security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws EmailAlreadyExistsException {
        Optional<User> existUserEmail = this.userRepository.findUserByEmail(request.getEmail());
        if (existUserEmail.isEmpty()) {
            User user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(encoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            this.userRepository.save(user);
            var jwtToken = jwtService.generaToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }
        else {
            throw new EmailAlreadyExistsException("this email already exist:" + request.getEmail());
        }
    }

    public AuthenticationResponse login(AuthenticationRequest request)  {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generaToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
