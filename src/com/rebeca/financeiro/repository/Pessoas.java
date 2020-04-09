package com.rebeca.financeiro.repository;

import java.util.List;

import com.rebeca.financeiro.model.Pessoa;

public interface Pessoas {

	public List<Pessoa> todas();
	public Pessoa porCodigo(Integer codigo);

}
