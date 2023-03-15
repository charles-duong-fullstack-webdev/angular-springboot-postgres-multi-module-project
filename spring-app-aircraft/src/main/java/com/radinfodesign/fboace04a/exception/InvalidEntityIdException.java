package com.radinfodesign.exception;

public class InvalidEntityIdException extends Exception {
    public InvalidEntityIdException (){
        super("An identifier value was provided that doesn't match any instance of the business entity or row in the database table.");
    }
    public InvalidEntityIdException (String message){
        super(message);
    }
}
