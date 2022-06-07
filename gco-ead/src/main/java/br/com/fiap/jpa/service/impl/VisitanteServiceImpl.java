package br.com.fiap.jpa.service.impl;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.jpa.dao.impl.VisitanteDAOImpl;
import br.com.fiap.jpa.entity.Visitante;
import br.com.fiap.jpa.service.GenericService;

public class VisitanteServiceImpl extends GenericService<Visitante, Long>{
	
	private static VisitanteServiceImpl instance = null;
	
	private VisitanteDAOImpl dao;
	
	private VisitanteServiceImpl() {
		dao = VisitanteDAOImpl.getInstance();
	}
	
	public static VisitanteServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new VisitanteServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Visitante instance) {
		try {
			dao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}


	@Override
	public void atualizar(Visitante instance) {
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
	public Visitante obter(Long id) {
		Visitante visitante = null;
		try {
			visitante = dao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return visitante;
	}


	@Override
	public List<Visitante> listar() {
		List<Visitante> visitantes = null;
		try {
			visitantes = dao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return visitantes;
	}
	
	public List<Visitante> pesquisar(String nome, String cpf, LocalDate dataCadastro) {
		List<Visitante> visitantes = null;
		try {
			visitantes = dao.pesquisar(nome, cpf, dataCadastro,getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return visitantes;
	}
}
