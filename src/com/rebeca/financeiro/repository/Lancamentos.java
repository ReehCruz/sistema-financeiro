package com.rebeca.financeiro.repository;

import java.util.List;

import com.rebeca.financeiro.model.Lancamento;

public interface Lancamentos {

	public List<Lancamento> todos();
	public Lancamento comDadosIguais(Lancamento lancamento);
	public Lancamento porCodigo(Integer codigo);
	
	public Lancamento guardar(Lancamento lancamento);
	public void remover(Lancamento lancamento);

}
