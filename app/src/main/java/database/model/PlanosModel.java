package database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Planos")
public class PlanosModel extends BaseModel {

    @Id
    @GeneratedValue
    protected int id;

    @Column(name = "modalidade")
    private String modalidade;

    @Column(name = "plano")
    private String plano;

    @Column(name = "valor")
    private Double valor;

    public PlanosModel() {

    }

    public PlanosModel(int id, String modalidade, String plano, Double valor) {
        this.id = id;
        this.modalidade = modalidade;
        this.plano = plano;
        this.valor = valor;
    }

    public PlanosModel(String modalidade, String plano, Double valor) {
        this.modalidade = modalidade;
        this.plano = plano;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PlanosModel{" +
                "id=" + id +
                ", modalidade='" + modalidade + '\'' +
                ", plano='" + plano + '\'' +
                ", valor=" + valor +
                '}';
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
