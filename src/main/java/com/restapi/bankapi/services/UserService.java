package com.restapi.bankapi.services;

import com.restapi.bankapi.dto.request.UserRequest;
import com.restapi.bankapi.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    List<UserResponse> search(String search);
}
