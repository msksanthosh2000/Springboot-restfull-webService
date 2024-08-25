package com.SpringBootwebservice.Springboot_restfull_webService.controller;


import com.SpringBootwebservice.Springboot_restfull_webService.entity.User;
import com.SpringBootwebservice.Springboot_restfull_webService.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("users-service")
public class UserController {

    private UserService userService;

    // API TO CREATE USER
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
}
