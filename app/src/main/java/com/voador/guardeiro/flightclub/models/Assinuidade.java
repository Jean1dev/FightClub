package com.voador.guardeiro.flightclub.models;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "assinuidades")
public class Assinuidade {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "matricula_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Matricula matricula;

    @Column(name = "data_entrada", nullable = false)
    private Date dataEntrada;

    public Assinuidade() {
    }

    public Assinuidade(Matricula matricula, Date dataEntrada) {
        this.matricula = matricula;
        this.dataEntrada = dataEntrada;
    }

    public Assinuidade(Long id, Matricula matricula, Date dataEntrada) {
        this.id = id;
        this.matricula = matricula;
        this.dataEntrada = dataEntrada;
    }

    public Long getId() {
        return id;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public String toString() {
        return "Assinuidade{" +
                "matricula=" + matricula.toString() +
                ", dataEntrada=" + dataEntrada +
                '}';
    }
}
