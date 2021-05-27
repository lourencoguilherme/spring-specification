package com.example.springspecification.services;

import com.example.springspecification.models.entities.Operacao;
import com.example.springspecification.repositories.OperacaoRepository;
import com.example.springspecification.services.especifications.OperacaoSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.springspecification.services.especifications.OperacaoSpecifications.getOperacaoSpecification;

@Service
public class OperacaoService {

    @Autowired
    private OperacaoRepository operacaoRepository;

    public List<Operacao> search(OperacaoSearch operacao) {
        return operacaoRepository.findAll(getOperacaoSpecification(operacao));
    }
}
