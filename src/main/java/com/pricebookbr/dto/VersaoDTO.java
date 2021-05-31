package com.pricebookbr.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.pricebookbr.domain.Cliente;
import com.pricebookbr.domain.Versao;

public class VersaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=10, message="O tamanho deve estar entre 5 e 10 caracteres")
	private String versao;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Date data;
	
	private Cliente cliente;
	
	public VersaoDTO() {
	}
	
	public VersaoDTO(Versao obj) {
		this.versao = obj.getVersao();
		this.data = obj.getData();
		this.cliente = obj.getCliente();
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

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}