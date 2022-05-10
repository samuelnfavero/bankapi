package com.restapi.bankapi.security.service;

import com.restapi.bankapi.security.data.UserDetailsData;
import com.restapi.bankapi.models.User;
import com.restapi.bankapi.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

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
