package com.SpringBootwebservice.Springboot_restfull_webService.repository;

import com.SpringBootwebservice.Springboot_restfull_webService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
