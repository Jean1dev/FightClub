package database.model;

public class GraduacaoModel {

    private String graduacao;
    private ModalidadeModel modalidadeModel;

    public GraduacaoModel() {
    }

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
