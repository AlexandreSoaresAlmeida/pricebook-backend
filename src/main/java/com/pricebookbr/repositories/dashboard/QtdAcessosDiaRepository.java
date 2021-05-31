package com.pricebookbr.repositories.dashboard;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pricebookbr.domain.dashboard.QtdAcessosDia;

@Repository
public interface QtdAcessosDiaRepository extends JpaRepository<QtdAcessosDia, Integer>{
/*
-- Relacao de acessos x conversao em registro de historico
select tmp.dt,	
       (select count(*) from pricebookdb.historico_acesso ha where DATE_FORMAT(ha.dt_hora_historico, '%d/%m/%Y') = tmp.dt) qtd_acessos,
       (select count(*) from pricebookdb.historico_produto hp where DATE_FORMAT(hp.dt_hora_historico, '%d/%m/%Y') = tmp.dt) qtd_registros
  from (select DISTINCT DATE_FORMAT(ha.dt_hora_historico, '%d/%m/%Y') dt
          from pricebookdb.historico_acesso ha) as tmp 
 where tmp.dt between '01/05/2019' and '19/05/2019'; 
 */
	
	/*
	 "SELECT 0 as id, " + 
			"dtHoraHistorico as dtHistorico, " + 
			"COUNT(ha) AS qtd " + 	
			"FROM HistoricoAcesso ha " + 
			"WHERE (cast(dtHoraHistorico as date) BETWEEN :dt1 AND :dt2) " +
			"GROUP BY cast(dtHoraHistorico as date)"
			
SELECT 0 as id, 
       cast(tmp.dt as date) as dtHistorico, 
	   (SELECT COUNT(*) FROM Historico_Acesso  ha WHERE (cast(ha.dt_Hora_Historico as date) = tmp.dt)) AS qtdAcessos, 
	   (SELECT COUNT(*) FROM Historico_Produto hp WHERE (cast(hp.dt_Hora_Historico as date) = tmp.dt)) AS qtdRegistros 
  FROM (SELECT cast(dt_Hora_Historico as date) AS dt FROM historico_acesso) AS tmp 
 WHERE tmp.dt BETWEEN '2019-05-01' AND '2019-05-19'
	 */
	@Transactional(readOnly=true)
	@Query(value = "SELECT DISTINCT 0 as id, " +
		   "cast(tmp.dt_Hora_Historico as date) as dtHistorico, " + 
		   "(SELECT COUNT(*) FROM historico_acesso  ha WHERE (cast(ha.dt_hora_historico as date) = cast(tmp.dt_hora_historico as date))) AS qtdAcessos, " + 
		   "(SELECT COUNT(*) FROM historico_produto hp WHERE (cast(hp.dt_hora_historico as date) = cast(tmp.dt_hora_historico as date))) AS qtdRegistros " +
		   "FROM historico_acesso as tmp " + 
		   "WHERE cast(tmp.dt_hora_historico as date) BETWEEN :dt1 AND :dt2 " +
		   "ORDER BY 2 DESC " +
		   "LIMIT :qtd ", 
		   nativeQuery = true)
	List<Object[]> qtdAcessosDia(
			@Param("dt1")@DateTimeFormat(pattern="dd/MM/yyyy") Date dt1,
			@Param("dt2")@DateTimeFormat(pattern="dd/MM/yyyy") Date dt2,
	    	@Param("qtd") Integer qtd
		);
}