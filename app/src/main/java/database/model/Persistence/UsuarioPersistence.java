package database.model.Persistence;

import android.content.Context;

import com.j256.ormlite.stmt.PreparedQuery;

import java.util.List;

import database.model.DAO.GenericDAO;
import database.model.Usuario;

public class UsuarioPersistence extends GenericDAO<Usuario> {

    public UsuarioPersistence(Context context){
        super(context, Usuario.class);
    }

    public List<Usuario> whereEmail(String usuario) {
        List<Usuario> u;
        try {
            u = dao.query((PreparedQuery<Usuario>) dao.queryBuilder().where().eq("usuario", usuario));
        } catch (Exception e) {
            System.out.println("Exception ");
            return null;
        }
        return u;
    }
}
