package com.pricebookbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pricebookbr.domain.Classificacao;

@Repository
public interface ClassificacaoRepository extends JpaRepository<Classificacao, Integer>{

}
