package com.paycore.creditsystem.model.mapper;

import com.paycore.creditsystem.model.CreditApplication;
import com.paycore.creditsystem.model.Customer;
import com.paycore.creditsystem.model.dto.CustomerDto;

public class CreditApplicationMapper {

    public static CreditApplication mapCreditApplication(Customer customer,Float creditLimit, boolean status ){
        CreditApplication creditApplication1=new CreditApplication();
        creditApplication1.setStatus(status);
        creditApplication1.setCreditLimit(creditLimit);
        creditApplication1.setCustomer(customer);

        if(creditApplication1.getCreditLimit()==0){
            creditApplication1.setStatus(false);
        }
        return creditApplication1;
    }


}
