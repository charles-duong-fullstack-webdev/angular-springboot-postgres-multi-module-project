package com.db.h2.console.errorhandler;

public class LoginNotFoundException extends RuntimeException {

    public LoginNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public LoginNotFoundException(String message) {
        super(message);
    }
    // ...
}


