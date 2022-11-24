package com.Bank.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Component
public class AccountCreationResponse {
    private Integer accountNumber;
    private String successMessage;
    private String additionalInformation;
}
