package database.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "MatriculasModalidade")
public class MatriculasModalidadeModel extends BaseModel  {

    @Id
    @GeneratedValue
    private int codigo;

    @Column(name = "codigo_aluno")
    private int codigo_aluno;

    @Column(name = "plano")
    private String plano;

    @Column(name = "data_inicio")
    private Date data_inicio;

    @Column(name = "data_fim")
    private Date data_fim;

    @Column(name = "data_matricula")
    private Date data_matricula;

    @Column(name = "data_vencimento")
    private int data_vencimento;

    @Column(name = "dia_encerramento")
    private Date dia_encerramento;

    @Column(name = "aluno")
    private String aluno;

    public MatriculasModalidadeModel(int codigo_aluno, String plano, Date data_inicio, Date data_fim,  Date data_matricula, int data_vencimento,  String aluno) {
        this.codigo_aluno = codigo_aluno;
        this.plano = plano;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.data_matricula = data_matricula;
        this.data_vencimento = data_vencimento;
        this.aluno = aluno;
    }


    public MatriculasModalidadeModel() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(int codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Date getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    public int getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(int data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
}
