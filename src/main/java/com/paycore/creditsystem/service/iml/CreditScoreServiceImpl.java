package com.paycore.creditsystem.service.iml;

import com.paycore.creditsystem.model.CreditScore;
import com.paycore.creditsystem.model.Customer;
import com.paycore.creditsystem.repository.CreditScoreRepository;
import com.paycore.creditsystem.service.CreditScoreService;
import com.paycore.creditsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditScoreServiceImpl implements CreditScoreService {

    private final CreditScoreRepository creditScoreRepository;

    @Override
    public CreditScore addCreditScore(CreditScore creditScore) {
        return creditScoreRepository.save(creditScore);
    }

    @Override
    public Integer calculateCreditScore() {
        int creditScore = (int) ((Math.random() * (2000 - 0)) + 0);
        return creditScore;
    }

    @Override
    public Integer getCreditScoreByCustomerIdentityNumber(String identityNumber) {
        CreditScore creditScore=creditScoreRepository.findCreditScoreByCustomer_IdentityNumber(identityNumber);
        return creditScore.getCreditScore();
    }
}
