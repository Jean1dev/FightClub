package com.voador.guardeiro.flightclub.retrofit.models;

import java.util.Date;

public class PlanoRetrofit {

    private Long id;
    private Long id_modalidade;
    private String ds_plano;
    private Double valor;
    private Date Dhinc;
    private Long idConta;

    public PlanoRetrofit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(Long id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public String getDs_plano() {
        return ds_plano;
    }

    public void setDs_plano(String ds_plano) {
        this.ds_plano = ds_plano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDhinc() {
        return Dhinc;
    }

    public void setDhinc(Date dhinc) {
        Dhinc = dhinc;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }
}
