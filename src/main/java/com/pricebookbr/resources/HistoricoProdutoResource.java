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

import com.pricebookbr.domain.HistoricoProduto;
import com.pricebookbr.dto.HistoricoProdutoDTO;
import com.pricebookbr.services.HistoricoProdutoService;

@RestController
@RequestMapping(value="/historicoproduto")
public class HistoricoProdutoResource {
	
	@Autowired
	private HistoricoProdutoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<HistoricoProduto> find(@PathVariable Integer id) {
		HistoricoProduto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}	

	@RequestMapping(value="/findByLastBarCodeandIdCliente",method=RequestMethod.GET)
	public ResponseEntity<HistoricoProduto> findByLastBarCodeandIdCliente(
			@RequestParam(value="barCode", defaultValue="") String barCode, 
			@RequestParam(value="idCliente", defaultValue="") Integer idCliente
			) {
		HistoricoProduto obj = service.findByLastBarCodeandIdCliente(barCode, idCliente);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/pageByBarCodeandIdClient",method=RequestMethod.GET)
	public ResponseEntity<Page<HistoricoProdutoDTO>> findPage(
			@RequestParam(value="barCode", defaultValue="") String barCode, 
			@RequestParam(value="idCliente", defaultValue="") Integer idCliente, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<HistoricoProduto> list = service.findDistinctByBarCodeandClient(barCode, idCliente, page, linesPerPage, orderBy, direction);
		Page<HistoricoProdutoDTO> listDto = list.map(obj-> new HistoricoProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/pageByIdClient",method=RequestMethod.GET)
	public ResponseEntity<Page<HistoricoProdutoDTO>> findPage( 
			@RequestParam(value="idCliente", defaultValue="") Integer idCliente, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<HistoricoProduto> list = service.findDistinctByIdCliente(idCliente, page, linesPerPage, orderBy, direction);
		Page<HistoricoProdutoDTO> listDto = list.map(obj-> new HistoricoProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}	
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody HistoricoProdutoDTO objDto){
		HistoricoProduto obj = service.fromDTO(objDto);
		obj.setDtHoraHistorico(new Date());
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Transactional
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody HistoricoProdutoDTO objDto){
		HistoricoProduto obj = service.fromDTO(objDto);
		obj.setDtHoraHistorico(new Date());
		obj = service.update(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/findDistinctByIdProdutoandCliente",method=RequestMethod.GET)
	public ResponseEntity<Page<HistoricoProdutoDTO>> findDistinctByIdProdutoandCliente(
			@RequestParam(value="idProduto", defaultValue="") Integer idProduto, 
			@RequestParam(value="idCliente", defaultValue="") Integer idCliente, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="dtHoraHistorico") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<HistoricoProduto> list = service.findDistinctByIdProdutoandCliente(idProduto, idCliente, page, linesPerPage, orderBy, direction);
		Page<HistoricoProdutoDTO> listDto = list.map(obj-> new HistoricoProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/pageByConsumidores",method=RequestMethod.GET)
	public ResponseEntity<Page<HistoricoProdutoDTO>> findPageByConsumidores( 
			@RequestParam(value="idCliente", defaultValue="") Integer idCliente, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage 
			, @RequestParam(value="orderBy", defaultValue="dtHoraHistorico") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction
		) {
		Page<HistoricoProduto> list = service.findPageByConsumidores(idCliente, page, linesPerPage, orderBy, direction);
		Page<HistoricoProdutoDTO> listDto = list.map(obj-> new HistoricoProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="/findByLastDescTmp",method=RequestMethod.GET)
	public ResponseEntity<HistoricoProduto> findByLastDescTmp(
			@RequestParam(value="barCode", defaultValue="") String barCode, 
			@RequestParam(value="idCliente", defaultValue="") Integer idCliente
			) {
		HistoricoProduto obj = service.findByLastDescTmp(barCode, idCliente);
		return ResponseEntity.ok().body(obj);
	}	
	
	// DEPRECATED * version <= 0.1.4 **************************************
	@RequestMapping(value="/barcodeidcliente",method=RequestMethod.GET)
	public ResponseEntity<HistoricoProduto> findDistinctByBarCodeandClient(
			@RequestParam(value="barCode", defaultValue="") String barCode, 
			@RequestParam(value="idCliente", defaultValue="") Integer idCliente
			) {
		HistoricoProduto obj = service.findByLastBarCodeandIdCliente(barCode, idCliente);
		return ResponseEntity.ok().body(obj);
	}
}