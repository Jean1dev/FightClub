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

    @Column(name = "plano")
    private String plano;

    @Column(name = "data_inicio")
    private Date data_inicio;

    @Column(name = "data_fim")
    private Date data_fim;

    @Column(name = "graduacaoModel")
    private GraduacaoModel graduacaoModel;

    @Column(name = "modalidadeModel")
    private ModalidadeModel modalidadeModel;

    public MatriculasModalidadeModel() {
    }

    public MatriculasModalidadeModel(int codigo, String plano, Date data_inicio, Date data_fim, GraduacaoModel graduacaoModel, ModalidadeModel modalidadeModel) {
        this.codigo = codigo;
        this.plano = plano;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.graduacaoModel = graduacaoModel;
        this.modalidadeModel = modalidadeModel;
    }

    @Override
    public String toString() {
        return "MatriculasModalidadeModel{" +
                "codigo=" + codigo +
                ", plano='" + plano + '\'' +
                ", data_inicio=" + data_inicio +
                ", data_fim=" + data_fim +
                ", graduacaoModel=" + graduacaoModel +
                ", modalidadeModel=" + modalidadeModel +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public GraduacaoModel getGraduacaoModel() {
        return graduacaoModel;
    }

    public void setGraduacaoModel(GraduacaoModel graduacaoModel) {
        this.graduacaoModel = graduacaoModel;
    }

    public ModalidadeModel getModalidadeModel() {
        return modalidadeModel;
    }

    public void setModalidadeModel(ModalidadeModel modalidadeModel) {
        this.modalidadeModel = modalidadeModel;
    }
}
