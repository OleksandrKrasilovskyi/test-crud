package com.example.tournament_spring_hibernate.service;

import com.example.tournament_spring_hibernate.dto.UserDTO;
import com.example.tournament_spring_hibernate.entity.User;
import com.example.tournament_spring_hibernate.mapper.UserMapper;
import com.example.tournament_spring_hibernate.repository.UserRepository;
import com.example.tournament_spring_hibernate.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    private final String PASSWORD_USERNAME_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,}$";
    private final Pattern PASSWORD_USERNAME_PATTERN = Pattern.compile(PASSWORD_USERNAME_REGEX);
    private final String EMAIL_REGEX = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";
    private final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public UserDTO findUserByEmail(String email) {
        return userMapper.mapEntityToDTO(userRepository.findByEmail(email).orElseThrow());
    }

    public void createUser(UserDTO userDTO) {
        if (PASSWORD_USERNAME_PATTERN.matcher(userDTO.getPassword()).matches()
                && PASSWORD_USERNAME_PATTERN.matcher(userDTO.getUserName()).matches()
                && EMAIL_PATTERN.matcher(userDTO.getEmail()).matches()) {
            userRepository.save(userMapper.mapDtoToEntity(userDTO));
        } else {
            System.out.println("Email or password creation requirements are not met!");
        }
    }

    public void updateUser(UserDTO userDTO, String email) {
        final User user = userRepository.findByEmail(email).orElseThrow();

        if (PASSWORD_USERNAME_PATTERN.matcher(userDTO.getUserName()).matches()) {
            user.setUserName(userDTO.getUserName());
        }
        if (EMAIL_PATTERN.matcher(userDTO.getEmail()).matches()) {
            user.setEmail(userDTO.getEmail());
        }
        if (PASSWORD_USERNAME_PATTERN.matcher(userDTO.getPassword()).matches()) {
            user.setPassword(userDTO.getPassword());
        }
    }

    public void deleteUserByEmailAndPassword(String email, String password) {
        userRepository.deleteByEmailAndPassword(email, password);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return SecurityUser.fromUser(userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("User: '%s', not found!", email))));
    }
}
