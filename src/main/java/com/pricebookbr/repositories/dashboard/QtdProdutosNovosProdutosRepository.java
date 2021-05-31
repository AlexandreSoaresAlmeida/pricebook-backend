package com.pricebookbr.repositories.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pricebookbr.domain.dashboard.QtdAcessosDia;

@Repository
public interface QtdProdutosNovosProdutosRepository extends JpaRepository<QtdAcessosDia, Integer>{
/*
-- Quantidade de Produtos Existentes e Quantidade de Novos Produtos
select 
       (select count(*) from pricebookdb.produto p where p.dt_hr_hist < CONVERT(CONCAT(DATE_FORMAT(NOW(), '%Y-%m-%d'), ' 00:00:00'), datetime)) qtd_prod_exist,
       (select count(*) from pricebookdb.produto p where p.dt_hr_hist >= CONVERT(CONCAT(DATE_FORMAT(NOW(), '%Y-%m-%d'), ' 00:00:00'), datetime)) qtd_prod_novo
  from dual;
*/
	@Transactional(readOnly=true)
	@Query(value = "SELECT DISTINCT 0 as id, " +
		   "(SELECT COUNT(*) FROM produto p WHERE p.dt_hr_hist < CONVERT(CONCAT(DATE_FORMAT(NOW(), '%Y-%m-%d'), ' 00:00:00'), datetime)) qtd_prod_exist, " + 
		   "(SELECT COUNT(*) FROM produto p WHERE p.dt_hr_hist >= CONVERT(CONCAT(DATE_FORMAT(NOW(), '%Y-%m-%d'), ' 00:00:00'), datetime)) qtd_prod_novo " + 
		   "FROM DUAL ",
		   nativeQuery = true)
	List<Object[]> qtdProdutosNovosProdutos();
}