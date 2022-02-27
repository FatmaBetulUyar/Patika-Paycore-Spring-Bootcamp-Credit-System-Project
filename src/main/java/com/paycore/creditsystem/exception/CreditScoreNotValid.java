package com.paycore.creditsystem.exception;

public class CreditScoreNotValid extends RuntimeException{
    public CreditScoreNotValid() {
        super(" Credit Score can not be negative number !");
    }
}

