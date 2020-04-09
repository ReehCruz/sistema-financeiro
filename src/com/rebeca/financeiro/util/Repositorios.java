package com.rebeca.financeiro.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.rebeca.financeiro.repository.Lancamentos;
import com.rebeca.financeiro.repository.Pessoas;
import com.rebeca.financeiro.repository.infra.LancamentosHibernate;
import com.rebeca.financeiro.repository.infra.PessoasHibernate;

public class Repositorios implements Serializable{
	
	public Pessoas getPessoas() {
		return new PessoasHibernate(this.getSession());
	}
	
	public Lancamentos getLancamentos() {
		return new LancamentosHibernate(this.getSession());
	}
	
	private Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}

}
