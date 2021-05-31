package com.pricebookbr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pricebookbr.domain.HistoricoAcesso;
import com.pricebookbr.dto.HistoricoAcessoDTO;
import com.pricebookbr.repositories.HistoricoAcessoRepository;
import com.pricebookbr.services.exceptions.ObjectNotFoundException;

@Service
public class HistoricoAcessoService {

	@Autowired
	private HistoricoAcessoRepository repo;
	
	public HistoricoAcesso find(Integer id) {
		Optional <HistoricoAcesso> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
				+ ", Tipo: " + HistoricoAcesso.class.getName()));
	}

	public Page<HistoricoAcesso> findDistinctByIdCliente(Integer idCliente, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findDistinctByIdCliente(idCliente, pageRequest);
	}
	
	public HistoricoAcesso insert(HistoricoAcesso obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public HistoricoAcesso fromDTO(HistoricoAcessoDTO objDto) {
		return new HistoricoAcesso(
				objDto.getId(), 
				objDto.getCliente(), 
				objDto.getDtHoraHistorico() 
				);
	}
}