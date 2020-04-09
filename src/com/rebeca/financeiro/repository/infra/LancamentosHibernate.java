package com.rebeca.financeiro.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.rebeca.financeiro.model.Lancamento;
import com.rebeca.financeiro.repository.Lancamentos;

public class LancamentosHibernate implements Lancamentos {

	private Session session;
	
	public LancamentosHibernate(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> todos() {
		return session.createCriteria(Lancamento.class)
			.addOrder(Order.desc("dataVencimento"))
			.list();
	}

	@Override
	public Lancamento guardar(Lancamento lancamento) {
		return (Lancamento) session.merge(lancamento);
	}

	@Override
	public void remover(Lancamento lancamento) {
		this.session.delete(lancamento);
	}

}
