package com.Jwt_security.repositories;

import com.Jwt_security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);
//    User findByUserId(int userId);
}
