package com.pricebookbr.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(
	    name="avaliacao_produto",
	    indexes = {
	    	@Index(name = "aval_prod_IDX_0", columnList="produto_id, cliente_id, dt_hora_historico", unique = true)
	    }
	   )	    
public class AvaliacaoProduto  implements Serializable {
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
	
	@Column(name="dt_hora_historico")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy@HH:mm:ss")
	private Date dtHoraHistorico;
	
	private Integer avaliacao;
	
	public AvaliacaoProduto() {
		
	}

	public AvaliacaoProduto(
			Integer id, 
			Produto produto, 
			Cliente cliente, 
			Date dtHoraHistorico,
			Integer avaliacao
			) {
		super();
		this.id = id;
		this.produto = produto;
		this.cliente = cliente;
		this.dtHoraHistorico = dtHoraHistorico;
		this.avaliacao = avaliacao;
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
		AvaliacaoProduto other = (AvaliacaoProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}