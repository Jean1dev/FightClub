package database.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Graduacao")
public class GraduacaoModel extends BaseModel {

    @Column(name="graduacao", nullable=false)
    private String graduacao;

    @Column(name="modalidade", nullable=false)
    private ModalidadeModel modalidadeModel;

    public GraduacaoModel() {
    }

    public static final String TABELA_NOME = "graduacoes",
            COLUNA_GRADUACAO = "graduacao",
            COLUNA_MODALIDADE = "modalidadeModel";

    public static final String CREATE_TABLE = " create table " + "graduacoes"
            +"("
            +COLUNA_GRADUACAO +" text primary key,"
            +COLUNA_MODALIDADE +" text not null)";

    public GraduacaoModel(String graduacao, ModalidadeModel modalidadeModel) {
        this.graduacao = graduacao;
        this.modalidadeModel = modalidadeModel;
    }

    @Override
    public String toString() {
        return "GraduacaoModel{" +
                "graduacao='" + graduacao + '\'' +
                ", modalidadeModel=" + modalidadeModel +
                '}';
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public ModalidadeModel getModalidadeModel() {
        return modalidadeModel;
    }

    public void setModalidadeModel(ModalidadeModel modalidadeModel) {
        this.modalidadeModel = modalidadeModel;
    }
}
