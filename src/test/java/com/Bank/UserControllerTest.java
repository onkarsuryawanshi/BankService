package com.Bank;

import com.Bank.controller.user.UserController;
import com.Bank.dto.UserCreationResponse;
import com.Bank.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;

    User user = new User(1, "NIketan Yadav", "19/02/2000", "PUNE", "KFPS123456", "123456789012", "110001", "onkarsuryawanshi@gmail.com");

    @Test
    public void addUser() {

        UserCreationResponse response = userController.addUser(user);

    }
}
