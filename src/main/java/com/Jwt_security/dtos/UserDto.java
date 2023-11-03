package com.Jwt_security.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
//    @NotBlank(message = "can be not null")
    private String name;

//    @Email(message = "invalid email address")
    private String email;

//    @Pattern(regexp = "^.{6,}$", message = "more than 6 character")
    private String password;
}
