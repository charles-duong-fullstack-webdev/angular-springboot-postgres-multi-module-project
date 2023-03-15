package com.radinfodesign.exception;

public class InvalidDataInputException extends Exception {
    public InvalidDataInputException(){
        super("Something about one or more data elements submitted violated business rules.");
    }
    public InvalidDataInputException(String message){
        super(message);
    }
}
