package com.Bank.controller.user;


import com.Bank.dto.UserCreationResponse;
import com.Bank.models.User;
import com.Bank.services.customer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public UserCreationResponse addUser(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }
}
