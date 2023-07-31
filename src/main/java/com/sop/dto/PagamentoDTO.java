package com.sop.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class PagamentoDTO {
    // Getters e setters
    private int anoPagamento;
    private String numeroPagamento;
    private Date dataPagamento;
    private double valorPagamento;
    private String observacao;

    public PagamentoDTO() {

    }

    // Construtor com todos os atributos
    public PagamentoDTO(int anoPagamento, String numeroPagamento, Date dataPagamento, double valorPagamento,
                        String observacao) {
        this.anoPagamento = anoPagamento;
        this.numeroPagamento = numeroPagamento;
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
        this.observacao = observacao;
    }


    public void setAnoPagamento(int anoPagamento) {
        this.anoPagamento = anoPagamento;
    }

    public void setNumeroPagamento(String numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
