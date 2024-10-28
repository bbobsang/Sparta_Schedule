package com.sparta.spartascheduler.exception;

// 사용자 삭제 불가능 예외 클래스
public class CannotDeleteException extends RuntimeException {
  public CannotDeleteException(String message) {
    super(message);
  }
}

