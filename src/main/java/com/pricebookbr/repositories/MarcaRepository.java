package com.pricebookbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pricebookbr.domain.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{

}
