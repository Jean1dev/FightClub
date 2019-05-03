package database.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Cidade")
public class CidadeModel extends BaseModel {

    @Column(name="cidade", nullable=false)
    private String cidade;

    @Column(name="estado", nullable=false)
    private String estado;

    @Column(name="pais", nullable=false)
    private String pais;

    public CidadeModel(String cidade, String estado, String pais) {
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public CidadeModel() {
    }

    //TABELA
    public static final String TABELA_NOME = "cidades",
            COLUNA_CIDADE = "cidade",
            COLUNA_ESTADO = "estado",
            COLUNA_PAIS = "pais";

    public static final String CREATE_TABLE = " create table " + "cidades"
            +"("
            +COLUNA_CIDADE +" text primary key,"
            +COLUNA_ESTADO +" char(2) not null,"
            +COLUNA_PAIS +" text not null)";
    @Override
    public String toString() {
        return "CidadeModel{" +
                "cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
