package com.example.resumegeneratorbackend.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameOrEmailExistException extends RuntimeException {

    public UsernameOrEmailExistException(String message) {
        super(message);
    }
}
