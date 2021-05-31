package com.pricebookbr.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Versao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String versao;
	
	@JsonIgnore
	private Date data;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id",nullable=false)  
	private Cliente cliente; 
	
	public Versao() {}

	public Versao(
			String versao, 
			Date data, 
			Cliente cliente
			) {
		super();
		this.versao = versao;
		this.data = data;
		this.cliente = cliente;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Date getData() {
		return data;
	}

	public void setDate(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
		Versao other = (Versao) obj;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}
}
