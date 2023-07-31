package com.sop.model;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Empenho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "despesa_id", nullable = false)
    private Despesa despesa;

    @Column(nullable = false)
    private int anoEmpenho;

    @Column(nullable = false)
    private String numeroEmpenho;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataEmpenho;

    @Column(nullable = false)
    private double valorEmpenho;

    private String observacao;

    @Column(nullable = false)
    private String status;

    // Construtores, getters e setters

    // Construtores
    public Empenho() {
    }

    public Empenho(Despesa despesa, int anoEmpenho, String numeroEmpenho, Date dataEmpenho, double valorEmpenho,
                   String observacao, String status) {
        this.despesa = despesa;
        this.anoEmpenho = anoEmpenho;
        this.numeroEmpenho = numeroEmpenho;
        this.dataEmpenho = dataEmpenho;
        this.valorEmpenho = valorEmpenho;
        this.observacao = observacao;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public int getAnoEmpenho() {
        return anoEmpenho;
    }

    public void setAnoEmpenho(int anoEmpenho) {
        this.anoEmpenho = anoEmpenho;
    }

    public String getNumeroEmpenho() {
        return numeroEmpenho;
    }

    public void setNumeroEmpenho(String numeroEmpenho) {
        this.numeroEmpenho = numeroEmpenho;
    }

    public Date getDataEmpenho() {
        return dataEmpenho;
    }

    public void setDataEmpenho(Date dataEmpenho) {
        this.dataEmpenho = dataEmpenho;
    }

    public double getValorEmpenho() {
        return valorEmpenho;
    }

    public void setValorEmpenho(double valorEmpenho) {
        this.valorEmpenho = valorEmpenho;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}