package com.paycore.creditsystem.controller;


import com.paycore.creditsystem.model.CreditApplication;
import com.paycore.creditsystem.service.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/credit_application")
public class CreditApplicationController {

    private final CreditApplicationService creditApplicationService;

    @GetMapping(value = "/get_credit_application")
    public ResponseEntity<?> getCreditApplication(@Valid @RequestParam String identityNumber) {
        ResponseEntity<?> response;
        try{
            response=new ResponseEntity<>(creditApplicationService.getCreditApplication(identityNumber),HttpStatus.OK);
        } catch (Exception exception){
            response=new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addCreditApplication(@Valid @RequestBody String identityNumber){
        ResponseEntity<?> response;
        try {
            creditApplicationService.addCreditApplication(identityNumber);
            response=new ResponseEntity<>("Success! Your Credit Application added.",HttpStatus.OK);
        } catch (Exception exception){
            response=new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
