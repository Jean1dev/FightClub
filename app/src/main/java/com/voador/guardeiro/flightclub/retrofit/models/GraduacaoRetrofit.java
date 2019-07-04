package com.voador.guardeiro.flightclub.retrofit.models;

import com.voador.guardeiro.flightclub.models.Modalidade;

import java.util.Date;

public class GraduacaoRetrofit {

    private Long id;
    private Long id_modalidade;
    private String ds_graduacao;
    private Date Dhinc;
    private Long idConta;

    public GraduacaoRetrofit() {
    }

    public GraduacaoRetrofit(String descricao, ModalidadeRetrofit modalidade) {
        this.ds_graduacao = descricao;
        this.id_modalidade = modalidade.getId();
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

    public String getDs_graduacao() {
        return ds_graduacao;
    }

    public void setDs_graduacao(String ds_graduacao) {
        this.ds_graduacao = ds_graduacao;
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
