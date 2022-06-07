package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.CondominioDAOImpl;
import br.com.fiap.jpa.entity.Condominio;
import br.com.fiap.jpa.service.GenericService;

public class CondominioServiceImpl extends GenericService<Condominio, Long>{
	
	private static CondominioServiceImpl instance = null;
	
	private CondominioDAOImpl dao;
	
	private CondominioServiceImpl() {
		dao = CondominioDAOImpl.getInstance();
	}
	
	public static CondominioServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new CondominioServiceImpl();
		}
		
		return instance;
	}


	@Override
	public void cadastrar(Condominio instance) {
		try {
			dao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}


	@Override
	public void atualizar(Condominio instance) {
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
	public Condominio obter(Long id) {
		Condominio condominio = null;
		try {
			condominio = dao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return condominio;
	}


	@Override
	public List<Condominio> listar() {
		List<Condominio> condominios = null;
		try {
			condominios = dao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return condominios;
	}
}
