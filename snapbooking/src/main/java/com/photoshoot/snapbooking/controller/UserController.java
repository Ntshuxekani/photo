package com.photoshoot.snapbooking.controller;

import com.photoshoot.snapbooking.entity.User;  // Correct import
import com.photoshoot.snapbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public User registerUser(@RequestBody User user) {
    return userService.registerUser(user);
  }

  @GetMapping("/{email}")
  public User getUserByEmail(@PathVariable String email) {
    return userService.findByEmail(email);
  }
}
