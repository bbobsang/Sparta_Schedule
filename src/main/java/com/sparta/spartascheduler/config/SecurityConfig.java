package com.sparta.spartascheduler.config;

import com.sparta.spartascheduler.filter.JwtAuthorizationFilter;
import com.sparta.spartascheduler.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtUtil jwtUtil) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN 권한 필요
                        .requestMatchers("/api/auth/**").permitAll() // 인증 없이 접근 가능
                        .anyRequest().authenticated() // 나머지 요청은 인증 필요
                )
                .addFilterBefore(jwtAuthorizationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class); // JWT 필터 추가
        return http.build();
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter(JwtUtil jwtUtil) {
        return new JwtAuthorizationFilter(jwtUtil);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}