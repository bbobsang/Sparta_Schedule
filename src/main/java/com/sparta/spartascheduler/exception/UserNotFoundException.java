package com.sparta.spartascheduler.exception;

// 사용자 미발견 예외 클래스
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
