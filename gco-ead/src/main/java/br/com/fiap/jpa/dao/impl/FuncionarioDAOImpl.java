package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Funcionario;

public class FuncionarioDAOImpl extends HibernateGenericDAO<Funcionario, Long> {
	
	private static FuncionarioDAOImpl instance = null;
	
	private FuncionarioDAOImpl() {
		super(Funcionario.class);
	}
	
	public static FuncionarioDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new FuncionarioDAOImpl();
		}
		
		return instance;
	}
}
