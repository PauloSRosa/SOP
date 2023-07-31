package com.sop.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empenho_id", nullable = false)
    private Empenho empenho;

    @Column(nullable = false)
    private int anoPagamento;

    @Column(nullable = false)
    private String numeroPagamento;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataPagamento;

    @Column(nullable = false)
    private double valorPagamento;

    private String observacao;

    // Construtores
    public Pagamento() {
    }

    public Pagamento(Empenho empenho, int anoPagamento, String numeroPagamento, Date dataPagamento,
                     double valorPagamento, String observacao) {
        this.empenho = empenho;
        this.anoPagamento = anoPagamento;
        this.numeroPagamento = numeroPagamento;
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
        this.observacao = observacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empenho getEmpenho() {
        return empenho;
    }

    public void setEmpenho(Empenho empenho) {
        this.empenho = empenho;
    }

    public int getAnoPagamento() {
        return anoPagamento;
    }

    public void setAnoPagamento(int anoPagamento) {
        this.anoPagamento = anoPagamento;
    }

    public String getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(String numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}