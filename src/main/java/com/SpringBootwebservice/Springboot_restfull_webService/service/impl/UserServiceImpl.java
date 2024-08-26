package com.SpringBootwebservice.Springboot_restfull_webService.service.impl;

import com.SpringBootwebservice.Springboot_restfull_webService.dto.UserDTO;
import com.SpringBootwebservice.Springboot_restfull_webService.dto.UserMapper;
import com.SpringBootwebservice.Springboot_restfull_webService.entity.User;
import com.SpringBootwebservice.Springboot_restfull_webService.exception.EmailAlreadyExistsException;
import com.SpringBootwebservice.Springboot_restfull_webService.exception.ResourceNotFoundException;
import com.SpringBootwebservice.Springboot_restfull_webService.repository.UserRepository;
import com.SpringBootwebservice.Springboot_restfull_webService.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
//        User user = UserMapper.mapToUser(userDTO);
        User user = modelMapper.map(userDTO, User.class);

        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());

        if(userOptional.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exist for User");
        }

        User savedUser = userRepository.save(user);

//        return UserMapper.mapToUserDTO(savedUser);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id)
        );

//        return UserMapper.mapToUserDTO(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
//        List<UserDTO> usersDto = users.stream()
//                .map(UserMapper::mapToUserDTO)
//                .toList();

        List<UserDTO> usersDto = users.stream()
                .map(user -> {
                    return modelMapper.map(user, UserDTO.class);
                }).toList();

        return usersDto;
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
//        User user = UserMapper.mapToUser(userDTO);
        User user = modelMapper.map(userDTO, User.class);

        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id)
        );

        existingUser.setId(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User savedUser = userRepository.save(existingUser);

//        return UserMapper.mapToUserDTO(savedUser);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "Successfully Deleted";
    }


}
