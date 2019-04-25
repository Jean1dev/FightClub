package database.model;

public class ModalidadeModel {

    private String modalidade;

    //TABELA
    public static final String TABELA_NOME = "modalidade",
            COLUNA_ID = "_id",
            COLUNA_MODALIDADE = "modalidade";

    public static final String CREATE_TABLE = " create table " + TABELA_NOME
            +"("
            +COLUNA_ID +" integer primary key autoincrement,"
            +COLUNA_MODALIDADE +" text "
            + ")";

    public ModalidadeModel(String modalidade) {
        this.modalidade = modalidade;
    }

    public ModalidadeModel() {

    }

    @Override
    public String toString() {
        return "ModalidadeModel{" +
                "modalidade='" + modalidade + '\'' +
                '}';
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
}
