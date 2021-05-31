package com.pricebookbr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pricebookbr.domain.HistoricoProduto;
import com.pricebookbr.domain.Produto;
import com.pricebookbr.dto.HistoricoProdutoDTO;
import com.pricebookbr.repositories.HistoricoProdutoRepository;
import com.pricebookbr.services.exceptions.ObjectNotFoundException;

@Service
public class HistoricoProdutoService {

	@Autowired
	private HistoricoProdutoRepository repo;
	
	public Page<HistoricoProduto> findDistinctByIdCliente(Integer idCliente, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findDistinctByIdCliente(idCliente, pageRequest);
	}

	public Page<HistoricoProduto> findDistinctByBarCodeandClient(String barCode, Integer idCliente, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findDistinctByBarCodeandClient(barCode, idCliente, pageRequest);
	}

	public HistoricoProduto find(Integer id) {
		Optional <HistoricoProduto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
				+ ", Tipo: " + Produto.class.getName()));
	}

	public HistoricoProduto findByLastBarCodeandIdCliente(String barCode, Integer idCliente) {
		return repo.findByLastBarCodeandClient(barCode, idCliente);
	}
	
	public Page<HistoricoProduto> findDistinctByIdProdutoandCliente(Integer idProduto, Integer idCliente, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findDistinctByIdProdutoandCliente(idProduto, idCliente, pageRequest);
	}
	
	public HistoricoProduto insert(HistoricoProduto obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public HistoricoProduto update(HistoricoProduto obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public Page<HistoricoProduto> findPageByConsumidores(Integer idCliente, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findPageByConsumidores(idCliente, pageRequest);
	}

	public HistoricoProduto findByLastDescTmp(String barCode, Integer idCliente) {
		return repo.findByLastDescTmp(barCode, idCliente);
	}

	public HistoricoProduto fromDTO(HistoricoProdutoDTO objDto) {
		return new HistoricoProduto(
				objDto.getId(), 
				objDto.getProduto(), 
				objDto.getCliente(), 
				objDto.getPreco(), 
				objDto.getDtHoraHistorico(), 
				objDto.getPrecoPromocional(),
				objDto.getLongitude(),
				objDto.getLatitude(),
				objDto.getLocalAumentoAbusivo(),
				objDto.getNomeTempProduto()
				);		
	}
}