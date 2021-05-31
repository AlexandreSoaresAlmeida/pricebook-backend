package com.pricebookbr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pricebookbr.domain.Categoria;
import com.pricebookbr.domain.Produto;
import com.pricebookbr.dto.ProdutoDTO;
import com.pricebookbr.repositories.CategoriaRepository;
import com.pricebookbr.repositories.ProdutoRepository;
import com.pricebookbr.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

		@Autowired
		private ProdutoRepository produtoRepo;
		
		@Autowired
		private CategoriaRepository categoriaRepo;
		
		public Produto find(Integer id) {
			Optional <Produto> obj = produtoRepo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Produto.class.getName()));
		}
		
		public Produto findByBarCode(String barCode) {
			//Optional <Produto> obj = repo.findByBarCode(barCode);
			return produtoRepo.findByBarCode(barCode);
			// Optional <Produto> obj = repo.findByBarCode(barCode);
			// return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! BarCode: " + barCode));			
		}
		
		public Page<Produto> search(String nome, List<Integer> ids,Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			List<Categoria> categorias = categoriaRepo.findAllById(ids);
			//return repo.search(nome, categorias, pageRequest);
			return produtoRepo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
		}
			
		public Page<Produto> findDistinctByIdCliente(Integer idCliente, Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			return produtoRepo.findDistinctByIdCliente(idCliente, pageRequest);
		}
		
		public Produto insert(Produto obj) {
			obj.setId(null);
			obj = produtoRepo.save(obj);
			return obj;
		}

		public Produto update(Produto obj) {
			obj = produtoRepo.save(obj);
			return obj;
		}
		
		public Produto fromDTO(ProdutoDTO objDto) {
			return new Produto(
					objDto.getId(), 
					objDto.getNome(), 
					objDto.getDescricao(), 
					objDto.getPreco(), 
					objDto.getBarcode(),
					objDto.getUnidadeMedida(),
					objDto.getUrlInternet(),
					objDto.getCliente(),
					objDto.getDtHoraHistorico(),
					objDto.getSituacaoImagem(),
					objDto.getImagemNaoCorrespondente()
			);
		}		
}
