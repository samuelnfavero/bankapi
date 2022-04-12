package com.restapi.bankapi.controllers;


import com.restapi.bankapi.dto.request.UserRequest;
import com.restapi.bankapi.dto.response.UserResponse;
import com.restapi.bankapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest userRequest){
        UserResponse userResponse = userService.create(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public List<UserResponse> search(@RequestParam String search){
        return userService.search(search);
    }
}
