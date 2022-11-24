package com.Bank.globalObject;


import com.Bank.dto.AccountCreationResponse;
import com.Bank.dto.AmountTransferResponse;
import com.Bank.dto.TransferResponse;
import com.Bank.exceptions.AccountTypeIsNotValidException;
import com.Bank.exceptions.InsufficientAmount;
import com.Bank.exceptions.InvalidDepositAmount;
import com.Bank.models.Account;
import com.Bank.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class BankOperation {

    List<Account> allAccountList = new ArrayList<>();
    @Autowired
    private AccountCreationResponse accountCreationResponse;

    public AccountCreationResponse addUserAccount(User user, String accountType) {
        switch (accountType.toLowerCase()) {
            case "saving":
                return addUserToSavingAccount(user);
            case "current":
                return addUserToCurrentAccount(user);
            case "loan":
                return addUserToLoanAccount(user);
            default:
                throw new AccountTypeIsNotValidException("Please enter the correct account type");
        }
    }

    private AccountCreationResponse addUserToLoanAccount(User user) {
        Account account = new Account();
        List<Account> accountsForGivenUser = getAllAccountListForGivenUser(user);
        boolean isExits = isUserWithGivenAccountTypeExits(accountsForGivenUser,"loan");
        if (!isExits) {
            account.setAccountNumber(getAllCustomerList().size() + 1000);

            account.setAccountHolderName(user.getCustomerName());
            account.setAccountCreationDate(LocalDate.now());
            account.setAccountType("loan");
            account.setUser(user);
            account.setAccountBalance(0.0);
            accountCreationResponse.setAccountNumber(account.getAccountNumber());
            accountCreationResponse.setSuccessMessage("Hi " + account.getAccountHolderName() + "User Loan " +
                    "Account is successfully Created" +
                    "Balance:" + account.getAccountBalance() +
                    "Registered Phone Number" + account.getUser().getCustomerPanNumber());
            accountCreationResponse.setAdditionalInformation("Thank you for Choosing Us...");

        }
        else{
            accountCreationResponse.setSuccessMessage("error in creating account ....!");
            accountCreationResponse.setAdditionalInformation("Entered User already have loan account in Bank");
        }
        return accountCreationResponse;
    }

    private AccountCreationResponse addUserToCurrentAccount(User user) {
        Account account = new Account();
        List<Account> accountsForGivenUser = getAllAccountListForGivenUser(user);
        boolean isExits = isUserWithGivenAccountTypeExits(accountsForGivenUser,"loan");

        if(!isExits) {
            account.setAccountNumber(getAllCustomerList().size() + 1000);
            account.setAccountHolderName(user.getCustomerName());
            account.setAccountCreationDate(LocalDate.now());
            account.setAccountType("current");
            account.setUser(user);

            /*
             * setting initial amount as 2000 Rs. while creating an account
             * */
            account.setAccountBalance(2000.0);
            allAccountList.add(account);
            accountCreationResponse.setAccountNumber(account.getAccountNumber());
            accountCreationResponse.setSuccessMessage("Hi " + account.getAccountHolderName() + "Current Account " +
                    "Account is successfully Created" +
                    "Balance:" + account.getAccountBalance() +
                    "Registered Phone Number" + account.getUser().getCustomerPanNumber());
            accountCreationResponse.setAdditionalInformation("Thank you for Choosing Us...");
        }
        else{
            accountCreationResponse.setSuccessMessage("error in creating account ....!");
            accountCreationResponse.setAdditionalInformation("Entered User already have current account in Bank");
        }
        return accountCreationResponse;
    }

    private AccountCreationResponse addUserToSavingAccount(User user) {
        Account account = new Account();

        List<Account> accountsForGivenUser = getAllAccountListForGivenUser(user);
        boolean isExits = isUserWithGivenAccountTypeExits(accountsForGivenUser,"loan");

        if(!isExits) {
            account.setAccountNumber(getAllCustomerList().size() + 1000);
            account.setAccountHolderName(user.getCustomerName());
            account.setAccountCreationDate(LocalDate.now());
            /*
             * setting initial amount as 2000 Rs. while creating an account
             * */
            account.setAccountType("saving");
            account.setUser(user);
            account.setAccountBalance(2000.0);
            allAccountList.add(account);
            accountCreationResponse.setAccountNumber(account.getAccountNumber());
            accountCreationResponse.setSuccessMessage("Hi " + account.getAccountHolderName() + " saving Account " +
                    " Account is successfully Created" +
                    " Balance:" + account.getAccountBalance() +
                    " Registered Phone Number" + account.getUser().getCustomerPanNumber());
            accountCreationResponse.setAdditionalInformation("Thank you for Choosing Us...");
        }
        else{
            accountCreationResponse.setSuccessMessage("error in creating account ....!");
            accountCreationResponse.setAdditionalInformation("Entered User already have saving account in Bank");
        }
        return accountCreationResponse;
    }

    public List<Account> getAllCustomerList() {
        return allAccountList;
    }


    public List<Account> getAllAccountListForGivenUser(User user) {

        return getAllCustomerList()
                .stream()
                .filter(account -> account.getUser().getCustomerId() == user.getCustomerId())
                .collect(Collectors.toList());
    }

    public AmountTransferResponse depositAmount(Integer accountNumber, Double addAmount) {
        if (addAmount < 0) {
            throw new InvalidDepositAmount("entered invalid deposit amount");
        }
        List<Account> listOfAccount = allAccountList.stream()
                .map(account -> {
                    if (account.getAccountNumber().equals(accountNumber)) {
                        account.setAccountBalance(account.getAccountBalance() + addAmount);
                    }
                    return account;
                })
                .collect(Collectors.toList());

        allAccountList = listOfAccount;
        Double updatedAmount = null;
        for (Account account :
                allAccountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                updatedAmount = account.getAccountBalance();
            }
        }
        AmountTransferResponse amountDepositedResponse = new AmountTransferResponse();
        amountDepositedResponse.setAmount(addAmount);
        amountDepositedResponse.setUpdatedAmount(updatedAmount);
        amountDepositedResponse.setAccountNumber(accountNumber);
        amountDepositedResponse.setMessage(addAmount + " Successfully added to your Account  " + accountNumber + "\n" +
                "  Thank you ....");
        return amountDepositedResponse;
    }

    public AmountTransferResponse withdrawAmount(Integer accountNumber, Double amount) {
        List<Account> listOfAccount = allAccountList.stream()
                .map(account -> {
                    if (account.getAccountNumber().equals(accountNumber)) {
                        if (account.getAccountBalance() < amount) {
                            throw new InsufficientAmount("Insufficient Amount to withdraw ..... !");
                        }
                        account.setAccountBalance(account.getAccountBalance() - amount);
                    }
                    return account;
                })
                .collect(Collectors.toList());

        allAccountList = listOfAccount;
        Double updatedAmount = null;
        for (Account account :
                allAccountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                updatedAmount = account.getAccountBalance();
            }
        }
        AmountTransferResponse amountResponse = new AmountTransferResponse();
        amountResponse.setUpdatedAmount(updatedAmount);
        amountResponse.setAmount(amount);
        amountResponse.setAccountNumber(accountNumber);
        amountResponse.setMessage(amount + " Debited from your account " + accountNumber);
        return amountResponse;

    }

    public void updateCustomer(Integer accountNumber, String fieldName, String updatedValue) {

    }

    public TransferResponse transferMoney(Integer senderAccountNumber, Integer receiverAccountNumber, Double amount) {
        AmountTransferResponse response1 = withdrawAmount(senderAccountNumber, amount);
        AmountTransferResponse response2 = depositAmount(receiverAccountNumber, amount);
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setSenderAccountBalance(getCustomerAccountDetails(senderAccountNumber).getAccountBalance());
        transferResponse.setSendersAccountNumber(response1.getAccountNumber());
        transferResponse.setReceiverAccountNumber(response2.getAccountNumber());
        transferResponse.setMessage("Amount " + amount + "transfer from " + transferResponse.getSendersAccountNumber()
                + "to-> " + transferResponse.getReceiverAccountNumber() +
                "Available Balance is ==> " + transferResponse.getSenderAccountBalance() +
                " thank you ");
        transferResponse.setSuccess(true);
        return transferResponse;
    }


    public Account getCustomerAccountDetails(Integer accountNumber) {
        System.out.println(allAccountList);
        Account resAccount = null;
        for (Account account :
                allAccountList) {
            if (account.getAccountNumber() == (accountNumber)) {
                resAccount = account;
                break;
            }
        }

        System.out.println(resAccount);
        return resAccount;
    }

    public boolean isUserWithGivenAccountTypeExits(List<Account> accountsForUser, String accountType) {
        return accountsForUser.stream()
                .filter(account -> account.getAccountType().equals(accountType))
                .collect(Collectors.toList()).size() == 0 ?false:true;

    }
}

