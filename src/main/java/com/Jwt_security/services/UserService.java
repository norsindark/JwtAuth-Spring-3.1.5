package com.Jwt_security.services;

import com.Jwt_security.entities.User;
import com.Jwt_security.exceptions.UserNotFoundException;
import com.Jwt_security.repositories.UserRepository;
import com.Jwt_security.utils.GetUserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> getUserById(Integer id) throws UserNotFoundException {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty()) {
            return user;
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    public Optional<User> getUserByToken() throws UserNotFoundException {
        GetUserUtil userUtil = new GetUserUtil();
        String userName = userUtil.GetUserName();
        Optional<User> user = this.userRepository.findUserByEmail(userName);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found with id: " + userName);

        }
        return user;
    }
}
