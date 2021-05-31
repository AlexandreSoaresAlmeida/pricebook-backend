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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HistoricoAcesso  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id",nullable=false)  
	private Cliente cliente;  

	@Column(name="dt_hora_historico")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy@HH:mm:ss")
	private Date dtHoraHistorico;
	
	public HistoricoAcesso() {
		
	}

	public HistoricoAcesso(
			Integer id, 
			Cliente cliente, 
			Date dtHoraHistorico 
			) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.dtHoraHistorico = dtHoraHistorico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		HistoricoAcesso other = (HistoricoAcesso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}