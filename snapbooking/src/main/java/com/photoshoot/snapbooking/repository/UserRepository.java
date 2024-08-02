package com.photoshoot.snapbooking.repository;

import com.photoshoot.snapbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);


  Optional<User> findByResetToken(String resetToken);
}
