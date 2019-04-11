package database.model;

import java.sql.Timestamp;

public class AssinuidadeModel {

    private int codigo_matricula;
    private Timestamp timestamp;

    public AssinuidadeModel(int codigo_matricula, Timestamp timestamp) {
        this.codigo_matricula = codigo_matricula;
        this.timestamp = timestamp;
    }

    public AssinuidadeModel() {
    }

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
