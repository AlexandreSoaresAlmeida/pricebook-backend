package com.pricebookbr.resources;

import java.net.URI;
import java.util.Date;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pricebookbr.domain.AvaliacaoProduto;
import com.pricebookbr.dto.AvaliacaoProdutoDTO;
import com.pricebookbr.services.AvaliacaoProdutoService;

@RestController
@RequestMapping(value="/avaliacaoProduto")
public class AvaliacaoProdutoResource {
	
	@Autowired
	private AvaliacaoProdutoService service;
	
	@RequestMapping(value="/ByIdClienteandIdProduto",method=RequestMethod.GET)
	public ResponseEntity<AvaliacaoProduto> findDistinctByIdClienteIdProduto(
			@RequestParam(value="idCliente", defaultValue="") Integer idCliente,
			@RequestParam(value="idProduto", defaultValue="") Integer idProduto
			) {
		AvaliacaoProduto obj = service.findDistinctByIdClienteIdProduto(idCliente, idProduto);
		return ResponseEntity.ok().body(obj);
	}

	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AvaliacaoProdutoDTO objDto){
		AvaliacaoProduto obj = service.fromDTO(objDto);
		obj.setDtHoraHistorico(new Date());
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AvaliacaoProdutoDTO objDto){
		AvaliacaoProduto obj = service.fromDTO(objDto);
		obj.setDtHoraHistorico(new Date());
		obj = service.update(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}