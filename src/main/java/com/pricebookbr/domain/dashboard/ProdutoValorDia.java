package com.pricebookbr.domain.dashboard;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ProdutoValorDia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dtHistorico;
	
	private Double preco;
	
	public ProdutoValorDia() {
		
	}

	public ProdutoValorDia(Date dtHistorico, Double preco) {
		super();
		this.dtHistorico = dtHistorico;
		this.preco = preco;
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

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setDtHistorico(Date dtHistorico) {
		this.dtHistorico = dtHistorico;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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
		ProdutoValorDia other = (ProdutoValorDia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}