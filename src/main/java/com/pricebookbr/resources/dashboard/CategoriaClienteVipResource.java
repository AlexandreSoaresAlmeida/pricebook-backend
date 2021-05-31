package com.pricebookbr.resources.dashboard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pricebookbr.dto.dashboard.CategoriaClienteVipDTO;
import com.pricebookbr.services.dashboard.CategoriaClienteVipService;

@RestController
@RequestMapping(value="/db4")
public class CategoriaClienteVipResource {
	
	@Autowired
	private CategoriaClienteVipService service;
	
	@RequestMapping(value="/categoriaClienteVip", method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaClienteVipDTO>> categoriaClienteVip( 
			@RequestParam(value="cliente_id", required=false) Integer cliente_id
		) {
		List<Object[]> objList = service.categoriaClienteVip(cliente_id);
		List<CategoriaClienteVipDTO> listDto = convertListObjectToPojo(objList);
		
		return ResponseEntity.ok().body(listDto);
	}
	
	private List<CategoriaClienteVipDTO> convertListObjectToPojo(List<Object[]> objList){
		List<CategoriaClienteVipDTO> listDto = new ArrayList<CategoriaClienteVipDTO>();
		int i = 0;
		for(Object[] object : objList){
			CategoriaClienteVipDTO pojo = new CategoriaClienteVipDTO();
			pojo.setId(i); i++;
			String cls = (String) object[0];
			BigInteger qtd = (BigInteger) object[1];
			Integer q = qtd.intValue();
			pojo.setId(i);
			pojo.setClassificacao(cls);
			pojo.setQtd(q);
			listDto.add(pojo);
		}	
		return listDto;
	}
}