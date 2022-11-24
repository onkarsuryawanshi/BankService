package com.Bank;


import com.Bank.controller.bank.BankController;
import com.Bank.dto.AccountCreationResponse;
import com.Bank.models.AccountRequest;
import com.Bank.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class BankControllerTest {

    @Autowired
    private BankController bankController;


    /**
     * {
     *     "customerName":"NIketan Yadav",
     *     "customerDOB" :"19/02/2000",
     *     "customerAddress":"PUNE",
     *     "customerPanNumber":"KFPS123456",
     *     "customerAatharCardNumber":"123456789012",
     *     "customerPincode":"110001",
     *     "customerEmail":"onkarsuryawanshi@gmail.com"
     * }
     * */


    /**
     * {
     *     "customerId":2,
     *     "accountType":"current"
     * }
     * */
    User user = new User(1,"NIketan Yadav","19/02/2000","PUNE","KFPS123456","123456789012","110001","onkarsuryawanshi@gmail.com");
    @Test
    public void getListOfAllCustomerTest(){
        AccountRequest accountRequest = new AccountRequest(1,"current");
        BankController bankController1 = new BankController();

    }

    @Test
    public void createAccountTest(){
        AccountRequest accountRequest = new AccountRequest(1,"current");
//        AccountCreationResponse accountCreationResponse = bankController.createAccount(accountRequest);


    }
}
