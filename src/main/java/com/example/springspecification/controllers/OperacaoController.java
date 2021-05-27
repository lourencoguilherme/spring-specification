package com.example.springspecification.controllers;

import com.example.springspecification.models.entities.Operacao;
import com.example.springspecification.repositories.OperacaoRepository;
import com.example.springspecification.services.especifications.OperacaoSearch;
import com.example.springspecification.services.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OperacaoController {

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private OperacaoService operacaoService;

    @PostMapping
    public Operacao createOperacao(@RequestBody Operacao operacao) {
        return operacaoRepository.save(operacao);
    }

    @GetMapping
    public List<Operacao> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "idade", required = false) Integer idade,
            @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam(value = "dataInicio", required = false) LocalDate dataInicio,
            @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam(value = "dataFim", required = false) LocalDate dataFim

    ) {
        return operacaoService.search(OperacaoSearch.builder().id(id).nome(nome).idade(idade).dataInicio(dataInicio).dataFim(dataFim).build());
    }

}
