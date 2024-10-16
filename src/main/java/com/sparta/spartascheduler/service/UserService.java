package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.exception.UserAlreadyExistsException;
import com.sparta.spartascheduler.util.JwtUtil;
import com.sparta.spartascheduler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("중복된 이메일입니다.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    public String generateToken(String username, String role) {
        return jwtUtil.generateToken(username, role); // 역할 추가
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder; // PasswordEncoder 반환
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
