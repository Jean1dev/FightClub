package database.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Assinuidade")
public class AssinuidadeModel extends BaseModel {

    @Id
    @GeneratedValue
    private int codigo_matricula;

    @Column(name="timestamp", nullable=false)
    private Timestamp timestamp;

    public AssinuidadeModel(int codigo_matricula, Timestamp timestamp) {
        this.codigo_matricula = codigo_matricula;
        this.timestamp = timestamp;
    }

    public AssinuidadeModel() {
    }

    public static final String TABELA_NOME = "assinuidade",
            COLUNA_ID = "codigo_matricula",
            COLUNA_TIMESTAMP = "timestamp";

    public static final String CREATE_TABLE = " create table " + "assinuidade"
            +"("
            +COLUNA_ID +" int primary key autoincrement,"
            +COLUNA_TIMESTAMP +" timestamp not null)";

    @Override
    public String toString() {
        return "AssinuidadeModel{" +
                "codigo_matricula=" + codigo_matricula +
                ", timestamp=" + timestamp +
                '}';
    }

    public int getCodigo_matricula() {
        return codigo_matricula;
    }

    public void setCodigo_matricula(int codigo_matricula) {
        this.codigo_matricula = codigo_matricula;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
