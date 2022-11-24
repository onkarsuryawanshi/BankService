package com.Bank.controller.bank;

import com.Bank.dto.AccountCreationResponse;
import com.Bank.dto.AmountTransferResponse;
import com.Bank.dto.TransferResponse;
import com.Bank.models.Account;
import com.Bank.models.AccountRequest;
import com.Bank.services.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bankServices")
public class BankController {
    @Autowired
    private BankService bankService;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountCreationResponse> createAccount(@Valid @RequestBody AccountRequest accountRequest) {
        AccountCreationResponse response = bankService.createAccount(accountRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping(value = "/getListOfAllCustomers")
    private ResponseEntity<List<Account>> getListOfAllCustomer() {
        List<Account> account = bankService.getListOfAllCustomer();
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<AmountTransferResponse> depositAmount(@Valid @RequestParam Integer accountNumber, @RequestParam Double amount) {
        AmountTransferResponse response = bankService.depositAmount(accountNumber,amount);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    private ResponseEntity<AmountTransferResponse> withdrawAmount(@Valid @RequestParam Integer accountNumber , @RequestParam Double amount){
        AmountTransferResponse response =  bankService.withdrawAmount(accountNumber,amount);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/updateCustomer")
    public void updateCustomer(@Valid @RequestParam Integer accountNumber ,@RequestParam String fieldName , @RequestParam String updatedValue){
        bankService.updateCustomer(accountNumber,fieldName,updatedValue);
    }


    @PostMapping("/transferMoney")
    public ResponseEntity<TransferResponse> transferMoney(@Valid @RequestParam Integer senderAccountNumber , @RequestParam Integer receiverAccountNumber, @RequestParam Double amount){
        TransferResponse response =  bankService.transferMoney(senderAccountNumber,receiverAccountNumber,amount);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
