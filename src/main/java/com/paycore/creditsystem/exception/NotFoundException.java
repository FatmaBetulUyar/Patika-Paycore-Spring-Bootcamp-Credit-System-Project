package com.paycore.creditsystem.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message+" Not Found");
    }
}
