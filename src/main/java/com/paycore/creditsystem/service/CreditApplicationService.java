package com.paycore.creditsystem.service;

import com.paycore.creditsystem.model.CreditApplication;

import java.util.List;

public interface CreditApplicationService {

    List<CreditApplication> getCreditApplication(String identityNumber);

    void addCreditApplication(String identityNumber);
}
