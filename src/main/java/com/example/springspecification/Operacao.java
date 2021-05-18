package com.example.springspecification;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Operacao {

    @Id
    private Long id;

    private String nome;

    private Integer idade;

}
