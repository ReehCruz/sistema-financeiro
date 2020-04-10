package com.rebeca.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.rebeca.financeiro.model.Lancamento;
import com.rebeca.financeiro.repository.Lancamentos;
import com.rebeca.financeiro.service.GestaoLancamentos;
import com.rebeca.financeiro.service.RegraNegocioException;
import com.rebeca.financeiro.util.FacesUtil;
import com.rebeca.financeiro.util.Repositorios;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {
	
	private Repositorios repositorios = new Repositorios();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	
	@PostConstruct
	public void inicializar() {
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		this.lancamentos = lancamentos.todos();
	}
	
	public void excluir() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.excluir(this.lancamentoSelecionado);
			
			this.inicializar();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento excluído com sucesso!");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}
	
}
