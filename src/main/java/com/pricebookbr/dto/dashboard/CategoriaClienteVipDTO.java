package com.pricebookbr.dto.dashboard;

import java.io.Serializable;

import com.pricebookbr.domain.dashboard.CategoriaClienteVip;

public class CategoriaClienteVipDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String classificacao;
	private int qtd;
	
	public CategoriaClienteVipDTO() {		
	}
	
	public CategoriaClienteVipDTO(CategoriaClienteVip obj) {
		this.id = obj.getId();
		this.classificacao = obj.getClassificacao();
		this.qtd = obj.getQtd();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
}