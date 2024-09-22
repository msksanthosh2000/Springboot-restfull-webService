package com.SpringBootwebservice.Springboot_restfull_webService.controller;


import com.SpringBootwebservice.Springboot_restfull_webService.dto.UserDTO;
import com.SpringBootwebservice.Springboot_restfull_webService.entity.User;
import com.SpringBootwebservice.Springboot_restfull_webService.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CURD REST API for Resource",
        description = "CURD REST API - create , get , getAll, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("users-service")
public class UserController {

    private UserService userService;

    // Build API TO CREATE USER
    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Success"
    )
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    // Build Get user Api
    @Operation(
            summary = "getById User REST API",
            description = "getById User REST API"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    // Build Get all user Api
    @Operation(
            summary = "GetAll User REST API",
            description = "GetAll User REST API"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUserDTO);
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
