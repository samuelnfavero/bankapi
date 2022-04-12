package com.restapi.bankapi.specification;

import com.restapi.bankapi.criteria.SearchCriteria;
import com.restapi.bankapi.models.User;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSpecificationBuilder {
    List<SearchCriteria> params;

    public UserSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public UserSpecificationBuilder with(String key, String operation, Object value){
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<User> build(){
          if(params.size() == 0) return null;

          List<UserSpecification> specs = params.stream()
                  .map(param -> new UserSpecification(param))
                  .collect(Collectors.toList());

          Specification result = specs.stream().findFirst().get();

          for (int i = 0; i < specs.size(); i++){
              result = Specification.where(result).and(specs.get(i));
          }

          return result;
    }
}
