package com.SpringBootwebservice.Springboot_restfull_webService.service;

import com.SpringBootwebservice.Springboot_restfull_webService.dto.UserDTO;
import com.SpringBootwebservice.Springboot_restfull_webService.entity.User;

import java.util.List;

public interface UserService {

     UserDTO createUser(UserDTO userDTO);

     UserDTO getUser(long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(long id, UserDTO userDTO);

    String deleteUser(long id);
}