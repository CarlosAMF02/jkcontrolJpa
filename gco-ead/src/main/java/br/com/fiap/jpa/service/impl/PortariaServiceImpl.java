package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.PortariaDAOImpl;
import br.com.fiap.jpa.entity.Portaria;
import br.com.fiap.jpa.service.GenericService;

public class PortariaServiceImpl extends GenericService<Portaria, Long>{
	
	private static PortariaServiceImpl instance = null;
	
	private PortariaDAOImpl dao;
	
	private PortariaServiceImpl() {
		dao = PortariaDAOImpl.getInstance();
	}
	
	public static PortariaServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new PortariaServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Portaria instance) {
		try {
			dao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}


	@Override
	public void atualizar(Portaria instance) {
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
	public Portaria obter(Long id) {
		Portaria portaria = null;
		try {
			portaria = dao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return portaria;
	}


	@Override
	public List<Portaria> listar() {
		List<Portaria> portarias = null;
		try {
			portarias = dao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return portarias;
	}
}
