package com.example.springspecification;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Operacao {

    @Id
    private Long id;

    private String nome;

    private Integer idade;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataHoraCriacaoRegistro;

}
