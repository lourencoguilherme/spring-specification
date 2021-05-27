package com.example.springspecification.repositories;

import com.example.springspecification.models.entities.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long>, JpaSpecificationExecutor {
}
