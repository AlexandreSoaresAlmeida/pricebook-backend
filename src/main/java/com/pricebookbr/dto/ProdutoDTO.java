package com.pricebookbr.dto;

import java.io.Serializable;
import java.util.Date;

import com.pricebookbr.domain.Cliente;
import com.pricebookbr.domain.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	private String barcode;
	private String unidadeMedida;
	private String urlInternet;
	private Cliente cliente;
	private Date dtHoraHistorico;
	private Integer situacaoImagem;
	private Integer imagemNaoCorrespondente;
	
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
		this.preco = obj.getPreco();
		this.barcode = obj.getBarcode();
		this.unidadeMedida = obj.getUnidadeMedida();
		this.urlInternet = obj.getUrlInternet();
		this.cliente = obj.getCliente();
		this.dtHoraHistorico = obj.getDtHoraHistorico();
		this.situacaoImagem = (obj.getSituacaoImagem() ==  null) ? null : obj.getSituacaoImagem();
		this.imagemNaoCorrespondente = obj.getImagemNaoCorrespondente();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
		
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getUrlInternet() {
		return urlInternet;
	}

	public void setUrlInternet(String urlInternet) {
		this.urlInternet = urlInternet;
	}

	public Date getDtHoraHistorico() {
		return dtHoraHistorico;
	}

	public void setDtHoraHistorico(Date dtHoraHistorico) {
		this.dtHoraHistorico = dtHoraHistorico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getSituacaoImagem() {
		return situacaoImagem;
	}

	public void setSituacaoImagem(Integer situacaoImagem) {
		this.situacaoImagem = situacaoImagem;
	}

	public Integer getImagemNaoCorrespondente() {
		return imagemNaoCorrespondente;
	}

	public void setImagemNaoCorrespondente(Integer imagemNaoCorrespondente) {
		this.imagemNaoCorrespondente = imagemNaoCorrespondente;
	}
}