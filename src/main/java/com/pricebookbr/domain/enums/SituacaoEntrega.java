package com.pricebookbr.domain.enums;

public enum SituacaoEntrega {

	PEDIDO_REGISTRADO(1, "SITUACAO_PEDIDO_REGISTRADO"),
	PEDIDO_SEPARADO(2, "SITUACAO_PEDIDO_SEPARADO"),
	PEDIDO_ENTREGUE_AO_TRANSPORTE(3, "SITUACAO_PEDIDO_ENTREGUE_AO_TRANSPORTE"),
	PEDIDO_EM_DESLOCAMENTO(4, "SITUACAO_PEDIDO_EM_DESLOCAMENTO"),
	PEDIDO_SEGUINDO_PARA_ENTREGA(5, "SITUACAO_PEDIDO_SEGUINDO_PARA_ENTREGA"),
	PEDIDO_ENTREGUE(6, "SITUACAO_PEDIDO_ENTREGUE");

private int cod;
private String descricao;

private SituacaoEntrega(int cod, String descricao) {
	this.cod = cod;
	this.descricao = descricao;
}

public int getCod() {
	return cod;
}

public String getDescricao() {
	return descricao;
}

public static SituacaoEntrega toEnum(Integer cod) {
	if (cod == null) {
		return null;
	}
	
	for (SituacaoEntrega x : SituacaoEntrega.values()) {
		if (cod.equals(x.getCod()))
			return x;
	}
	
	throw new IllegalArgumentException("Id inválido: " + cod);
}
}