package com.photoshoot.snapbooking.auth;


public class AuthenticationResponse {
  private String email;
  private String token;

  // Default constructor
  public AuthenticationResponse() {
  }

  // Constructor with parameters
  public AuthenticationResponse(String email, String token) {
    this.email = email;
    this.token = token;
  }

  // Getter and setter methods
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}

