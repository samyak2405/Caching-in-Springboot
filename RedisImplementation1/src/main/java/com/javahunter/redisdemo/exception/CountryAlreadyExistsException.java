package com.javahunter.redisdemo.exception;

public class CountryAlreadyExistsException extends AlreadyExistsException{
    public CountryAlreadyExistsException(String message){
        super(message);
    }
}
