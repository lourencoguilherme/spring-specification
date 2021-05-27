package com.example.springspecification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


public class OperacaoSpecifications{

    public static Specification getOperacaoSpecification(OperacaoSearch operacao) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(operacao.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), operacao.getId()));
            }
            if(operacao.getNome() != null) {
                predicates.add(criteriaBuilder.equal(root.get("nome"), operacao.getNome()));
            }

            if(operacao.getIdade() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("idade"), operacao.getIdade()));
            }

            if(operacao.getIdade() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("idade"), operacao.getIdade()));
            }
            if(operacao.getDataInicio() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dataHoraCriacaoRegistro"), operacao.getDataInicio()));
            }
            if(operacao.getDataFim() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dataHoraCriacaoRegistro"), operacao.getDataFim()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
