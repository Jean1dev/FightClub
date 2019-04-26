package database.model;

public class UsuarioModel {

    private String usuario;
    private String perfil;

    //TABELA
    public static final String TABELA_NOME = "usuario",
            COLUNA_ID = "_id",
            COLUNA_USUARIO = "usuario",
            COLUNA_PERFIL = "perfil";

    public static final String CREATE_TABLE = " create table " + TABELA_NOME
            +"("
            +COLUNA_ID +" integer primary key autoincrement,"
            +COLUNA_USUARIO +" text, "
            +COLUNA_PERFIL +" text "
            + ")";

    public UsuarioModel(String usuario, String perfil) {
        this.usuario = usuario;
        this.perfil = perfil;
    }

    public UsuarioModel() {
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "usuario='" + usuario + '\'' +
                ", perfil='" + perfil + '\'' +
                '}';
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
