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
    public ResponseEntity<?> getCustomer(Integer id){
        ResponseEntity<?> response;
        try{
            response=new ResponseEntity<>(customerService.getCustomer(id),HttpStatus.OK);
        }catch(Exception exception){
            response=new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response ;
    }



    @PostMapping(value = "/add")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDto customer){
        ResponseEntity<?> response;
        try{
            response=new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
        }catch (Exception exception){
            response=new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
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
