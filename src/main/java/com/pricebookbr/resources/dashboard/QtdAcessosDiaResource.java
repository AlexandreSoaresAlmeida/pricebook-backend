package com.pricebookbr.resources.dashboard;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pricebookbr.dto.dashboard.QtdAcessosDiaDTO;
import com.pricebookbr.services.dashboard.QtdAcessosDiaService;

@RestController
@RequestMapping(value="/db1")
public class QtdAcessosDiaResource {
	
	@Autowired
	private QtdAcessosDiaService service;
	
	@RequestMapping(value="/qtdAcessosDias", method=RequestMethod.GET)
	public ResponseEntity<List<QtdAcessosDiaDTO>> qtdAcessosDias( 
			@RequestParam(value="dtIni", required=true) String dtI, 
			@RequestParam(value="dtFim", required=true) String dtF,
			@RequestParam(value="qtd", required=false) Integer qtd
		) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dtIni = LocalDate.parse(dtI, formatter);
		LocalDate dtFim = LocalDate.parse(dtF, formatter);
		
		Integer qtdRegistros = 6; // Padrão de no mínimo 06 registros
		if (qtd != null) qtdRegistros = qtd;
		
		List<Object[]> objList = service.qtdAcessosDia(java.sql.Date.valueOf(dtIni), java.sql.Date.valueOf(dtFim), qtdRegistros);
		List<QtdAcessosDiaDTO> listDto = convertListObjectToPojo(objList, qtdRegistros);
		
		return ResponseEntity.ok().body(listDto);
	}
	
	private List<QtdAcessosDiaDTO> convertListObjectToPojo(List<Object[]> objList, Integer qtd){
		List<QtdAcessosDiaDTO> listDto = new ArrayList<QtdAcessosDiaDTO>();
		int i = 0;
		for(Object[] object : objList){
			// Limite de 06 registros padrão
			if (i < qtd) {
				QtdAcessosDiaDTO pojo = new QtdAcessosDiaDTO();
				pojo.setId(i); i++;
				Date d = (Date) object[1];
				BigInteger ba = (BigInteger) object[2];
				Integer a = ba.intValue();
				BigInteger br = (BigInteger) object[3];
				Integer r = br.intValue();
				pojo.setId(i);
				pojo.setDtHistorico(d);
				pojo.setQtdAcessos(a);
				pojo.setQtdRegistros(r);
				listDto.add(pojo);
			}
		}	
		return listDto;
	}
}