package com.paycore.creditsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="identity_number",unique = true)
    private String identityNumber;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="monthly_income")
    private Float monthlyIncome;

    @Column(name ="phone")
    private String phone;

    @Column(name ="credit_score")
    private Integer creditScore;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.MERGE)
    private List<Credit> credits;

    //creditle bağlantısını yap
}
