package com.paycore.creditsystem.repository;

import com.paycore.creditsystem.model.CreditApplication;
import com.paycore.creditsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication,Integer> {

    List<CreditApplication> findByCustomer(Customer customer);
}
