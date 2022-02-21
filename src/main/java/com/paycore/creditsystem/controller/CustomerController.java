package com.paycore.creditsystem.controller;

import com.paycore.creditsystem.model.Customer;
import com.paycore.creditsystem.model.dto.CustomerDto;
import com.paycore.creditsystem.model.mapper.CustomerMapper;
import com.paycore.creditsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/get")
    public Customer getCustomer(Integer id){
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDto customer){
       return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK) ;
    }

    @DeleteMapping(value = "/delete")
    public void deleteCustomer(Integer id){
        customerService.deleteCustomer(id);
    }

    @PutMapping("/update")
    public void updateCustomer(Integer id,Customer customer){
        customerService.updateCustomer(id,customer);
    }
}
