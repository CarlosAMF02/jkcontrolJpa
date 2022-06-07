package br.com.fiap.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_gco_movimentacao_portaria")
@SequenceGenerator(name = "movimentacao", sequenceName = "sq_t_gco_movimentacao_portaria", allocationSize = 1)
public class MovimentacaoPortaria implements Serializable {

	private static final long serialVersionUID = 2653059513563075799L;

	public MovimentacaoPortaria () {}

    public MovimentacaoPortaria(Portaria portaria, Funcionario funcionario, Visitante visitante, String tipo, LocalDateTime dataMovimentacao) {
        this.portaria = portaria;
        this.funcionario = funcionario;
        this.visitante = visitante;
        this.tipo = tipo;
        this.dataMovimentacao = dataMovimentacao;
    }

    @Id
    @Column(name = "id_movimentacao")
    @GeneratedValue(generator = "movimentacao", strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_portaria")
    private Portaria portaria;

    @ManyToOne
    @JoinColumn(name = "id_func_portaria")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_visitante")
    private Visitante visitante;

    @Column(name = "tp_movimentacao", length = 1)
    private String tipo;

    @Column(name = "dt_movimentacao")
    private LocalDateTime dataMovimentacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Portaria getPortaria() {
        return portaria;
    }

    public void setPortaria(Portaria portaria) {
        this.portaria = portaria;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    @Override
    public String toString() {
        return "MovimentacaoPortaria{" +
                "id=" + id +
                ", portaria=" + portaria +
                ", funcionario=" + funcionario +
                ", visitante=" + visitante +
                ", tipo='" + tipo + '\'' +
                ", dataMovimentacao=" + dataMovimentacao +
                '}';
    }
}
