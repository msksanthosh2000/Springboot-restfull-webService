package com.SpringBootwebservice.Springboot_restfull_webService.repository;

import com.SpringBootwebservice.Springboot_restfull_webService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
