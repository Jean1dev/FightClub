package com.voador.guardeiro.flightclub.retrofit.models;

import com.voador.guardeiro.flightclub.models.Modalidade;

import java.util.Date;

public class GraduacaoRetrofit {

    private Long Id;
    private Long id_modalidade;
    private String ds_graduacao;
    private Date DhInc;
    private Long IdConta;

    public GraduacaoRetrofit() {
    }

    public GraduacaoRetrofit(String descricao, ModalidadeRetrofit modalidade) {
        this.ds_graduacao = descricao;
        this.id_modalidade = modalidade.getId();
        this.IdConta = 22L;
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

    public String getDs_graduacao() {
        return ds_graduacao;
    }

    public void setDs_graduacao(String ds_graduacao) {
        this.ds_graduacao = ds_graduacao;
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
