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

    //TABELA
    public static final String TABELA_NOME = "planos",
            COLUNA_ID = "_id",
            COLUNA_MODALIDADE= "modalidade",
            COLUNA_PLANO = "plano",
            COLUNA_VALOR = "valor";

    public static final String CREATE_TABLE = " create table " + TABELA_NOME
            +"("
            +COLUNA_ID +" integer primary key autoincrement,"
            +COLUNA_MODALIDADE +" text, "
            +COLUNA_PLANO +" text, "
            +COLUNA_VALOR +" text, "
            + ")";

    public PlanosModel(String modalidade, String plano, Double valor) {
        this.modalidade = modalidade;
        this.plano = plano;
        this.valor = valor;
    }

    public PlanosModel() {
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
