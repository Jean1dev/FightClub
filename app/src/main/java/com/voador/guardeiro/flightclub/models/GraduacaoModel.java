package com.voador.guardeiro.flightclub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Graduacao")
public class GraduacaoModel {

    @Id
    @GeneratedValue
    protected int id;

    @Column(name="graduacao", nullable=false)
    private String graduacao;

    @Column(name="modalidade", nullable=false)
    private String modalidade;

    public GraduacaoModel() {
    }


    public GraduacaoModel(String graduacao, String modalidade) {
        this.graduacao = graduacao;
        this.modalidade = modalidade;
    }

    @Override
    public String toString() {
        return "GraduacaoModel{" +
                "graduacao='" + graduacao + '\'' +
                ", modalidadeModel=" + modalidade +
                '}';
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getModalidadeModel() {
        return modalidade;
    }

    public void setModalidadeModel(Integer modalidadeModel) {
        this.modalidade = modalidade;
    }
}
