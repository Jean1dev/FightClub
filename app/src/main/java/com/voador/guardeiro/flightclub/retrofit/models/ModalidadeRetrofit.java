package com.voador.guardeiro.flightclub.retrofit.models;

import java.io.Serializable;
import java.util.Date;

public class ModalidadeRetrofit implements Serializable {

    private long Id;
    private String nm_modalidade;
    private Date DhInc;
    private long IdConta = 22;

    public ModalidadeRetrofit(String nm_modalidade) {
        this.nm_modalidade = nm_modalidade;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNm_modalidade() {
        return nm_modalidade;
    }

    public void setNm_modalidade(String nm_modalidade) {
        this.nm_modalidade = nm_modalidade;
    }

    public Date getDhInc() {
        return DhInc;
    }

    public void setDhInc(Date dhInc) {
        DhInc = dhInc;
    }

    public long getIdConta() {
        return IdConta;
    }

    public void setIdConta(long idConta) {
        IdConta = idConta;
    }
}
