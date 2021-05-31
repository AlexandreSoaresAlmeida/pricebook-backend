package com.pricebookbr.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity    
public class LocalCompra  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne  
	@JoinColumn(name="historico_produto_id", referencedColumnName="id",nullable=false)  
	private HistoricoProduto historicoProduto;  

	@ManyToOne
	@JoinColumn(name="estabelecimento_comercial_id", referencedColumnName="id",nullable=false)  
	private EstabelecimentoComercial estabelecimentoComercial;  
	
	@Column(name="dt_hora_historico")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy@HH:mm:ss")
	private Date dtHoraHistorico;
	
	public LocalCompra() {
		
	}

	public LocalCompra(
			Integer id, 
			HistoricoProduto historicoProduto,
			EstabelecimentoComercial estabelecimentoComercial,
			Date dtHoraHistorico 
			) {
		super();
		this.id = id;
		this.historicoProduto = historicoProduto;
		this.estabelecimentoComercial = estabelecimentoComercial;
		this.dtHoraHistorico = dtHoraHistorico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HistoricoProduto getHistoricoProduto() {
		return historicoProduto;
	}

	public void setHistoricoProduto(HistoricoProduto historicoProduto) {
		this.historicoProduto = historicoProduto;
	}

	public EstabelecimentoComercial getEstabelecimentoComercial() {
		return estabelecimentoComercial;
	}

	public void setEstabelecimentoComercial(EstabelecimentoComercial estabelecimentoComercial) {
		this.estabelecimentoComercial = estabelecimentoComercial;
	}

	public Date getDtHoraHistorico() {
		return dtHoraHistorico;
	}

	public void setDtHoraHistorico(Date dtHoraHistorico) {
		this.dtHoraHistorico = dtHoraHistorico;
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
		LocalCompra other = (LocalCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}