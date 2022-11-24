package com.Bank.services.bank;

import com.Bank.dto.AccountCreationResponse;
import com.Bank.dto.AmountTransferResponse;
import com.Bank.dto.TransferResponse;
import com.Bank.globalObject.BankOperation;
import com.Bank.globalObject.UserOperation;
import com.Bank.models.Account;
import com.Bank.models.AccountRequest;
import com.Bank.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankOperation bankOperation;

    @Autowired
    private UserOperation userOperation;
    @Override
    public AccountCreationResponse createAccount(AccountRequest accountRequest) {
        User user = userOperation.getUserById(accountRequest.getCustomerId());
        return bankOperation.addUserAccount(user,accountRequest.getAccountType());
    }

    @Override
    public List<Account> getListOfAllCustomer() {
        return bankOperation.getAllCustomerList();
    }


    @Override
    public AmountTransferResponse depositAmount(Integer accountNumber, Double amount) {
             return bankOperation.depositAmount(accountNumber,amount);
    }

    @Override
    public AmountTransferResponse withdrawAmount(Integer accountNumber, Double amount) {
        return bankOperation.withdrawAmount(accountNumber,amount);
    }

    @Override
    public void updateCustomer(Integer accountNumber, String fieldName, String updatedValue) {
        bankOperation.updateCustomer(accountNumber, fieldName,updatedValue);
    }

    @Override
    public TransferResponse transferMoney(Integer senderAccountNumber, Integer receiverAccountNumber, Double amount) {
        return  bankOperation.transferMoney(senderAccountNumber,receiverAccountNumber,amount);
    }

    @Override
    public Account getAccountDetailsFromAccountNumber(Integer accountNumber) {
        return bankOperation.getCustomerAccountDetails(accountNumber);
    }

    @Override
    public List<Account> getAllAccountListForGivenUser(User user) {
        return bankOperation.getAllAccountListForGivenUser(user);
    }

    @Override
    public boolean isUserWithGivenAccountExitsOrNot(List<Account> accounts, String accountType) {
        return bankOperation.isUserWithGivenAccountTypeExits(accounts,accountType);
    }


}