package com.photoshoot.snapbooking.auth;


public class AuthenticationRequest {
  private String email;
  private String password;

  // Default constructor
  public AuthenticationRequest() {
  }

  // Constructor with parameters
  public AuthenticationRequest(String email, String password) {
    this.email = email;
    this.password = password;
  }

  // Getter and setter methods
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

