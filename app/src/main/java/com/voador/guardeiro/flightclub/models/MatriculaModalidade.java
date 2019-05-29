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

@Entity(name = "matriculas_modalidades")
public class MatriculaModalidade {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "aluno_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnDefinition = "aluno_id references alunos(id) on delete restrict")
    private Aluno aluno;

    @JoinColumn(name = "plano_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnDefinition = "plano_id references planos(id) on delete restrict")
    private Plano plano;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    public MatriculaModalidade() {
    }

    public MatriculaModalidade(Aluno aluno,
                               Plano plano,
                               Date dataInicio,
                               Date dataFim) {
        this.aluno = aluno;
        this.plano = plano;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public MatriculaModalidade(Long id,
                               Aluno aluno,
                               Plano plano,
                               Date dataInicio,
                               Date dataFim) {
        this.id = id;
        this.aluno = aluno;
        this.plano = plano;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
