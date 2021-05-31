package com.pricebookbr.dto;

import java.io.Serializable;
import java.util.Date;

import com.pricebookbr.domain.Configuracao;

public class ConfiguracaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
//	@NotEmpty(message="Preenchimento obrigatório")
//	@Length(min=5, max=10, message="O tamanho deve estar entre 5 e 10 caracteres")
	private String versao;
	
//	@NotNull
	private Date dtHoraHistorico;	
	
	public ConfiguracaoDTO() {		
	}
	
	public ConfiguracaoDTO(Configuracao obj) {
		this.id = obj.getId();
		this.versao = obj.getVersao();
		this.dtHoraHistorico = obj.getDtHoraHistorico();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Date getDtHoraHistorico() {
		return dtHoraHistorico;
	}

	public void setDtHoraHistorico(Date dtHoraHistorico) {
		this.dtHoraHistorico = dtHoraHistorico;
	}
}