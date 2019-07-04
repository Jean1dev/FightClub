package com.voador.guardeiro.flightclub.retrofit.models;

import java.io.Serializable;
import java.util.Date;

public class MatriculaRetrofit implements Serializable {
    private long Id;
    private long id_modalidade;
    private Date dia_vencimento;
    private Date data_encerramento;
    private Date DhInc;
    private long IdConta;

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

    public Date getDia_vencimento() {
        return dia_vencimento;
    }

    public void setDia_vencimento(Date dia_vencimento) {
        this.dia_vencimento = dia_vencimento;
    }

    public Date getData_encerramento() {
        return data_encerramento;
    }

    public void setData_encerramento(Date data_encerramento) {
        this.data_encerramento = data_encerramento;
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
