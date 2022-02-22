package com.paycore.creditsystem.service;

import com.paycore.creditsystem.model.CreditScore;

public interface CreditScoreService {

    CreditScore addCreditScore(CreditScore creditScore);

    CreditScore calculateCreditScore();

    Integer getCreditScoreByCustomerIdentityNumber(String identityNumber);
}
