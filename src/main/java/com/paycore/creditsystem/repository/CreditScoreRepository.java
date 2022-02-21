package com.paycore.creditsystem.repository;

import com.paycore.creditsystem.model.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore,Integer> {

    CreditScore findCreditScoreByCustomer_IdentityNumber(String identity);
}
