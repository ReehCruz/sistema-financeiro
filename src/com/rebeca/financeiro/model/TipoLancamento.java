package com.rebeca.financeiro.model;

public enum TipoLancamento {	
	
	RECEITA("Receita"),
	DESPESA("Despesa"),
	INVESTIMENTO("Investimento");
	
	private String descricao;

	TipoLancamento(String decricao){
		this.descricao = decricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}
