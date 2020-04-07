package com.rebeca.financeiro.model;

public enum TipoLancamento {	
	
	RECEITA("Receita"),
	DESPESA("Despesa");
	
	private String descricao;

	TipoLancamento(String decricao){
		this.descricao = decricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}
