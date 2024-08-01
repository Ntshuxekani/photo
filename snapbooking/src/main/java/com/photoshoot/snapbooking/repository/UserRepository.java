package com.photoshoot.snapbooking.repository;

import com.photoshoot.snapbooking.entity.User;  // Correct import
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}

