package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.MovimentacaoPortariaDAOImpl;
import br.com.fiap.jpa.entity.MovimentacaoPortaria;
import br.com.fiap.jpa.service.GenericService;

public class MovimentacaoPortariaServiceImpl extends GenericService<MovimentacaoPortaria, Long>{
	
	private static MovimentacaoPortariaServiceImpl instance = null;
	
	private MovimentacaoPortariaDAOImpl dao;
	
	private MovimentacaoPortariaServiceImpl() {
		dao = MovimentacaoPortariaDAOImpl.getInstance();
	}
	
	public static MovimentacaoPortariaServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new MovimentacaoPortariaServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(MovimentacaoPortaria instance) {
		try {
			dao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}


	@Override
	public void atualizar(MovimentacaoPortaria instance) {
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
	public MovimentacaoPortaria obter(Long id) {
		MovimentacaoPortaria movimentacao = null;
		try {
			movimentacao = dao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return movimentacao;
	}


	@Override
	public List<MovimentacaoPortaria> listar() {
		List<MovimentacaoPortaria> movimentacoes = null;
		try {
			movimentacoes = dao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return movimentacoes;
	}
	
	public List<MovimentacaoPortaria> listarPorTipo(String tipo) {
		List<MovimentacaoPortaria> movimentacoes = null;
		try {
			movimentacoes = dao.listarPorTipo(tipo ,getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return movimentacoes;
	}
}
