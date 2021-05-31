package com.pricebookbr.resources;

import java.net.URI;
import java.util.Date;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pricebookbr.domain.Cliente;
import com.pricebookbr.domain.HistoricoAcesso;
import com.pricebookbr.dto.HistoricoAcessoDTO;
import com.pricebookbr.services.ClienteService;
import com.pricebookbr.services.HistoricoAcessoService;

@RestController
@RequestMapping(value="/historicoacesso")
public class HistoricoAcessoResource {
	
	@Autowired
	private HistoricoAcessoService service;
	
	@Autowired
	private ClienteService clienteService;	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<HistoricoAcesso> find(@PathVariable Integer id) {
		HistoricoAcesso obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}	

	@RequestMapping(value="/pageByIdClient",method=RequestMethod.GET)
	public ResponseEntity<Page<HistoricoAcessoDTO>> findPage( 
			@RequestParam(value="idCliente", defaultValue="") Integer idCliente, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<HistoricoAcesso> list = service.findDistinctByIdCliente(idCliente, page, linesPerPage, orderBy, direction);
		Page<HistoricoAcessoDTO> listDto = list.map(obj-> new HistoricoAcessoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody HistoricoAcessoDTO objDto){
		// Recupera o id do cliente a partir do email
		Cliente cli = clienteService.findByEmail(objDto.getEmail());
		objDto.setCliente(cli);
		HistoricoAcesso obj = service.fromDTO(objDto);
		obj.setDtHoraHistorico(new Date());
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	
}
