package com.sparta.spartascheduler.filter;

import com.sparta.spartascheduler.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    public JwtAuthorizationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // "Bearer " 제거
            if (!jwtUtil.isTokenExpired(token)) {
                String username = jwtUtil.extractUsername(token);
                Claims claims = jwtUtil.extractClaims(token);
                // 권한 확인
                String role = claims.get("role", String.class);

                if (role != null) {
                    GrantedAuthority authority = new SimpleGrantedAuthority(role);
                    Authentication auth = new UsernamePasswordAuthenticationToken(username, null, Collections.singleton(authority));
                    SecurityContextHolder.getContext().setAuthentication(auth); // SecurityContext에 인증 정보 저장
                } else {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
                    return; // 권한이 없으면 요청 처리 중단
                }
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expired");
                return; // 만료된 토큰
            }
        }
        filterChain.doFilter(request, response); // 필터 체인의 다음 필터로 이동
    }
}