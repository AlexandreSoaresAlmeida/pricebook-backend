package com.pricebookbr.dto.dashboard;

import java.io.Serializable;

import com.pricebookbr.domain.dashboard.QtdProdutosNovosProdutos;

public class QtdProdutosNovosProdutosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private int qtdProdutos;
	private int qtdNovosProdutos;
	
	public QtdProdutosNovosProdutosDTO() {		
	}
	
	public QtdProdutosNovosProdutosDTO(QtdProdutosNovosProdutos obj) {
		this.id = obj.getId();
		this.qtdProdutos = obj.getQtdProdutos();
		this.qtdNovosProdutos = obj.getQtdNovosProdutos();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(int qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	public int getQtdNovosProdutos() {
		return qtdNovosProdutos;
	}

	public void setQtdNovosProdutos(int qtdNovosProdutos) {
		this.qtdNovosProdutos = qtdNovosProdutos;
	}
}