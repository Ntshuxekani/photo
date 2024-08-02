package com.photoshoot.snapbooking.auth;

import com.photoshoot.snapbooking.entity.Role;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
  private String email;
  private String name;
  private String password;
  private String surname;
 private Role role;


}

