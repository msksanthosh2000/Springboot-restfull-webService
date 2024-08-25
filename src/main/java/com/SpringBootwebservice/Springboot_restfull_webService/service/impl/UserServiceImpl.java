package com.SpringBootwebservice.Springboot_restfull_webService.service.impl;

import com.SpringBootwebservice.Springboot_restfull_webService.entity.User;
import com.SpringBootwebservice.Springboot_restfull_webService.repository.UserRepository;
import com.SpringBootwebservice.Springboot_restfull_webService.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
