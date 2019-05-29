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

@Entity(name = "planos")
public class Plano {

    @Id
    @GeneratedValue
    protected Long id;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "descricao")
    private String descricao;

    @JoinColumn(name = "modalidade_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnDefinition = "modalidade_id references modalidades(id) on delete restrict")
    private Modalidade modalidade;

    public Plano() {

    }

    public Plano(Double valor, String descricao, Modalidade modalidade) {
        this.valor = valor;
        this.descricao = descricao;
        this.modalidade = modalidade;
    }

    public Plano(Long id, Double valor, String descricao, Modalidade modalidade) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.modalidade = modalidade;
    }

    public Long getId() {
        return id;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Plano{" +
                "id=" + id +
                ", modalidade='" + modalidade + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }

}
