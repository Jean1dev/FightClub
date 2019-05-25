package com.voador.guardeiro.flightclub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Modalidade")
public class ModalidadeModel {

    @Id
    @GeneratedValue
    protected int id;

    @Column(name = "modalidade")
    private String modalidade;

    public ModalidadeModel(String modalidade) {
        this.modalidade = modalidade;
    }

    public ModalidadeModel() {

    }

    @Override
    public String toString() {
        return "ModalidadeModel{" +
                "modalidade='" + modalidade + '\'' +
                '}';
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
}
