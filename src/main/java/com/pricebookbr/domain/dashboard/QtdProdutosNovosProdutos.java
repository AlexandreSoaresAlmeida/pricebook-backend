package com.pricebookbr.domain.dashboard;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QtdProdutosNovosProdutos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	private int qtdProdutos;
	private int qtdNovosProdutos;
	
	public QtdProdutosNovosProdutos() {
		
	}

	public QtdProdutosNovosProdutos(int qtdProdutos, int qtdNovosProdutos) {
		super();
		this.qtdProdutos = qtdProdutos;
		this.qtdNovosProdutos = qtdNovosProdutos;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QtdProdutosNovosProdutos other = (QtdProdutosNovosProdutos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}