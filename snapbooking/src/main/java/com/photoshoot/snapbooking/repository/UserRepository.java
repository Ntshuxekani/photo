package com.photoshoot.snapbooking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}

