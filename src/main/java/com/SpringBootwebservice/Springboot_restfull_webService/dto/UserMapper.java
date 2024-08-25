package com.SpringBootwebservice.Springboot_restfull_webService.dto;

import com.SpringBootwebservice.Springboot_restfull_webService.entity.User;

public class UserMapper {

    /*
     * Convert UserDTO to User
     */
    public static User mapToUser(UserDTO userDTO) {
        User user = new User(userDTO.getId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail());

        return user;
    }

    /*
     * Convert User to UserDTO
     */
    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());

        return userDTO;
    }
}
