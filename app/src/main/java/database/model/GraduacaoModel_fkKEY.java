package database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Graduacao")
public class GraduacaoModel_fkKEY extends BaseModel {

    @Id
    @GeneratedValue
    protected int id;

    @Column(name="graduacao", nullable=false)
    private String graduacao;

    @Column(name="modalidadeID", nullable=false)
    private Integer modalidadeID;

    public GraduacaoModel_fkKEY() {
    }

    public static final String TABELA_NOME = "graduacoes",
            COLUNA_ID = "_id",
            COLUNA_GRADUACAO = "graduacao",
            COLUNA_MODALIDADE = "modalidadeID";

    public static final String CREATE_TABLE = " create table " + "graduacoes"
            +"("
            +COLUNA_ID +" integer primary key autoincrement,"
            +COLUNA_GRADUACAO +" text primary key,"
            +COLUNA_MODALIDADE +" integer not null"
            + " FOREIGN KEY ("+COLUNA_MODALIDADE+") REFERENCES "+ ModalidadeModel.TABELA_NOME +"("+ModalidadeModel.COLUNA_ID+"));";

    public GraduacaoModel_fkKEY(String graduacao, Integer modalidadeID) {
        this.graduacao = graduacao;
        this.modalidadeID = modalidadeID;
    }

    @Override
    public String toString() {
        return "GraduacaoModel{" +
                "graduacao='" + graduacao + '\'' +
                ", modalidadeModel=" + modalidadeID +
                '}';
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public Integer getModalidadeModel() {
        return modalidadeID;
    }

    public void setModalidadeModel(Integer modalidadeModel) {
        this.modalidadeID = modalidadeID;
    }
}
