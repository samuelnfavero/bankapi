package com.restapi.bankapi.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchCriteria {
    private String key; //nome, cpf, ... (qual atributo quer pesquisar)
    private String operation; //maior, menor, igual
    private Object value; //objeto de comparação. è notado como object para aceitar qualquer tipo de objeto, seja int, string ...
}
