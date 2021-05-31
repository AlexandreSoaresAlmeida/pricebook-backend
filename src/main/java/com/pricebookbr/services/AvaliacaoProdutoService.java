package com.pricebookbr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricebookbr.domain.AvaliacaoProduto;
import com.pricebookbr.dto.AvaliacaoProdutoDTO;
import com.pricebookbr.repositories.AvaliacaoProdutoRepository;

@Service
public class AvaliacaoProdutoService {

	@Autowired
	private AvaliacaoProdutoRepository repo;
	
	public AvaliacaoProduto findDistinctByIdClienteIdProduto(Integer idCliente, Integer idProduto) {
		return repo.findDistinctByIdClienteIdProduto(idCliente, idProduto);
	}
	
	public AvaliacaoProduto insert(AvaliacaoProduto obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	} 
	
	public AvaliacaoProduto update(AvaliacaoProduto obj) {
		obj = repo.save(obj);
		return obj;
	}

	public AvaliacaoProduto fromDTO(AvaliacaoProdutoDTO objDto) {
		return new AvaliacaoProduto(
				objDto.getId(), 
				objDto.getProduto(), 
				objDto.getCliente(), 
				objDto.getDtHoraHistorico(),
				objDto.getAvaliacao()
				);
	}
}