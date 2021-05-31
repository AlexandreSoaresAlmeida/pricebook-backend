package com.pricebookbr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pricebookbr.domain.HistoricoProduto;

@Repository
public interface HistoricoProdutoRepository extends JpaRepository<HistoricoProduto, Integer>{

	@Query("SELECT DISTINCT obj FROM HistoricoProduto obj WHERE obj.cliente.id = :idCliente order by obj.dtHoraHistorico desc")
	@Transactional(readOnly=true)
	Page<HistoricoProduto> findDistinctByIdCliente(@Param("idCliente")Integer idCliente, Pageable pageRequest);
	
	@Query("SELECT DISTINCT obj FROM HistoricoProduto obj WHERE obj.produto.barcode = :barCode and obj.cliente.id = :idCliente order by obj.dtHoraHistorico desc")
	@Transactional(readOnly=true)
	Page<HistoricoProduto> findDistinctByBarCodeandClient(@Param("barCode")String barCode, @Param("idCliente")Integer idCliente, Pageable pageRequest);

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM HistoricoProduto obj WHERE obj.id = (SELECT MAX(o.id) FROM HistoricoProduto o WHERE o.produto.barcode = :barCode AND o.cliente.id = :idCliente)")
	HistoricoProduto findByLastBarCodeandClient(@Param("barCode")String barCode, @Param("idCliente")Integer idCliente);
                    
	@Query("SELECT DISTINCT obj FROM HistoricoProduto obj WHERE obj.produto.id = :idProduto and obj.cliente.id = :idCliente order by obj.dtHoraHistorico desc")
	@Transactional(readOnly=true)
	Page<HistoricoProduto> findDistinctByIdProdutoandCliente(@Param("idProduto")Integer idProduto, @Param("idCliente")Integer idCliente, Pageable pageRequest);
	
	@Query("SELECT DISTINCT hp " + 
		   "FROM HistoricoProduto hp " + 
		   "WHERE hp.cliente.id = :idCliente " + 
		   "AND (hp.id = (SELECT MAX(id) FROM HistoricoProduto hp2 WHERE hp2.cliente.id = hp.cliente.id AND hp2.produto.id = hp.produto.id)) " 
	)
	@Transactional(readOnly=true)
	Page<HistoricoProduto> findPageByConsumidores(@Param("idCliente")Integer idCliente, Pageable pageRequest);

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM HistoricoProduto obj WHERE obj.id = (SELECT MAX(o.id) FROM HistoricoProduto o WHERE o.produto.barcode = :barCode AND o.cliente.id = :idCliente AND o.nomeTempProduto IS NOT NULL)")
	HistoricoProduto findByLastDescTmp(@Param("barCode")String barCode, @Param("idCliente")Integer idCliente);
}