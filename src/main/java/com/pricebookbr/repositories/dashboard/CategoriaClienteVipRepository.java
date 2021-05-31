package com.pricebookbr.repositories.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pricebookbr.domain.dashboard.CategoriaClienteVip;

@Repository
public interface CategoriaClienteVipRepository extends JpaRepository<CategoriaClienteVip, Integer>{
/*
-- Recupera a quantidade de pontos de cada usuario
select case 
         when (qtd < 101) then 'Bronze'
         when (qtd > 100 and qtd  < 301) then 'Silver'
         when (qtd > 300 and qtd  < 501) then 'Gold'
         when (qtd > 500 and qtd < 1001) then 'Platinum'
         else 'Emerald'
       end as classificacao,
       qtd
from (
	select 
		   (
		     100 + -- Pontuação pelo Download
		     ((select count(*) from (select distinct produto_id from historico_produto where cliente_id = 2) t) * 10) + -- Pontuação de Qtd de Produtos
		     ((select count(*) from historico_produto where cliente_id = 2) * 10) + -- Pontuação por Histórico de Produto Registrado
		     ((select count(*) from avaliacao_produto where cliente_id = 2) * 10) -- Pontuação por Avaliação de Produto Registrado
		   ) as qtd
	  from dual
	 ) as c;
 */
	@Transactional(readOnly=true)
	@Query(value = 
		   "SELECT CASE " + 
		   "WHEN (qtd < 101) THEN 'Bronze' " + 
		   "WHEN (qtd > 100 AND qtd  < 301) THEN 'Silver' " + 
		   "WHEN (qtd > 300 AND qtd  < 501) THEN 'Gold' " + 
		   "WHEN (qtd > 500 AND qtd < 1001) THEN 'Platinum' " + 
		   "ELSE 'Emerald' " + 
		   "END AS classificacao, " + 
		   "qtd " + 
		   "FROM ( " + 
		   "SELECT " + 
		   "( " + 
		   "100 + " + // Pontuação pelo Download  
		   "((SELECT COUNT(*) FROM (SELECT DISTINCT produto_id FROM historico_produto WHERE cliente_id = :cliente_id) t) * 10) + " + // Pontuação de Qtd de Produtos
		   "((SELECT COUNT(*) FROM historico_produto WHERE cliente_id = :cliente_id) * 10) + " + // -- Pontuação por Histórico de Produto Registrado 
		   "((SELECT COUNT(*) FROM avaliacao_produto WHERE cliente_id = :cliente_id) * 10) " + // -- Pontuação por Avaliação de Produto Registrado 
		   ") AS qtd " + 
		   "FROM dual " + 
		   ") AS c"
		   , nativeQuery = true)
	List<Object[]> categoriaClienteVip(
	    	@Param("cliente_id") Integer qtd 
		);
}