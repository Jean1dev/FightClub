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

@Entity(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "aluno_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnDefinition = "aluno_id references alunos(id) on delete restrict")
    private Aluno aluno;

    @Column(name = "data_matricula")
    private Date dataMatricula;

    @Column(name = "dia_encerramento")
    private Date diaEncerramento;

    @Column(name = "dia_vencimento")
    private Integer diaVencimento;

    public Matricula() {
    }

    public Matricula(Long id,
                     Aluno aluno,
                     Date dataMatricula,
                     Date diaEncerramento,
                     Integer diaVencimento) {
        this.id = id;
        this.aluno = aluno;
        this.dataMatricula = dataMatricula;
        this.diaVencimento = diaVencimento;
        this.diaEncerramento = diaEncerramento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Date getDiaEncerramento() {
        return diaEncerramento;
    }

    public void setDiaEncerramento(Date diaEncerramento) {
        this.diaEncerramento = diaEncerramento;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", data_matricula=" + dataMatricula +
                ", dia_vencimento=" + diaVencimento +
                ", dia_encerramento=" + diaEncerramento +
                ", aluno=" + aluno +
                '}';
    }

}
