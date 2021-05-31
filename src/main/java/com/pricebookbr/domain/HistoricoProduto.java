package com.pricebookbr.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(
	    name="historico_produto",
	    indexes = {
	    	@Index(name = "hist_prod_IDX_0", columnList="produto_id, cliente_id, dt_hora_historico", unique = true)
	    }
	   )	    
public class HistoricoProduto  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne  
	@JoinColumn(name="produto_id", referencedColumnName="id",nullable=false)  
	private Produto produto;  

	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id",nullable=false)  
	private Cliente cliente;  

	
	@Column(nullable=false)
	private Double preco;
	
	private Boolean precoPromocional;
	
	private Double longitude;
	private Double latitude;
	
	@Column(name="dt_hora_historico")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy@HH:mm:ss")
	private Date dtHoraHistorico;
	
	@JsonIgnore
	@OneToMany(mappedBy = "historicoProduto", cascade = CascadeType.ALL)
    private Set<LocalCompra> localCompra;
	
	private String localAumentoAbusivo;
	
	private String nomeTempProduto;
	
	public HistoricoProduto() {
		
	}

	public HistoricoProduto(
			Integer id, 
			Produto produto, 
			Cliente cliente, 
			Double preco, 
			Date dtHoraHistorico, 
			Boolean precoPromocional, 
			Double longitude, 
			Double latitude,
			String localAumentoAbusivo,
			String nomeTempProduto) {
		super();
		this.id = id;
		this.produto = produto;
		this.cliente = cliente;
		this.preco = preco;
		this.dtHoraHistorico = dtHoraHistorico;
		this.precoPromocional = precoPromocional;
		this.longitude = longitude;
		this.latitude = latitude;
		this.localAumentoAbusivo = localAumentoAbusivo;
		this.nomeTempProduto = nomeTempProduto;
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
	
	public Set<LocalCompra> getLocalCompra() {
		return localCompra;
	}

	public void setLocalCompra(Set<LocalCompra> localCompra) {
		this.localCompra = localCompra;
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
		HistoricoProduto other = (HistoricoProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}