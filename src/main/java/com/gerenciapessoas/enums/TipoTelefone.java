package com.gerenciapessoas.enums;

public enum TipoTelefone {
	
	FIXO("Fixo"),
	MOVEL("Movel"),
	COMERCIAL("Comercial");

	private final String descricao;

	public String getDescricao() {
		return descricao;
	}

	private TipoTelefone(String descricao) {
		this.descricao = descricao;
	}
	
	

}
