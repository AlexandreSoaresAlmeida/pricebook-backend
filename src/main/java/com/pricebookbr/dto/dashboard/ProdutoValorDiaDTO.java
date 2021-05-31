package com.pricebookbr.dto.dashboard;

import java.io.Serializable;
import java.util.Date;

import com.pricebookbr.domain.dashboard.ProdutoValorDia;

public class ProdutoValorDiaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date dtHistorico;
	private Double preco;
	
	public ProdutoValorDiaDTO() {		
	}
	
	public ProdutoValorDiaDTO(ProdutoValorDia obj) {
		this.id = obj.getId();
		this.dtHistorico = obj.getDtHistorico();
		this.preco = obj.getPreco();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDtHistorico() {
		return dtHistorico;
	}
	
	public void setDtHistorico(Date dtHistorico) {
		this.dtHistorico = dtHistorico;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}