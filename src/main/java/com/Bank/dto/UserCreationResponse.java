package com.Bank.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Component
public class UserCreationResponse {
    private Integer customer_id;
    private String successMessage;
    private String additionalInformation;
}
