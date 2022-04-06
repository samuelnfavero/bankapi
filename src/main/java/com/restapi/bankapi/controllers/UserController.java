package com.restapi.bankapi.controllers;


import com.restapi.bankapi.dto.request.UserRequest;
import com.restapi.bankapi.dto.response.UserResponse;
import com.restapi.bankapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public ResponseEntity<UserResponse> create(UserRequest userRequest){
        UserResponse userResponse = userService.create(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
}
