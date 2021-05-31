package com.pricebookbr.dto;

import java.io.Serializable;
import java.util.Date;

import com.pricebookbr.domain.Cliente;
import com.pricebookbr.domain.HistoricoProduto;
import com.pricebookbr.domain.Produto;

public class HistoricoProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Double preco;
	private Produto produto;
	private Cliente cliente;
	private Date dtHoraHistorico;
	private Boolean precoPromocional;
	private Double longitude;
	private Double latitude;
	private String localAumentoAbusivo;
	private String nomeTempProduto;
	
	public HistoricoProdutoDTO() {
		
	}
	
	public HistoricoProdutoDTO(HistoricoProduto obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.cliente = obj.getCliente();
		this.dtHoraHistorico = obj.getDtHoraHistorico();
		this.longitude = obj.getLongitude();
		this.latitude = obj.getLatitude();
		this.preco = obj.getPreco();
		this.precoPromocional = obj.getPrecoPromocional();
		this.localAumentoAbusivo = obj.getLocalAumentoAbusivo();
		this.nomeTempProduto = obj.getNomeTempProduto();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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

	public Boolean getPrecoPromocional() {
		return precoPromocional;
	}

	public void setPrecoPromocional(Boolean precoPromocional) {
		this.precoPromocional = precoPromocional;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getLocalAumentoAbusivo() {
		return localAumentoAbusivo;
	}

	public void setLocalAumentoAbusivo(String localAumentoAbusivo) {
		this.localAumentoAbusivo = localAumentoAbusivo;
	}

	public String getNomeTempProduto() {
		return nomeTempProduto;
	}

	public void setNomeTempProduto(String nomeTempProduto) {
		this.nomeTempProduto = nomeTempProduto;
	}
}