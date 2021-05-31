package com.pricebookbr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pricebookbr.domain.HistoricoAcesso;

@Repository
public interface HistoricoAcessoRepository extends JpaRepository<HistoricoAcesso, Integer>{	
	
	@Query("SELECT DISTINCT obj FROM HistoricoAcesso obj WHERE obj.cliente.id = :idCliente order by obj.dtHoraHistorico desc")
	@Transactional(readOnly=true)
	Page<HistoricoAcesso> findDistinctByIdCliente(@Param("idCliente")Integer idCliente, Pageable pageRequest);

}
