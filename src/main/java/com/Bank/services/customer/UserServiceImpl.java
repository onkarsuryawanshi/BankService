package com.Bank.services.customer;


import com.Bank.dto.UserCreationResponse;
import com.Bank.globalObject.UserOperation;
import com.Bank.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserOperation userOperation;
    @Override
    public UserCreationResponse registerUser(User user) {
                UserCreationResponse accountCreationResponse = userOperation.addUser(user);
                return accountCreationResponse;
    }
}
