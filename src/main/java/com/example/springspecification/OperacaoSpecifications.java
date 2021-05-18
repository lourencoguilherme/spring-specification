package com.example.springspecification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


public class OperacaoSpecifications<T> {

    public static Specification getOperacaoSpecification(Long id, String nome, Integer idade) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(id != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), id));
            }
            if(nome != null) {
                predicates.add(criteriaBuilder.equal(root.get("nome"), nome));
            }

            if(idade != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("idade"), idade));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
