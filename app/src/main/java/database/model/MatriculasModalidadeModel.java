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

    @Column(name = "graduacao")
    private String graduacaoModel;

    @Column(name = "modalidade")
    private String modalidade;

    @Column(name = "data_matricula")
    private Date data_matricula;

    @Column(name = "data_vencimento")
    private Date data_vencimento;

    @Column(name = "dia_encerramento")
    private Date dia_encerramento;

    @Column(name = "aluno")
    private AlunoModel aluno;


}
