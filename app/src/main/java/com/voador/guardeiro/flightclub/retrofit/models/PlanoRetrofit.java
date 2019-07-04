package com.voador.guardeiro.flightclub.retrofit.models;

import java.util.Date;

public class PlanoRetrofit {

    private Long Id;
    private Long id_modalidade;
    private String ds_plano;
    private Double valor;
    private Date DhInc;
    private Long IdConta;

    public PlanoRetrofit() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Date getDhInc() {
        return DhInc;
    }

    public void setDhInc(Date dhInc) {
        DhInc = dhInc;
    }

    public Long getIdConta() {
        return IdConta;
    }

    public void setIdConta(Long idConta) {
        IdConta = idConta;
    }
}
