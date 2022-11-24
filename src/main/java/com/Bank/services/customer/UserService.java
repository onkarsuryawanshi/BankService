package com.Bank.services.customer;

import com.Bank.dto.UserCreationResponse;
import com.Bank.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
   UserCreationResponse registerUser(User user);
}
