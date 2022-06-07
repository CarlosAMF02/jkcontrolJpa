package br.com.fiap.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_gco_visitante")
@SequenceGenerator(name = "visitante", sequenceName = "sq_t_gco_visitante", allocationSize = 1)
public class Visitante implements Serializable {

	private static final long serialVersionUID = 416493838279835891L;

	public Visitante(){}

    public Visitante(long id, String nome, LocalDateTime dataNascimento, String cpf, String rg, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.dataCadastro = dataCadastro;
    }

    @Id
    @Column(name = "id_visitante")
    @GeneratedValue(generator = "visitante", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "nm_visitante", length = 30)
    private String nome;

    @Column(name = "dt_nasc")
    private LocalDateTime dataNascimento;

    @Column(name = "nr_cpf", length = 15)
    private String cpf;

    @Column(name = "nr_rg", length = 15)
    private String rg;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
