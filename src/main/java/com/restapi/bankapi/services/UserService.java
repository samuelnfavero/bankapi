package com.restapi.bankapi.services;

import com.restapi.bankapi.dto.request.UserRequest;
import com.restapi.bankapi.dto.response.UserResponse;

public interface UserService {
    UserResponse create(UserRequest userRequest);
}
