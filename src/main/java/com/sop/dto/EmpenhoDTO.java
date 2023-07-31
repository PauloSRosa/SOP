package com.sop.dto;

import java.util.Date;

public class EmpenhoDTO {
    private int anoEmpenho;
    private String numeroEmpenho;
    private Date dataEmpenho;
    private double valorEmpenho;
    private String observacao;
    private String status;

    // Construtores, getters e setters

    // Construtor padrão
    public EmpenhoDTO() {
    }

    // Construtor com todos os atributos
    public EmpenhoDTO(int anoEmpenho, String numeroEmpenho, Date dataEmpenho, double valorEmpenho,
                      String observacao, String status) {
        this.anoEmpenho = anoEmpenho;
        this.numeroEmpenho = numeroEmpenho;
        this.dataEmpenho = dataEmpenho;
        this.valorEmpenho = valorEmpenho;
        this.observacao = observacao;
        this.status = status;
    }

    // Getters e setters
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
