package br.com.fiap.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.fiap.jpa.entity.Condominio;
import br.com.fiap.jpa.entity.Funcionario;
import br.com.fiap.jpa.entity.MovimentacaoPortaria;
import br.com.fiap.jpa.entity.Portaria;
import br.com.fiap.jpa.entity.Visitante;
import br.com.fiap.jpa.service.impl.CondominioServiceImpl;
import br.com.fiap.jpa.service.impl.FuncionarioServiceImpl;
import br.com.fiap.jpa.service.impl.MovimentacaoPortariaServiceImpl;
import br.com.fiap.jpa.service.impl.PortariaServiceImpl;
import br.com.fiap.jpa.service.impl.VisitanteServiceImpl;

public class Main {
	public static void main(String[] args) {
		CondominioServiceImpl condominioServiceImpl = CondominioServiceImpl.getInstance();
		PortariaServiceImpl portariaServiceImpl = PortariaServiceImpl.getInstance();
		FuncionarioServiceImpl funcionarioServiceImpl = FuncionarioServiceImpl.getInstance();
		VisitanteServiceImpl visitanteServiceImpl = VisitanteServiceImpl.getInstance();
		MovimentacaoPortariaServiceImpl movimentacaoPortariaServiceImpl = MovimentacaoPortariaServiceImpl.getInstance();
		
		Condominio condominio = new Condominio("02.284.405/0001-24", "Condominio Texas Verticais", "Condominio Texas", LocalDate.of(2002, 1,2));
		
		/**
		 * Cadastra um condomínio
		 */
		condominioServiceImpl.cadastrar(condominio);
		
		Portaria portaria1 = new Portaria(condominio, 1, "Principal", 1, LocalDate.of(2022, 1, 10), LocalDate.of(2022, 10, 27));
		Portaria portaria2 = new Portaria(condominio, 2, "Serviço", 1, LocalDate.of(2022, 1, 10), LocalDate.of(2022, 10, 27));
		
		/**
		 * Cadastro de 2 portarias
		 */
		portariaServiceImpl.cadastrar(portaria1);
		portariaServiceImpl.cadastrar(portaria2);
		
		/**
		 * Busca os funcionarios com id 1 e 2
		 */
		Funcionario funcionario1 = funcionarioServiceImpl.obter(1L);
		Funcionario funcionario2 = funcionarioServiceImpl.obter(2L);
		
		/**
		 * Busca os visitantes com id 1 e 2
		 */
		Visitante visitante1 = visitanteServiceImpl.obter(1L);
		Visitante visitante2 = visitanteServiceImpl.obter(2L);
		
		MovimentacaoPortaria movimentacaoPortaria1 = new MovimentacaoPortaria(portaria1, funcionario1, visitante1, "E", LocalDateTime.of(LocalDate.of(2022, 6, 1), LocalTime.of(15, 0)));
		MovimentacaoPortaria movimentacaoPortaria2 = new MovimentacaoPortaria(portaria1, funcionario1, visitante2, "E", LocalDateTime.of(LocalDate.of(2022, 6, 1), LocalTime.of(15, 30)));
		MovimentacaoPortaria movimentacaoPortaria3 = new MovimentacaoPortaria(portaria1, funcionario2, visitante1, "S", LocalDateTime.of(LocalDate.of(2022, 6, 1), LocalTime.of(15, 45)));
		
		/**
		 * Cadastra 3 movimentacoes
		 */
		movimentacaoPortariaServiceImpl.cadastrar(movimentacaoPortaria1);
		movimentacaoPortariaServiceImpl.cadastrar(movimentacaoPortaria2);
		movimentacaoPortariaServiceImpl.cadastrar(movimentacaoPortaria3);
		
		/**
		 * Lista de movimentacoes com tipo E
		 */
		 List<MovimentacaoPortaria> movimentacoes = movimentacaoPortariaServiceImpl.listarPorTipo("E");
		 
		 movimentacoes.forEach(System.out::println);
		 
		 /**
		  * Pesquisa de vistantes com nome João e cpf 111.111.111-11
		  */
		 List<Visitante> visitantes = visitanteServiceImpl.pesquisar("João", "111.111.111-11", null);
		 
		 visitantes.forEach(System.out::println);
	}
}
