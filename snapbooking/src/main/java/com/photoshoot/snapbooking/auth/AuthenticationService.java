package com.photoshoot.snapbooking.auth;

import com.photoshoot.snapbooking.config.JwtService;
import com.photoshoot.snapbooking.entity.User;
import com.photoshoot.snapbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtService jwtService;

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Cast to UserDetails
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    // Load user from repository if necessary (in case additional user info is needed)
    User user = userRepository.findByEmail(userDetails.getUsername());

    if (user == null) {
      throw new RuntimeException("User not found");
    }

    String token = jwtService.generateToken(userDetails);

    return new AuthenticationResponse(userDetails.getUsername(), token);
  }
}
