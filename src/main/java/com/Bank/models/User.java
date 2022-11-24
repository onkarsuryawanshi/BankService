package com.Bank.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer customerId;
    @NotBlank(message = "Customer Name cannot blank")
    private String customerName;

    @NotBlank(message = "Customer DOB cannot blank")
    private String customerDOB;

    @NotBlank(message = "Customer Address cannot blank")
    private String customerAddress;

    @Size(max = 10, min = 10 , message = "Invalid pan card Number entered")
    @NotBlank(message = "Customer PanCardNumber cannot blank")
    private String customerPanNumber;

    @Size(max = 12,min = 12, message = "Invalid AadharCard Details")
    @NotBlank(message = "Customer AadharCard cannot blank")
    private String customerAatharCardNumber;

    @Size(max = 6, min = 6, message = "invalid Pincode ")
    private String customerPincode;

    private String customerEmail;

}
