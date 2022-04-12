package com.restapi.bankapi.specification;

import com.restapi.bankapi.criteria.SearchCriteria;
import com.restapi.bankapi.models.User;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class UserSpecification implements Specification<User> {

    SearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(searchCriteria.getOperation().equalsIgnoreCase(">")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        } else if(searchCriteria.getOperation().equalsIgnoreCase("<")){
             return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        } else if(searchCriteria.getOperation().equalsIgnoreCase(":")){
            if(root.get(searchCriteria.getKey()).getJavaType().equals(String.class)){
                return criteriaBuilder.like(root.get(searchCriteria.getKey()),
                        "%" + searchCriteria.getValue() + "%");
            } else {
                 return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }
        return null;
    }
}
