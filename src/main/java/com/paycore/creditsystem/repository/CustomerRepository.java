package com.paycore.creditsystem.repository;

import com.paycore.creditsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByIdentityNumber(String identityNumber);

}

