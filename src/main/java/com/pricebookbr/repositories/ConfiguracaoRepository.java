package com.pricebookbr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pricebookbr.domain.Configuracao;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Integer>{
	@Transactional(readOnly=true)
	//@Query("SELECT DISTINCT obj FROM Configuracao obj Order by obj.dtHoraHistorico DESC")
	//@QueryHints(@QueryHint(name = "org.hibernate.annotations.FETCH_SIZE", value = "1"))
	
	//@Query(value="SELECT DISTINCT obj.* FROM Configuracao obj ORDER BY obj.dt_hora_historico DESC LIMIT 1", nativeQuery = true)
	//Configuracao findByLastVersion();
	
	@Query("SELECT DISTINCT obj FROM Configuracao obj Order by obj.dtHoraHistorico DESC")
	List<Configuracao> findByLastVersion();
}
