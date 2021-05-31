package com.pricebookbr.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pricebookbr.domain.Categoria;
import com.pricebookbr.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	//	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	//  Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	@Transactional(readOnly=true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
/*
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj WHERE obj.barcode = :barCode")
	Optional <Produto> findByBarCode(@Param("barCode")String barCode);
	*/
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj WHERE obj.barcode = :barCode")
	Produto findByBarCode(@Param("barCode")String barCode);
	
	@Query("SELECT DISTINCT p FROM Produto p INNER JOIN HistoricoProduto hp ON (p.id = hp.produto.id ) WHERE hp.cliente.id = :idCliente order by hp.dtHoraHistorico DESC")
	@Transactional(readOnly=true)
	Page<Produto> findDistinctByIdCliente(@Param("idCliente")Integer idCliente, Pageable pageRequest);
}
