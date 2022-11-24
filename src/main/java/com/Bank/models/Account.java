package com.Bank.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private Integer accountNumber;

    private String accountHolderName;

    private LocalDate accountCreationDate;

    private String accountType;

//    private String accountCurrency = "INR";

//    private String branchCode;
//
//    private String branchName;
//
//    private String branchCity;
//
//    private String branchState;
//
//    private String branchCountry;
//
//    private String branchPincode;
//
//    private String branchContact;
//
//    private String ifscCode;

    private Double accountBalance;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "bank_user_id")
    private User user;
}
