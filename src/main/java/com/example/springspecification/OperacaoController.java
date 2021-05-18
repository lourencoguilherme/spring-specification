package com.example.springspecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Operacao> search(@Param("id") Long id, @Param("nome") String nome, @Param("idade") Integer idade) {
        return operacaoService.search(id, nome, idade);
    }

}
