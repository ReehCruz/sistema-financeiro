package com.rebeca.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.rebeca.financeiro.model.Lancamento;
import com.rebeca.financeiro.util.FacesUtil;
import com.rebeca.financeiro.util.HibernateUtil;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {
	
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		Session session = HibernateUtil.getSession();
		
		this.lancamentos = session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento"))
				.list();
		
		session.close();
	}
	
	public void excluir() {
		if (this.lancamentoSelecionado.isPago()) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lan�amento j� foi pago e n�o pode ser exclu�do.");
		} else {
			Session session = HibernateUtil.getSession();
			Transaction trx = session.beginTransaction();
			
			session.delete(this.lancamentoSelecionado);
			
			trx.commit();
			session.close();
			
			this.inicializar();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lan�amento exclu�do com sucesso!");
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
