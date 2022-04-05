package com.restapi.bankapi.services;

import com.restapi.bankapi.dto.request.UserRequest;
import com.restapi.bankapi.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public UserResponse create(UserRequest userRequest) {
        return null;
    }
}
