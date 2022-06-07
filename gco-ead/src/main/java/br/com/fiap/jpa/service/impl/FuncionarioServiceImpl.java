package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.FuncionarioDAOImpl;
import br.com.fiap.jpa.entity.Funcionario;
import br.com.fiap.jpa.service.GenericService;

public class FuncionarioServiceImpl extends GenericService<Funcionario, Long>{
	
	private static FuncionarioServiceImpl instance = null;
	
	private FuncionarioDAOImpl dao;
	
	private FuncionarioServiceImpl() {
		dao = FuncionarioDAOImpl.getInstance();
	}
	
	public static FuncionarioServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new FuncionarioServiceImpl();
		}
		
		return instance;
	}


	@Override
	public void cadastrar(Funcionario instance) {
		try {
			dao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}


	@Override
	public void atualizar(Funcionario instance) {
		try {
			dao.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}


	@Override
	public void remover(Long id) {
		try {
			dao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}


	@Override
	public Funcionario obter(Long id) {
		Funcionario funcionario = null;
		try {
			funcionario = dao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return funcionario;
	}


	@Override
	public List<Funcionario> listar() {
		List<Funcionario> funcionarios = null;
		try {
			funcionarios = dao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return funcionarios;
	}
}
