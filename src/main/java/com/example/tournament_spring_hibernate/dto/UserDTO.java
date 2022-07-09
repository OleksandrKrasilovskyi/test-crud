package com.example.tournament_spring_hibernate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserDTO {
    private Long id;
    private String email;
    private String userName;
    private String password;
    private String permission;
}
