package com.pricebookbr.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.pricebookbr.domain.Configuracao;
import com.pricebookbr.dto.ConfiguracaoDTO;
import com.pricebookbr.services.ConfiguracaoService;

@RestController
@RequestMapping(value="/configuracao")
public class ConfiguracaoResource {
	
	@Autowired
	private ConfiguracaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Configuracao> find(@PathVariable Integer id) {
		Configuracao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ConfiguracaoDTO objDto){
		Configuracao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ConfiguracaoDTO objDto, @PathVariable Integer id){
		Configuracao obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ConfiguracaoDTO>> findAll() {
		List<Configuracao> list = service.findAll();
		List<ConfiguracaoDTO> listDto = list.stream().map(obj-> new ConfiguracaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<ConfiguracaoDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Configuracao> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ConfiguracaoDTO> listDto = list.map(obj-> new ConfiguracaoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/findByLastVersion",method=RequestMethod.GET)
	public ResponseEntity<ConfiguracaoDTO> findByLastVersion() {
		List<Configuracao> list = service.findByLastVersion();
		List<ConfiguracaoDTO> listDto = list.stream().map(obj-> new ConfiguracaoDTO(obj)).collect(Collectors.toList());
		ConfiguracaoDTO obj = listDto.get(0);
		return ResponseEntity.ok().body(obj);
	}
}