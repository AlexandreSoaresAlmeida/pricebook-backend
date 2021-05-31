package com.pricebookbr.domain.enums;

public enum SituacaoImagem {
	NAOCARREGADA(1, "Não Carregada"),
	NAOENCONTRADA(2, "Não Encontrada"),
	ENCONTRADA(3, "Encontrada");
	
	private int cod;
	private String descricao;
	
	private SituacaoImagem(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static SituacaoImagem toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (SituacaoImagem x : SituacaoImagem.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}