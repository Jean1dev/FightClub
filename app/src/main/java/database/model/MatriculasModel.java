package database.model;

import java.util.Date;

public class MatriculasModel extends BaseModel {

    private int codigo;
    private int codigo_aluno;
    private Date data_matricula;
    private Date dia_vencimento;
    private Date dia_encerramento;
    private AlunoModel aluno;

    //TABELA
    public static final String TABELA_NOME = "matricula",
            COLUNA_ID = "_id",
            COLUNA_I_CODIGO_ALUNO = "i_codigo_aluno",
            COLUNA_DATA_MATRICULA = "data_matricula",
            COLUNA_DIA_VENCIMENTO = "dia_vencimento",
            COLUNA_DIA_ENCERRAMENTO = "dia_encerramento",
            COLUNA_ALUNO = "i_aluno";

    public static final String CREATE_TABLE = " create table " + TABELA_NOME
            + "("

            + COLUNA_ID + " integer primary key autoincrement,"
            + COLUNA_I_CODIGO_ALUNO + " integer, "
            + COLUNA_DATA_MATRICULA + " date "
            + COLUNA_DIA_VENCIMENTO + " date, "
            + COLUNA_DIA_ENCERRAMENTO + " date, "
            + COLUNA_ALUNO + " integer, "
            + "FOREIGN KEY (i_aluno) REFERENCES 'aluno' ('_id') "
            + ")";


    public MatriculasModel() {
    }

    public MatriculasModel(int codigo, int codigo_aluno, Date data_matricula, Date dia_vencimento, Date dia_encerramento, AlunoModel aluno) {
        this.codigo = codigo;
        this.codigo_aluno = codigo_aluno;
        this.data_matricula = data_matricula;
        this.dia_vencimento = dia_vencimento;
        this.dia_encerramento = dia_encerramento;
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "MatriculasModel{" +
                "codigo=" + codigo +
                ", codigo_aluno=" + codigo_aluno +
                ", data_matricula=" + data_matricula +
                ", dia_vencimento=" + dia_vencimento +
                ", dia_encerramento=" + dia_encerramento +
                ", aluno=" + aluno +
                '}';
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
