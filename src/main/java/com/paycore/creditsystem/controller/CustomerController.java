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

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/get")
    public ResponseEntity<?> getCustomer(@RequestParam Integer id){
        ResponseEntity<?> response=new ResponseEntity<>(customerService.getCustomer(id),HttpStatus.OK);
        return response ;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDto customer){
        ResponseEntity<?> response=new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
       return response ;
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
