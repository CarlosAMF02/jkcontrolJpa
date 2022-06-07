package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_portaria")
@SequenceGenerator(name = "portaria", sequenceName = "sq_t_gco_portaria", allocationSize = 1)
public class Portaria implements Serializable {
	
	private static final long serialVersionUID = 1601802195338413928L;
	
	public Portaria() {}
	
	public Portaria(Condominio condominio, int numeroPortaria, String nomePortaria, int status, LocalDate dataInicio, LocalDate dataTermino) {
		this.condominio = condominio;
		this.numeroPortaria = numeroPortaria;
		this.nomePortaria = nomePortaria;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	@Id
	@Column(name = "id_portaria")
	@GeneratedValue(generator = "portaria", strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_condominio")
	private Condominio condominio;
	
	@Column(name = "nr_portaria")
	private int numeroPortaria;
	
	@Column(name = "nm_portaria")
	private String nomePortaria;
	
	@Column(name = "st_status")
	private int status;
	
	@Column(name = "dt_inicio")
	private LocalDate dataInicio;
	
	@Column(name = "dt_termino")
	private LocalDate dataTermino;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	
	public int getNumeroPortaria() {
		return numeroPortaria;
	}

	public void setNumeroPortaria(int numeroPortaria) {
		this.numeroPortaria = numeroPortaria;
	}
	
	public String getNomePortaria() {
		return nomePortaria;
	}

	public void setNomePortaria(String nomePortaria) {
		this.nomePortaria = nomePortaria;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	@Override
	public String toString() {
		return "\nNome Portaria: " + this.getNomePortaria()
			+ "\nNumero Portaria: " + this.getNumeroPortaria()
			+ "\nNome Status: " + this.getStatus()
			+ "\nData Inicio: "+this.getDataInicio()
			+ "\nData Termino: "+this.getDataTermino();
	}
}
