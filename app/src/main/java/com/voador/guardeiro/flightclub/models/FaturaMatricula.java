package com.voador.guardeiro.flightclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "faturas_matriculas")
public class FaturaMatricula {

    @Id
    private Long codigoMatricula;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "data_pagamento", nullable = false)
    private Date dataPagamento;

    @Column(name = "data_vencimento", nullable = false)
    private Date dataVencimento;

    @Column(name = "data_cancelamento", nullable = false)
    private Date dataCancelamento;

    public FaturaMatricula() {
    }

    public FaturaMatricula(Long codigoMatricula, Date dataVencimento, Double valor, Date dataPagamento, Date dataCancelamento) {
        this.codigoMatricula = codigoMatricula;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataCancelamento = dataCancelamento;
    }

    public Long getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(Long codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    @Override
    public String toString() {
        return "FaturaMatricula{" +
                "codigoMatricula=" + codigoMatricula +
                ", data_vencimento=" + dataVencimento +
                ", valor=" + valor +
                ", data_pagamento=" + dataPagamento +
                ", data_cancelamento=" + dataCancelamento +
                '}';
    }
}
