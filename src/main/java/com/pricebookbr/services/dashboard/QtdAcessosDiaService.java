package com.pricebookbr.services.dashboard;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricebookbr.repositories.dashboard.QtdAcessosDiaRepository;

@Service
public class QtdAcessosDiaService {
	@Autowired
	private QtdAcessosDiaRepository repo;

	public List<Object[]> qtdAcessosDia(Date dtIni, Date dtFim, Integer qtd) {
		return repo.qtdAcessosDia(dtIni, dtFim, qtd);
	}
}