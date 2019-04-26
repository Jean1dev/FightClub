package database.model;

import java.util.Date;

public class FaturaMatriculaModel extends BaseModel {

    private int codigo_matricula;
    private Date data_vencimento;
    private Double valor;
    private Date data_pagamento;
    private Date data_cancelamento;

    //TABELA
    public static final String TABELA_NOME = "faturas_matriculas",
            COLUNA_ID = "codigo_matricula",
            COLUNA_DATA_VENCIMENTO = "data_vencimento",
            COLUNA_VALOR = "valor",
            COLUNA_DATA_PAGAMENTO = "data_pagamento",
            COLUNA_DATA_CANCELAMENTO = "data_cancelamento";

    public static final String CREATE_TABLE = " create table " + "faturas_matriculas"
            +"("
            +COLUNA_ID +" integer primary key autoincrement,"
            +COLUNA_DATA_VENCIMENTO +" date not null,"
            +COLUNA_VALOR +" numeric(9,2) not null,"
            +COLUNA_DATA_PAGAMENTO +" date not null,"
            +COLUNA_DATA_CANCELAMENTO + " date not null)";

    public FaturaMatriculaModel(int codigo_matricula, Date data_vencimento, Double valor, Date data_pagamento, Date data_cancelamento) {
        this.codigo_matricula = codigo_matricula;
        this.data_vencimento = data_vencimento;
        this.valor = valor;
        this.data_pagamento = data_pagamento;
        this.data_cancelamento = data_cancelamento;
    }

    public FaturaMatriculaModel() {
    }

    @Override
    public String toString() {
        return "FaturaMatriculaModel{" +
                "codigo_matricula=" + codigo_matricula +
                ", data_vencimento=" + data_vencimento +
                ", valor=" + valor +
                ", data_pagamento=" + data_pagamento +
                ", data_cancelamento=" + data_cancelamento +
                '}';
    }

    public int getCodigo_matricula() {
        return codigo_matricula;
    }

    public void setCodigo_matricula(int codigo_matricula) {
        this.codigo_matricula = codigo_matricula;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Date getData_cancelamento() {
        return data_cancelamento;
    }

    public void setData_cancelamento(Date data_cancelamento) {
        this.data_cancelamento = data_cancelamento;
    }
}
