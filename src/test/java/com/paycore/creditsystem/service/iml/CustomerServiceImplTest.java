package com.paycore.creditsystem.service.iml;

import com.paycore.creditsystem.exception.NotFoundException;
import com.paycore.creditsystem.model.CreditScore;
import com.paycore.creditsystem.model.Customer;
import com.paycore.creditsystem.model.mapper.CustomerMapper;
import com.paycore.creditsystem.repository.CustomerRepository;
import com.paycore.creditsystem.service.CreditScoreService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    CreditScoreService creditScoreService;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    void getCustomer_successful() {
        //init step
        Customer expectedCustomer=new Customer(1,"12345678","Betul","UYAR",7.500F,"05004004040",null,null);

        // stub - when step
        Optional<Customer> expectedOptionalCustomer=Optional.of(expectedCustomer);
        when(customerRepository.findById(1)).thenReturn(expectedOptionalCustomer);

        // then step
        Customer actualCustomer=customerService.getCustomer(1);

        // valid step
        assertEquals(expectedCustomer,actualCustomer);

    }
    @Test
    void getCustomer_not_found(){
        //stub - when step
        when(customerRepository.findById(1)).thenReturn(Optional.empty());

        //then step
        assertThrows(NotFoundException.class,
                () -> {
                Customer actualCustomer=customerService.getCustomer(1);
                }
                );
    }

    @Test
    void addCustomer_successful() {
        Customer expectedCustomer=new Customer(1,"12345678","Betul","UYAR",7.500F,"05004004040",null,null);
        Integer calculatedCreditScore=1000;
        CreditScore expectedCreditScore=new CreditScore(1,1000,expectedCustomer);

//        when(customerRepository.findById(any())).thenReturn(Optional.of(expectedCustomer));
//        when(creditScoreService.getCreditScoreByCustomerIdentityNumber(any())).thenReturn(expectedCreditScore.getCreditScore());

//        Customer actualCustomer=customerService.getCustomer(1);
//        assertEquals(expectedCustomer,actualCustomer);
//        when(customerRepository.save(expectedCustomer)).thenReturn(expectedCustomer);
//
//        customerService.addCustomer(CustomerMapper.toDto(expectedCustomer));
//        Customer byId=customerRepository.getById(1);
//        Assert.assertEquals(expectedCustomer,byId);
//
//        verify(customerRepository,times(1)).save(expectedCustomer);


//        Passenger expectedPassenger = new Passenger(1, "Passenger1", "Lastname1", "Male", 25, "05554443322", "passenger1@mail.com");
//
//        // stub - when
//        when(passengerRepository.save(expectedPassenger)).thenReturn(expectedPassenger);
//
//        // then
//        passengerService.addPassenger(expectedPassenger);
////        Passenger byId = passengerRepository.getById(1);
////
////        Assert.assertEquals(expectedPassenger, byId);
//
//        verify(passengerRepository, times(1)).save(expectedPassenger);

    }
}