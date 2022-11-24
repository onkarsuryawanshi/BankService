package com.Bank.globalObject;


import com.Bank.dto.UserCreationResponse;
import com.Bank.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserOperation {
    @Autowired
    UserCreationResponse response;
    List<User> userList = new ArrayList<>();
    public UserCreationResponse addUser(User user){
        Integer customerId = userList.size()+1;
        user.setCustomerId(customerId);
        userList.add(user);
        response.setCustomer_id(user.getCustomerId());
        response.setSuccessMessage("customer is added successfully ");
        response.setAdditionalInformation("CustomerName:" + user.getCustomerName() + "  CustomerEmail:"+ user.getCustomerEmail());
        return response;
    }

    public User getUserById(Integer customerId){
        for (User user:
             userList) {
            if(user.getCustomerId()==customerId){
                return user;
            }
        }
            return null;
    }

}
