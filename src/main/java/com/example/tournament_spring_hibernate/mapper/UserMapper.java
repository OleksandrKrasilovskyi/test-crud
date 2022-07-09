package com.example.tournament_spring_hibernate.mapper;

import com.example.tournament_spring_hibernate.dto.UserDTO;
import com.example.tournament_spring_hibernate.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User mapDtoToEntity(UserDTO userDTO) {
        return new User()
                .setEmail(userDTO.getEmail())
                .setUserName(userDTO.getUserName())
                .setPassword(userDTO.getPassword());
    }

    public UserDTO mapEntityToDTO(User user) {
        return new UserDTO()
                .setEmail(user.getEmail())
                .setUserName(user.getUserName())
                .setPassword(user.getPassword());
    }
}
