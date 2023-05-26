package com.db.h2.console.errorhandler;

public class LoginAlreadyExistsException extends RuntimeException {
    private String message;

    public LoginAlreadyExistsException() {
    }

    public LoginAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }

}
