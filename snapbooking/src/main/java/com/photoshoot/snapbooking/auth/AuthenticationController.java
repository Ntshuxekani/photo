package com.photoshoot.snapbooking.auth;

import com.photoshoot.snapbooking.config.JwtService;
import com.photoshoot.snapbooking.entity.User; // Ensure this import is correct
import com.photoshoot.snapbooking.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {

  private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

  private final AuthenticationService service;
  private final JwtService jwtService;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @PostMapping("/register-client")
  @CrossOrigin(origins = "http://localhost:51262")
  public ResponseEntity<?> registerClient(@RequestBody AuthenticationRequest request) {
    // Registration logic here
    return ResponseEntity.ok().build();
  }

  @PostMapping("/register-photographer")
  @CrossOrigin(origins = "http://localhost:51262")
  public ResponseEntity<?> registerPhotographer(@RequestBody AuthenticationRequest request) {
    // Registration logic here
    return ResponseEntity.ok().build();
  }

  @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
    @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @GetMapping("/user/id")
  public ResponseEntity<Integer> getLoggedInUserId(HttpServletRequest request) {
    String token = request.getHeader("Authorization").substring(7);
    Integer userId = jwtService.extractUserId(token);
    return ResponseEntity.ok(userId);
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(service.getAllUsers());
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity<Map<String, String>> deleteUserById(@PathVariable Long id) {
    Map<String, String> response = new HashMap<>();
    try {
      service.deleteUserById(id);
      response.put("message", "User has been deleted successfully");
      return ResponseEntity.ok(response);
    } catch (RuntimeException e) {
      logger.error("Error deleting user with ID {}", id, e);
      response.put("error", "Error deleting user");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
