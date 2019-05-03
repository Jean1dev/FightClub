package database.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "aluno")
public class AlunoModel extends BaseModel {

    @Id
    @GeneratedValue
    private int codigo;


    @Column(name="aluno", nullable=false)
    private String aluno;

    @Column(name="sexo", nullable=false)
    private String sexo;

    @Column(name="telefone", nullable=false)
    private String telefone;

    @Column(name="celular", nullable=false)
    private String celular;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="observacao")
    private String observacao;

    @Column(name="numero", nullable=false)
    private String numero;

    @Column(name="complemento")
    private String complemento;

    @Column(name="bairro", nullable=false)
    private String bairro;

    @Column(name="cep", nullable=false)
    private String cep;

    //definir as fks aqui
    //
    //TABELA
    public static final String TABELA_NOME = "aluno",
            COLUNA_ID = "_id",
            COLUNA_SEXO = "sexo",
            COLUNA_TELEFONE = "telefone",
            COLUNA_CELULAR = "celular",
            COLUNA_EMAIL = "email",
            COLUNA_OBSERVACAO = "observacao",
            COLUNA_NUMERO = "numero",
            COLUNA_COMPLEMENTO = "complemento",
            COLUNA_CEP = "cep";

    public static final String CREATE_TABLE = " create table " + TABELA_NOME
             +"("
            +COLUNA_ID +" integer primary key autoincrement,"
            +COLUNA_SEXO +" text not null,"
            +COLUNA_TELEFONE +" text not null,"
            +COLUNA_CELULAR +" text not null,"
            +COLUNA_EMAIL + " text not null,    "
            +COLUNA_OBSERVACAO +" text not null,"
            +COLUNA_NUMERO +" text not null,"
            +COLUNA_COMPLEMENTO +" text not null,"
            +COLUNA_CEP +" text not null)";


    public AlunoModel() {
    }

    public AlunoModel(int codigo, String aluno, String sexo, String telefone, String celular, String email, String observacao, String numero, String complemento, String bairro, String cep) {
        this.codigo = codigo;
        this.aluno = aluno;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.observacao = observacao;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "AlunoModel{" +
                "codigo=" + codigo +
                ", aluno='" + aluno + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", observacao='" + observacao + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
