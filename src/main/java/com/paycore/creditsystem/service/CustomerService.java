package com.paycore.creditsystem.service;

import com.paycore.creditsystem.model.Customer;
import com.paycore.creditsystem.model.dto.CustomerDto;

public interface CustomerService {

    Customer getCustomer(Integer id);

    Customer addCustomer(CustomerDto customer);

    void deleteCustomer(Integer id);

    void updateCustomer(Integer id,Customer customer);

    Customer getCustomerByIdentityNumber(String identityNumber);
}
