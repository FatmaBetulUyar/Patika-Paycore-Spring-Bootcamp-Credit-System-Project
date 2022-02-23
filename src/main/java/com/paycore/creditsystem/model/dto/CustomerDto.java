package com.paycore.creditsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {


    @Column(unique = true)
    private String identityNumber;

    private String firstName;

    private String lastName;

    private Float monthlyIncome;

    private String phone;
}
