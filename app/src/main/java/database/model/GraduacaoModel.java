package database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Graduacao")
public class GraduacaoModel extends BaseModel {

    @Id
    @GeneratedValue
    protected int id;

    @Column(name="graduacao", nullable=false)
    private String graduacao;

    @Column(name="modalidade", nullable=false)
    private String modalidade;

    public GraduacaoModel() {
    }

    public static final String TABELA_NOME = "graduacoes",
            COLUNA_ID = "_id",
            COLUNA_GRADUACAO = "graduacao",
            COLUNA_MODALIDADE = "modalidade";

    public static final String CREATE_TABLE = " create table " + "graduacoes"
            +"("
            +COLUNA_ID +" integer primary key autoincrement,"
            +COLUNA_GRADUACAO +" text primary key,"
            +COLUNA_MODALIDADE +" integer not null"
            + " FOREIGN KEY ("+COLUNA_MODALIDADE+") REFERENCES "+ ModalidadeModel.TABELA_NOME +"("+ModalidadeModel.COLUNA_ID+"));";

    public GraduacaoModel(String graduacao, String modalidade) {
        this.graduacao = graduacao;
        this.modalidade = modalidade;
    }

    @Override
    public String toString() {
        return "GraduacaoModel{" +
                "graduacao='" + graduacao + '\'' +
                ", modalidadeModel=" + modalidade +
                '}';
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getModalidadeModel() {
        return modalidade;
    }

    public void setModalidadeModel(Integer modalidadeModel) {
        this.modalidade = modalidade;
    }
}
