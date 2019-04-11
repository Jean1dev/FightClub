package database.model;

public class PlanosModel {

    private ModalidadeModel modalidadeModel;
    private String plano;

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
