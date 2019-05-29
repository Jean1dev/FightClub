package com.voador.guardeiro.flightclub.models;

import com.j256.ormlite.field.DatabaseField;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "graduacoes")
public class Graduacao {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @JoinColumn(name = "modalidade_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnDefinition = "modalidade_id references modalidades(id) on delete restrict")
    private Modalidade modalidade;

    public Graduacao() {
    }

    public Graduacao(String descricao, Modalidade modalidade) {
        this.descricao = descricao;
        this.modalidade = modalidade;
    }

    public Graduacao(Long id, String descricao, Modalidade modalidade) {
        this.id = id;
        this.descricao = descricao;
        this.modalidade = modalidade;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public String toString() {
        return "Graduacao{" +
                "descricao='" + descricao + '\'' +
                ", modalidadeModel=" + modalidade +
                '}';
    }
}
