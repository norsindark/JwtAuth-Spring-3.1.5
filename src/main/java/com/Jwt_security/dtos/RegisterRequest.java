package com.Jwt_security.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "can't be null")
    private String name;

    @NotBlank(message = "can't be null")
    @Email(message = "invalid email address")
    private String email;

    @NotBlank(message = "can't be null")
    @Pattern(regexp = "^.{6,}$", message = "more than 6 character")
    private String password;
}
