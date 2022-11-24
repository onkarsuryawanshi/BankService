package com.Bank.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    @NonNull()
    private Integer customerId;
    @NotBlank(message = "entered account type is null")
    private String accountType;
}
