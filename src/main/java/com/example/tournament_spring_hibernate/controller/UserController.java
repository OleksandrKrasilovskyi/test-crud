package com.example.tournament_spring_hibernate.controller;

import com.example.tournament_spring_hibernate.dto.UserDTO;
import com.example.tournament_spring_hibernate.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/getUser")
    public ResponseEntity<UserDTO> findUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    @PutMapping("/update")
    public void updateUserByEmailGetFromParam(@RequestParam String email,
                                              @RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO, email);
    }

    @PostMapping("/new")
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByEmailAndPasswordGetFromParam(@RequestParam String email,
                                                         @RequestParam String password) {
        userService.deleteUserByEmailAndPassword(email, password);
    }
}
