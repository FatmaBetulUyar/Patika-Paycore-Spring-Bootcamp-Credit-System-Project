package com.paycore.creditsystem.exception;

public class IdentityNumberAlreadyExistException extends RuntimeException{
    public IdentityNumberAlreadyExistException() {
        super("Sorry,this identity number already exists. ");
    }
}