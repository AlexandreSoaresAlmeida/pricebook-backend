package com.pricebookbr.dto.dashboard;

import java.io.Serializable;
import java.util.Date;

import com.pricebookbr.domain.dashboard.QtdAcessosDia;

public class QtdAcessosDiaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date dtHistorico;
	private int qtdAcessos;
	private int qtdRegistros;
	
	public QtdAcessosDiaDTO() {		
	}
	
	public QtdAcessosDiaDTO(QtdAcessosDia obj) {
		this.id = obj.getId();
		this.dtHistorico = obj.getDtHistorico();
		this.qtdAcessos = obj.getQtd();
		this.qtdRegistros = obj.getQtdRegistros();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDtHistorico() {
		return dtHistorico;
	}
	
	public void setDtHistorico(Date dtHistorico) {
		this.dtHistorico = dtHistorico;
	}
	
	public int getQtdAcessos() {
		return qtdAcessos;
	}

	public void setQtdAcessos(int qtdAcessos) {
		this.qtdAcessos = qtdAcessos;
	}

	public int getQtdRegistros() {
		return qtdRegistros;
	}

	public void setQtdRegistros(int qtdRegistros) {
		this.qtdRegistros = qtdRegistros;
	}
}