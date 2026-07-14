package com.hyunhak.springboard.exception;

// 비밀번호가 일치하지 않을 때 발생시키는 사용자 정의 예외
public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
