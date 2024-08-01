package com.photoshoot.snapbooking.auth;

import com.photoshoot.snapbooking.service.UserService;
import com.photoshoot.snapbooking.service.dtos.RegistrationRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/login")
  public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
    return authenticationService.authenticate(request);
  }

  @PostMapping("/logout")
  public ResponseEntity<?> logout(HttpServletRequest request) {
    // Perform actions if you are implementing token blacklisting
    // For now, we'll just return a success message
    return ResponseEntity.ok("Logged out successfully");
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
    // Check if user already exists
    if (userService.findByEmail(request.getEmail()) != null) {
      return ResponseEntity.badRequest().body("User already exists");
    }

    // Create a new user
    User newUser = new User();
    newUser.setEmail(request.getEmail());
    newUser.setPassword(passwordEncoder.encode(request.getPassword())); // Hash the password
    newUser.setName(request.getName());
    newUser.setSurname(request.getSurname());
    newUser.setRole("USER"); // Set a default role or customize as needed

    userService.saveUser(newUser);

    return ResponseEntity.ok("User registered successfully");
  }
}
