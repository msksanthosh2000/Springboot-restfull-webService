package com.SpringBootwebservice.Springboot_restfull_webService.controller;


import com.SpringBootwebservice.Springboot_restfull_webService.dto.UserDTO;
import com.SpringBootwebservice.Springboot_restfull_webService.entity.User;
import com.SpringBootwebservice.Springboot_restfull_webService.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("users-service")
public class UserController {

    private UserService userService;

    // Build API TO CREATE USER
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    // Build Get user Api

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    // Build Get all user Api

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUserDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
