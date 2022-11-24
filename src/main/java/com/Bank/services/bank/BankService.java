package com.Bank.services.bank;

import com.Bank.dto.AccountCreationResponse;
import com.Bank.dto.AmountTransferResponse;
import com.Bank.dto.TransferResponse;
import com.Bank.models.Account;
import com.Bank.models.AccountRequest;
import com.Bank.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {
    AccountCreationResponse createAccount(AccountRequest accountRequest);

    List<Account> getListOfAllCustomer();

    AmountTransferResponse depositAmount(Integer accountNumber, Double amount);

    AmountTransferResponse withdrawAmount(Integer accountNumber, Double amount);

    void updateCustomer(Integer accountNumber , String fieldName, String updatedValue);

    TransferResponse transferMoney(Integer senderAccountNumber, Integer receiverAccountNumber, Double amount);

    Account getAccountDetailsFromAccountNumber(Integer accountNumber);

    List<Account> getAllAccountListForGivenUser(User user);


    boolean isUserWithGivenAccountExitsOrNot(List<Account> accounts,String accountType);

}
