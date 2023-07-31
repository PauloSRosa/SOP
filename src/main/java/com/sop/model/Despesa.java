package com.sop.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Entity
public class Despesa {

    // Getters e Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numeroProtocolo;

    @Column(nullable = false)
    private String tipoDespesa;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataProtocolo;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataVencimento;

    @Column(nullable = false)
    private String credor;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double valorDespesa;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "despesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empenho> empenhos;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos;

    public Despesa() {
    }

    public Despesa(String numeroProtocolo, String tipoDespesa, Date dataProtocolo, Date dataVencimento,
                   String credor, String descricao, double valorDespesa, String status) {
        this.numeroProtocolo = numeroProtocolo;
        this.tipoDespesa = tipoDespesa;
        this.dataProtocolo = dataProtocolo;
        this.dataVencimento = dataVencimento;
        this.credor = credor;
        this.descricao = descricao;
        this.valorDespesa = valorDespesa;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public void setDataProtocolo(Date dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorDespesa(double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}