package com.pricebookbr.resources.dashboard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pricebookbr.dto.dashboard.QtdProdutosNovosProdutosDTO;
import com.pricebookbr.services.dashboard.QtdProdutosNovosProdutosService;

@RestController
@RequestMapping(value="/db3")
public class QtdProdutosNovosProdutosResource {
	
	@Autowired
	private QtdProdutosNovosProdutosService service;
	
	@RequestMapping(value="/qtdProdutosNovosProdutos", method=RequestMethod.GET)
	public ResponseEntity<List<QtdProdutosNovosProdutosDTO>> qtdProdutosNovosProdutos( 
		) {
		List<Object[]> objList = service.qtdProdutosNovosProdutos();
		List<QtdProdutosNovosProdutosDTO> listDto = convertListObjectToPojo(objList);
		
		return ResponseEntity.ok().body(listDto);
	}
	
	private List<QtdProdutosNovosProdutosDTO> convertListObjectToPojo(List<Object[]> objList){
		List<QtdProdutosNovosProdutosDTO> listDto = new ArrayList<QtdProdutosNovosProdutosDTO>();
		int i = 0;
		for(Object[] object : objList){
			// Limite de 06 registros padrão
			QtdProdutosNovosProdutosDTO pojo = new QtdProdutosNovosProdutosDTO();
			pojo.setId(i); i++;
			BigInteger ba = (BigInteger) object[1];
			Integer a = ba.intValue();
			BigInteger br = (BigInteger) object[2];
			Integer r = br.intValue();
			pojo.setId(i);
			pojo.setQtdProdutos(a);
			pojo.setQtdNovosProdutos(r);
			listDto.add(pojo);
		}	
		return listDto;
	}
}