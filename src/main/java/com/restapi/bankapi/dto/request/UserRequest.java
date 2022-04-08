package com.restapi.bankapi.dto.request;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
public class UserRequest {
    @NotBlank @NotNull @Size(min = 2, max = 100)
    private String name;
    @NotBlank @NotNull @CPF
    private String cpf;
    @Size(max = 15)
    private String birthDate;

}
