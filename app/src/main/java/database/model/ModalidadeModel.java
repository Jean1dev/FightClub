package database.model;

public class ModalidadeModel {

    private String modalidade;

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
