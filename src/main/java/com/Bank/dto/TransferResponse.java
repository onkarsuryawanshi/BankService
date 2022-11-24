package com.Bank.dto;

import lombok.Data;

@Data
public class TransferResponse{
    private Integer sendersAccountNumber;
    private Integer receiverAccountNumber;
    private Double senderAccountBalance;
    private String message;
    private boolean isSuccess;
}
