package com.paycore.creditsystem.controller;


import com.paycore.creditsystem.service.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/credit_application")
public class CreditApplicationController {

    private final CreditApplicationService creditApplicationService;

    @PostMapping(value = "/add")
    public void addCreditApplication(@Valid @RequestBody String identityNumber){
        creditApplicationService.addCreditApplication(identityNumber);
    }
}
