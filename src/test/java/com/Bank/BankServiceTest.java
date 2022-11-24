package com.Bank;


import com.Bank.dto.AmountTransferResponse;
import com.Bank.globalObject.BankOperation;
import com.Bank.globalObject.UserOperation;
import com.Bank.models.Account;
import com.Bank.models.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankServiceTest {
    /***
     * {
     *     "customerName":"NIketan Yadav",
     *     "customerDOB" :"19/02/2000",
     *     "customerAddress":"PUNE",
     *     "customerPanNumber":"KFPS123456",
     *     "customerAatharCardNumber":"123456789012",
     *     "customerPincode":"110001",
     *     "customerEmail":"onkarsuryawanshi@gmail.com"
     * }
     */
    User user = new User(1, "NIketan Yadav", "19/02/2000", "PUNE", "KFPS123456", "123456789012", "110001", "onkarsuryawanshi@gmail.com");
    Account account = new Account(1000, "onkar", LocalDate.now(), "saving", 2000.00, user);
    @Autowired
    private BankOperation bankOperation;
    @Autowired
    private UserOperation userOperation;

    @Test
    public void getListOfAllCustomerTest() {
        List<Account> accounts = bankOperation.getAllCustomerList();
    }

    @Test
    public void depositAmountTest() {
        userOperation.addUser(user);
        bankOperation.addUserAccount(user, "saving");
        Double beforeBalance = account.getAccountBalance();
        AmountTransferResponse response = bankOperation.depositAmount(1000, 200.00);
        Double currentBalance = response.getUpdatedAmount();
        Assertions.assertEquals(beforeBalance + 200.00, currentBalance);
    }


    @Test
    public void withdrawTest() {
        userOperation.addUser(user);
        bankOperation.addUserAccount(user, "saving");
        Double beforeBalance = account.getAccountBalance();
        AmountTransferResponse response = bankOperation.withdrawAmount(1000, 200.00);
        Double currentBalance = response.getUpdatedAmount();
        Assertions.assertEquals(beforeBalance - 200.00, currentBalance);
    }
}
