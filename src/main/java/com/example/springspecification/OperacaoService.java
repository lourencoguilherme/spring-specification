package com.example.springspecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.springspecification.OperacaoSpecifications.getOperacaoSpecification;

@Service
public class OperacaoService {

    @Autowired
    private OperacaoRepository operacaoRepository;

    public List<Operacao> search(OperacaoSearch operacao) {
        return operacaoRepository.findAll(getOperacaoSpecification(operacao));
    }
}
