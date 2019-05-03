package database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="nome")
public class Usuario extends BaseModel {

    @Id
    @GeneratedValue
    protected int id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="sobrenome", nullable=false)
    private String sobrenome;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="senha", nullable=false)
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }
}
