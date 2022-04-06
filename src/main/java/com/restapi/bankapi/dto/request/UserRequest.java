package com.restapi.bankapi.dto.request;


import com.restapi.bankapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String name;
    private String cpf;
    private String birthDate;

}
