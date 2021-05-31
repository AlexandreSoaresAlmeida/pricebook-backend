package com.pricebookbr.dto;

import java.io.Serializable;
import java.util.Date;

import com.pricebookbr.domain.AvaliacaoProduto;
import com.pricebookbr.domain.Cliente;
import com.pricebookbr.domain.Produto;

public class AvaliacaoProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Produto produto;
	private Cliente cliente;
	private Date dtHoraHistorico;
	private Integer avaliacao;
	
	public AvaliacaoProdutoDTO() {
		
	}
	
	public AvaliacaoProdutoDTO(AvaliacaoProduto obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.cliente = obj.getCliente();
		this.dtHoraHistorico = obj.getDtHoraHistorico();
		this.avaliacao = obj.getAvaliacao();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDtHoraHistorico() {
		return dtHoraHistorico;
	}

	public void setDtHoraHistorico(Date dtHoraHistorico) {
		this.dtHoraHistorico = dtHoraHistorico;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}
}