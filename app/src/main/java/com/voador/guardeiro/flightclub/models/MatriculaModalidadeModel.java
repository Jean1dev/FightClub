package com.voador.guardeiro.flightclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "MatriculasModalidade")
public class MatriculaModalidadeModel {

    @Id
    @GeneratedValue
    private int codigo;

    @Column(name = "codigo_aluno")
    private int codigoAluno;

    @Column(name = "plano")
    private String plano;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(name = "data_matricula")
    private Date dataMatricula;

    @Column(name = "data_vencimento")
    private int dataVencimento;

    @Column(name = "dia_encerramento")
    private Date diaEncerramento;

    @Column(name = "aluno")
    private String aluno;

    public MatriculaModalidadeModel(int codigoAluno, String plano, Date dataInicio, Date dataFim, Date dataMatricula, int dataVencimento, String aluno) {
        this.codigoAluno = codigoAluno;
        this.plano = plano;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataMatricula = dataMatricula;
        this.dataVencimento = dataVencimento;
        this.aluno = aluno;
    }

    public MatriculaModalidadeModel() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
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

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public int getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(int dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDiaEncerramento() {
        return diaEncerramento;
    }

    public void setDiaEncerramento(Date diaEncerramento) {
        this.diaEncerramento = diaEncerramento;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
}
