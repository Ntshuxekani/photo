package com.photoshoot.snapbooking.auth;

import com.photoshoot.snapbooking.entity.Role;
import com.photoshoot.snapbooking.entity.User; // Ensure this import is correct
import com.photoshoot.snapbooking.repository.UserRepository;
import com.photoshoot.snapbooking.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    User user = User.builder()
      .firstname(request.getName())
      .lastname(request.getSurname())
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .role(Role.valueOf(request.getRole())) // Assign role from the request
      .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user, user.getId(), user.getRole());
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );
    var user = repository.findByEmail(request.getEmail())
      .orElseThrow(() -> new RuntimeException("User not found")); // Handle Optional correctly
    var jwtToken = jwtService.generateToken(user, user.getId(), user.getRole());
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .message("Login Successful")
      .status("OK")
      .build();
  }

  public String getLoggedInUserEmail() {
    var authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
      return ((UserDetails) authentication.getPrincipal()).getUsername();
    }
    return null;
  }

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public void deleteUserById(Long userId) { // Changed Integer to Long
    var user = repository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    repository.delete(user);
  }
}
