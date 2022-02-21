package com.paycore.creditsystem.service.iml;

import com.paycore.creditsystem.exception.NotFoundException;
import com.paycore.creditsystem.model.Customer;
import com.paycore.creditsystem.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

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

}