package com.db.h2.console.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler
    public ResponseEntity<Object> handleAuthenticationException(LoginAlreadyExistsException e) {
        // do what you want with e
        return new ResponseEntity<>("Login already exists", HttpStatus.OK);
    }

}
