package com.sparta.spartascheduler.controller;

import com.sparta.spartascheduler.dto.UserDto;
import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User registeredUser = userService.register(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        User user = userService.findByEmail(userDto.getEmail());
        if (user != null && userService.getPasswordEncoder().matches(userDto.getPassword(), user.getPassword())) {
            String token = userService.generateToken(user.getUsername(), user.getRole());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
