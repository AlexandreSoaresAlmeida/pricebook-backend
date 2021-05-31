package com.pricebookbr.dto;

import java.io.Serializable;
import java.util.Date;

import com.pricebookbr.domain.Cliente;
import com.pricebookbr.domain.HistoricoAcesso;

public class HistoricoAcessoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Cliente cliente;
	private Date dtHoraHistorico;
	private String email;
	
	public HistoricoAcessoDTO() {
		
	}
	
	public HistoricoAcessoDTO(HistoricoAcesso obj) {
		super();
		this.id = obj.getId();
		this.cliente = obj.getCliente();
		this.dtHoraHistorico = obj.getDtHoraHistorico();
	}
	
	public HistoricoAcessoDTO(Integer id, Cliente cliente, Date dtHoraHistorico) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}