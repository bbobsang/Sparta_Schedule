package com.sparta.spartascheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice: 모든 컨트롤러에서 발생하는 예외를 전역적으로 처리할 수 있도록 설정
@ControllerAdvice
public class GlobalExceptionHandler {

    // 에러 응답을 위한 내부 클래스
    static class ErrorResponse {
        private String errorCode; // 에러 코드
        private String errorMessage; // 에러 메시지

        public ErrorResponse(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        // Getter 메서드
        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    // InvalidEmailException 발생 시 이 메서드가 호출됨
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEmail(InvalidEmailException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ERR001", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // InvalidPasswordException 발생 시 이 메서드가 호출됨
    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPassword(InvalidPasswordException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ERR002", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // UserAlreadyExistsException 발생 시 이 메서드가 호출됨
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ERR003", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    // CommentNotFoundException 발생 시 이 메서드가 호출됨
    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCommentNotFound(CommentNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ERR004", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    // CannotDeleteException 발생 시 이 메서드가 호출됨
    @ExceptionHandler(CannotDeleteException.class)
    public ResponseEntity<ErrorResponse> handleCannotDelete(CannotDeleteException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ERR005", ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }

    // WeatherApiException 발생 시 이 메서드가 호출됨
    @ExceptionHandler(WeatherApiException.class)
    public ResponseEntity<ErrorResponse> handleWeatherApiException(WeatherApiException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ERR006", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // 기타 모든 예외를 처리하는 기본 핸들러
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("ERR999", "알 수 없는 오류가 발생했습니다.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
