package com.pricebookbr.repositories.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pricebookbr.domain.dashboard.ProdutoValorDia;

@Repository
public interface ProdutoValorDiaRepository extends JpaRepository<ProdutoValorDia, Integer>{
/*
-- Histórico Produto Valor por Dia (Últimos 05 dias que foi registrado)
select 0  id,
       DATE_FORMAT(hp.dt_hora_historico, '%d/%m/%Y') dt,
       MIN(hp.preco) preco
  from historico_produto hp 
 where hp.produto_id = 3
   and hp.cliente_id = 2    
group by DATE_FORMAT(hp.dt_hora_historico, '%d/%m/%Y')
ORDER BY 2 DESC
limit 5;
 */
	@Transactional(readOnly=true)
	@Query("SELECT 0 as id, " + 
			"hp.dtHoraHistorico as dtHistorico, " +
			"MIN(hp.preco) as preco " + 	
			"FROM HistoricoProduto hp " +
			"WHERE hp.produto.id = :idProduto " +
			"AND hp.cliente.id = :idCliente " +
			"GROUP BY cast(hp.dtHoraHistorico as date)" +
			"ORDER BY 2 DESC")
	List<Object[]> valorProdutoDia(
			@Param("idProduto") Integer idProduto,
			@Param("idCliente") Integer idCliente
			);
}