package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.exception.UserAlreadyExistsException;
import com.sparta.spartascheduler.util.JwtUtil;
import com.sparta.spartascheduler.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // PasswordEncoder 반환
    @Getter
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // Optional 을 사용하여 중복된 이메일 체크
    public User register(User user) {
        // 중복된 이메일 체크 및 예외 발생
        userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new UserAlreadyExistsException("중복된 이메일입니다."));


        // 비밀번호 암호화 및 역할 설정
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        // 사용자 저장
        return userRepository.save(user);
    }


    public String generateToken(String username, String role) {
        return jwtUtil.generateToken(username, role); // 역할 추가
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
