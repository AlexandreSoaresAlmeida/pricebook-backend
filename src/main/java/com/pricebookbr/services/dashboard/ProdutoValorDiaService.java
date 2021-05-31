package com.pricebookbr.services.dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricebookbr.repositories.dashboard.ProdutoValorDiaRepository;

@Service
public class ProdutoValorDiaService {
	@Autowired
	private ProdutoValorDiaRepository repo;

	public List<Object[]> valorProdutoDia(Integer idProduto, Integer idCliente) {
		return repo.valorProdutoDia(idProduto, idCliente);
	}
}