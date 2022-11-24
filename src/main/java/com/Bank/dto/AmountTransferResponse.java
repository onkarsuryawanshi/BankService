package com.Bank.dto;

import lombok.Data;

@Data
public class AmountTransferResponse {
    private Double amount;
    private Double updatedAmount;
    private Integer accountNumber;
    private String message;
}
