package database.model;

import java.util.Date;

public class MatriculasModel {

    private int coidog;
    private int codigo_aluno;
    private Date data_matricula;
    private Date dia_vencimento;
    private Date dia_encerramento;
    private AlunoModel aluno;

    public MatriculasModel() {
    }

    public MatriculasModel(int coidog, int codigo_aluno, Date data_matricula, Date dia_vencimento, Date dia_encerramento, AlunoModel aluno) {
        this.coidog = coidog;
        this.codigo_aluno = codigo_aluno;
        this.data_matricula = data_matricula;
        this.dia_vencimento = dia_vencimento;
        this.dia_encerramento = dia_encerramento;
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "MatriculasModel{" +
                "coidog=" + coidog +
                ", codigo_aluno=" + codigo_aluno +
                ", data_matricula=" + data_matricula +
                ", dia_vencimento=" + dia_vencimento +
                ", dia_encerramento=" + dia_encerramento +
                ", aluno=" + aluno +
                '}';
    }

    public int getCoidog() {
        return coidog;
    }

    public void setCoidog(int coidog) {
        this.coidog = coidog;
    }

    public int getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(int codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public Date getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    public Date getDia_vencimento() {
        return dia_vencimento;
    }

    public void setDia_vencimento(Date dia_vencimento) {
        this.dia_vencimento = dia_vencimento;
    }

    public Date getDia_encerramento() {
        return dia_encerramento;
    }

    public void setDia_encerramento(Date dia_encerramento) {
        this.dia_encerramento = dia_encerramento;
    }

    public AlunoModel getAluno() {
        return aluno;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }
}
