package com.db.h2.console.errorhandler;

public class NoSuchLoginExistsException extends RuntimeException {
    private String message;

    public NoSuchLoginExistsException() {
    }

    public NoSuchLoginExistsException(String msg) {
        super(msg);
        this.message = msg;
    }

}
