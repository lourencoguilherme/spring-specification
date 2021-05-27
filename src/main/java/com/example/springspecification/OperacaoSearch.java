package com.example.springspecification;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
public class OperacaoSearch {

    private Long id;

    private String nome;

    private Integer idade;

    private LocalDate dataInicio;

    private LocalDate dataFim;

}
