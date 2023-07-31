package com.sop.dto;

import lombok.Getter;

import java.util.Date;
@Getter
public class DespesaDTO {

    // Getters e setters
    @Getter
    private String numeroProtocolo;
    private String tipoDespesa;
    private Date dataProtocolo;
    private Date dataVencimento;
    private String credor;
    private String descricao;
    private double valorDespesa;
    private String status;
    private Long id;

    // Construtor com todos os atributos
    public DespesaDTO(String numeroProtocolo, String tipoDespesa, Date dataProtocolo, Date dataVencimento,
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

    public DespesaDTO() {

    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Date getDataProtocolo() {
        return dataProtocolo;
    }

    public void setDataProtocolo(Date dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
