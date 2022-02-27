package com.paycore.creditsystem.service.iml;

import com.paycore.creditsystem.exception.InsufficientCreditScoreException;
import com.paycore.creditsystem.exception.NotFoundException;
import com.paycore.creditsystem.model.CreditApplication;
import com.paycore.creditsystem.model.Customer;
import com.paycore.creditsystem.model.dto.ResponseDto;
import com.paycore.creditsystem.model.mapper.CreditApplicationMapper;
import com.paycore.creditsystem.model.mapper.CustomerMapper;
import com.paycore.creditsystem.repository.CreditApplicationRepository;
import com.paycore.creditsystem.service.CreditScoreService;
import com.paycore.creditsystem.service.CreditApplicationService;
import com.paycore.creditsystem.service.CustomerService;
import com.paycore.creditsystem.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditApplicationServiceImpl implements CreditApplicationService {

    private final CustomerService customerService;
    private final CreditApplicationRepository creditApplicationRepository;
    private final MessageService messageService;
    private final CreditScoreService creditScoreService;

    @Override
    public List<CreditApplication> getCreditApplication(String identityNumber) {
        List<CreditApplication>creditApplications= creditApplicationRepository.findByCustomer_IdentityNumber(identityNumber);
        if(creditApplications.size()==0){
            throw new NotFoundException("Customer that has this identity number");
        }
        return creditApplications;
    }

    @Override
    public boolean addCreditApplication(String identityNumber) {
        Customer customer=customerService.getCustomerByIdentityNumber(identityNumber);
        CreditApplication creditApplication=CreditApplicationMapper.mapCreditApplication(customer,calculateCreditLimit(customer),true);

        creditApplication= creditApplicationRepository.save(creditApplication);

        if(!creditApplication.isStatus()){
            messageService.sendMessage(customer.getPhone(),false,creditApplication.getCreditLimit());
        }
        else{
            messageService.sendMessage(customer.getPhone(),true,creditApplication.getCreditLimit());
        }
        List<CreditApplication> credits=customerService.getCustomerByIdentityNumber(identityNumber).getCredits();
        credits.add(creditApplication);
        customer.setCredits(credits);
        customerService.updateCustomer(customer.getId(),customer);
        return true;
    }

    private Float calculateCreditLimit(Customer customer){
        Integer creditScore=creditScoreService.getCreditScoreByCustomerIdentityNumber(customer.getIdentityNumber());
        Float limit=0.0F;
        if(creditScore<500){
         //   new InsufficientCreditScoreException();
            return limit;
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
