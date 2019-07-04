package com.voador.guardeiro.flightclub.retrofit.models;

import java.io.Serializable;
import java.util.Date;

public class MatriculModalidadeRetrofit implements Serializable {
    private long Id;
    private long id_modalidade;
    private long id_matricula;
    private long id_graduacao;
    private long id_plano;
    private Date data_inicio;
    private Date data_fim;
    private Date DhInc;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(long id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public long getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(long id_matricula) {
        this.id_matricula = id_matricula;
    }

    public long getId_graduacao() {
        return id_graduacao;
    }

    public void setId_graduacao(long id_graduacao) {
        this.id_graduacao = id_graduacao;
    }

    public long getId_plano() {
        return id_plano;
    }

    public void setId_plano(long id_plano) {
        this.id_plano = id_plano;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Date getDhInc() {
        return DhInc;
    }

    public void setDhInc(Date dhInc) {
        DhInc = dhInc;
    }
}
