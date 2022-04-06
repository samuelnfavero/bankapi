package com.restapi.bankapi.services;

import com.restapi.bankapi.dto.request.UserRequest;
import com.restapi.bankapi.dto.response.UserResponse;
import com.restapi.bankapi.models.User;
import com.restapi.bankapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = new User (userRequest);
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser);
    }
}
