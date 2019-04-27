package database.model;

public class PlanosModel extends BaseModel {

    private ModalidadeModel modalidadeModel;
    private String plano;

    //TABELA
    public static final String TABELA_NOME = "planos",
            COLUNA_ID = "_id",
            COLUNA_I_MODALIDADE_MODEL = "i_modalidade_model",
            COLUNA_PLANO = "plano";

    public static final String CREATE_TABLE = " create table " + TABELA_NOME
            +"("
            +COLUNA_ID +" integer primary key autoincrement,"
            +COLUNA_I_MODALIDADE_MODEL +" integer, "
            +COLUNA_PLANO +" text, "
            + "FOREIGN KEY (i_modalidade_model) REFERENCES 'modalidade' ('_id') "
            + ")";

    public PlanosModel(ModalidadeModel modalidadeModel, String plano) {
        this.modalidadeModel = modalidadeModel;
        this.plano = plano;
    }

    public PlanosModel() {
    }

    @Override
    public String toString() {
        return "PlanosModel{" +
                "modalidadeModel=" + modalidadeModel +
                ", plano='" + plano + '\'' +
                '}';
    }

    public ModalidadeModel getModalidadeModel() {
        return modalidadeModel;
    }

    public void setModalidadeModel(ModalidadeModel modalidadeModel) {
        this.modalidadeModel = modalidadeModel;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }
}
