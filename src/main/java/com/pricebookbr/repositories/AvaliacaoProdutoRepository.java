package com.pricebookbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pricebookbr.domain.AvaliacaoProduto;

@Repository
public interface AvaliacaoProdutoRepository extends JpaRepository<AvaliacaoProduto, Integer>{

	@Query("SELECT DISTINCT obj FROM AvaliacaoProduto obj WHERE obj.cliente.id = :idCliente AND obj.produto.id = :idProduto")
	@Transactional(readOnly=true)
	AvaliacaoProduto findDistinctByIdClienteIdProduto(@Param("idCliente")Integer idCliente, @Param("idProduto")Integer idProduto);	
}
