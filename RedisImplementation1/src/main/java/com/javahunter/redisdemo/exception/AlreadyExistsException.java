package com.javahunter.redisdemo.exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String  message){
        super(message);
    }
}
