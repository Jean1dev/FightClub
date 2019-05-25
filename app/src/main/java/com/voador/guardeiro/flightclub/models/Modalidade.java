package com.voador.guardeiro.flightclub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "modalidades")
public class Modalidade {

    @Id
    @GeneratedValue
    protected Long id;

    @Column(name = "descricao")
    private String descricao;

    public Modalidade() {
    }

    public Modalidade(String modalidade) {
        this.descricao = modalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Modalidade{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
