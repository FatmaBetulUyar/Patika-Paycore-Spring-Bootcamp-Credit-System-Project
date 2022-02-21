package com.paycore.creditsystem.service.iml;

import com.paycore.creditsystem.exception.InsufficientCreditScoreException;
import com.paycore.creditsystem.model.CreditApplication;
import com.paycore.creditsystem.model.Customer;
import com.paycore.creditsystem.model.mapper.CustomerMapper;
import com.paycore.creditsystem.repository.CreditApplicationRepository;
import com.paycore.creditsystem.service.CreditScoreService;
import com.paycore.creditsystem.service.CreditApplicationService;
import com.paycore.creditsystem.service.CustomerService;
import com.paycore.creditsystem.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditApplicationServiceImpl implements CreditApplicationService {

    private final CustomerService customerService;
    private final CreditApplicationRepository creditApplicationRepository;
    private final MessageService messageService;
    private final CreditScoreService creditScoreService;

    @Override
    public void addCreditApplication(String identityNumber) {
        Customer customer=customerService.getCustomerByIdentityNumber(identityNumber);
        CreditApplication creditApplication=new CreditApplication();

        creditApplication.setCreditLimit(calculateCreditLimit(customer));
        creditApplication.setStatus(true);
        creditApplication.setCustomer(customer);
        creditApplication= creditApplicationRepository.save(creditApplication);
        if(creditApplication.getCreditLimit()==0){
            creditApplication.setStatus(false);
            messageService.sendMessage(customer.getPhone(),"");
            new InsufficientCreditScoreException();
        }
        List<CreditApplication> credits=customerService.getCustomerByIdentityNumber(identityNumber).getCredits();
        credits.add(creditApplication);
        customer.setCredits(credits);
        customerService.updateCustomer(customer.getId(),customer);
    }



    public Float calculateCreditLimit(Customer customer){
        Integer creditScore=creditScoreService.getCreditScoreByCustomerIdentityNumber(customer.getIdentityNumber());
        Float limit=0.0F;
        if(creditScore<500){
            new InsufficientCreditScoreException();
        }
        else if(creditScore>500 && creditScore<1000){
           if(customer.getMonthlyIncome()<5000){
               limit=10000.0F;
           }
           else{
               limit=20000.0F;
           }
        }
        else {
           limit=customer.getMonthlyIncome()*4;
        }
        return limit;
    }
}
