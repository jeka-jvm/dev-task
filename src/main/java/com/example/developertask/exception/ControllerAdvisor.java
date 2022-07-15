package com.example.developertask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(value = { PasswordValueIncorrectException.class, AccountNameNotFoundException.class })
    public ResponseEntity<Object> handleUnauthorizedExceptions(RuntimeException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Incorrect account data");

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = { TokenInvalidException.class })
    public ResponseEntity<Object> handleTokenException(TokenInvalidException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Invalid token");

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnotherException(Exception ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Something went wrong");

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }


}
