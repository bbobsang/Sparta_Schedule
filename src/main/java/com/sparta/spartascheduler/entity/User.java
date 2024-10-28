package com.sparta.spartascheduler.entity;

import com.sparta.spartascheduler.exception.InvalidEmailException;
import com.sparta.spartascheduler.exception.InvalidPasswordException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password; // 비밀번호 필드 추가

    private String role; // 권한 필드 추가 (USER, ADMIN)

    // 유효성 검사 추가
    public void validate() throws InvalidEmailException, InvalidPasswordException {
        validateEmail(this.email);
        validatePassword(this.password);
    }

    // 이메일 유효성 검사
    public void validateEmail(String email) throws InvalidEmailException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new InvalidEmailException("유효하지 않은 이메일 형식입니다.");
        }
    }

    // 비밀번호 유효성 검사
    public void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("비밀번호는 최소 8자 이상이어야 합니다.");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new InvalidPasswordException("비밀번호에는 최소한 하나의 숫자가 포함되어야 합니다.");
        }
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/`~].*")) {
            throw new InvalidPasswordException("비밀번호에는 최소한 하나의 특수 문자가 포함되어야 합니다.");
        }
    }
}
