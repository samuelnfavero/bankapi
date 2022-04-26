package com.restapi.bankapi.services.impl;

import com.restapi.bankapi.data.UserDetailsData;
import com.restapi.bankapi.models.User;
import com.restapi.bankapi.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByCpf(cpf);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found with Username " + cpf);
        }
        return new UserDetailsData(user);
    }
}
