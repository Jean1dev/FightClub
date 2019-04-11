package database.model;

public class UsuarioModel {

    private String usuario;
    private String perfil;

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
