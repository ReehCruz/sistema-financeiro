package com.rebeca.financeiro.service;

import com.rebeca.financeiro.model.Lancamento;
import com.rebeca.financeiro.repository.Lancamentos;

public class GestaoLancamentos {
	
	private Lancamentos lancamentos;
	
	public GestaoLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public void salvar(Lancamento lancamento) throws RegraNegocioException {
		if (existeLancamentoSemelhante(lancamento)) {
			throw new RegraNegocioException("J� existe um lan�amento igual a este.");
		}
		
		this.lancamentos.guardar(lancamento);
	}
	
	private boolean existeLancamentoSemelhante(Lancamento lancamento) {
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);
		
		return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
	}
	
	public void excluir(Lancamento lancamento) throws RegraNegocioException {
		if (lancamento.isPago()) {
			throw new RegraNegocioException("Lan�amento pago n�o pode ser exclu�do.");
		}
		
		this.lancamentos.remover(lancamento);
	}
}
