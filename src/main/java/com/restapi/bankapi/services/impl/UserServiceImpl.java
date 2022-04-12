package com.restapi.bankapi.services.impl;

import com.restapi.bankapi.dto.request.UserRequest;
import com.restapi.bankapi.dto.response.UserResponse;
import com.restapi.bankapi.models.User;
import com.restapi.bankapi.repository.UserRepository;
import com.restapi.bankapi.services.UserService;
import com.restapi.bankapi.specification.UserSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = new User (userRequest);
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser);
    }

    @Override
    public List<UserResponse> search(String search){
        UserSpecificationBuilder builder = new UserSpecificationBuilder();

        Pattern pattern =  Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while(matcher.find()){
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        List<User> users = userRepository.findAll(builder.build());

        return users.stream()
                .map(user -> new UserResponse(user))
                .collect(Collectors.toList());
    }
}
