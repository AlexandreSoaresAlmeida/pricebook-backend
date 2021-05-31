package com.pricebookbr.resources.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pricebookbr.dto.dashboard.ProdutoValorDiaDTO;
import com.pricebookbr.services.dashboard.ProdutoValorDiaService;

@RestController
@RequestMapping(value="/db2")
public class ProdutoValorDiaResource {
	
	// https://www.baeldung.com/java-date-to-localdate-and-localdatetime
	
	@Autowired
	private ProdutoValorDiaService service;
	
	@RequestMapping(value="/produtoValorDia", method=RequestMethod.GET)
	public ResponseEntity<List<ProdutoValorDiaDTO>> qtdAcessosDias( 
			@RequestParam(value="idProduto", required=true) Integer idProduto, 
			@RequestParam(value="idCliente", required=true) Integer idCliente	
		) {
		//https://www.guj.com.br/t/resolvido-problema-no-cast-ljava-lang-object-retornado-de-um-org-hibernate-query/293550/3		
		
		List<Object[]> objList = service.valorProdutoDia(idProduto, idCliente);
		List<ProdutoValorDiaDTO> listDto = convertListObjectToPojo(objList);
		
		return ResponseEntity.ok().body(listDto);
	}
	
	private List<ProdutoValorDiaDTO> convertListObjectToPojo(List<Object[]> objList){
		List<ProdutoValorDiaDTO> listDto = new ArrayList<ProdutoValorDiaDTO>();
		int i = 0;
		for(Object[] object : objList){
			// Limite de 5 registros
			if (i < 5) {
				ProdutoValorDiaDTO pojo = new ProdutoValorDiaDTO();
				pojo.setId(i); i++;
				Date d = (Date) object[1];
				Double p = (Double)object[2];
				pojo.setId(i);
				pojo.setDtHistorico(d);
				pojo.setPreco(p);
				listDto.add(pojo);
			} else { break; }
		}	
		return listDto;
	}
}