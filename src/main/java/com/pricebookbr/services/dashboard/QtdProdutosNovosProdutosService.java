package com.pricebookbr.services.dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricebookbr.repositories.dashboard.QtdProdutosNovosProdutosRepository;

@Service
public class QtdProdutosNovosProdutosService {
	@Autowired
	private QtdProdutosNovosProdutosRepository repo;

	public List<Object[]> qtdProdutosNovosProdutos() {
		return repo.qtdProdutosNovosProdutos();
	}
}