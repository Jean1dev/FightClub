package database.model.Persistence;

import android.content.Context;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.util.ArrayList;
import java.util.List;

import database.model.DAO.GenericDAO;
import database.model.Usuario;

public class UsuarioPersistence extends GenericDAO<Usuario> {

    public UsuarioPersistence(Context context){
        super(context, Usuario.class);
    }

    public List<Usuario> whereEmail(String usuario) {
        List<Usuario> results = null;
        try {
            results = dao.queryBuilder().where().eq("plano", usuario).query();
        } catch (Exception e) {
            System.out.println("Exception ");
            return null;
        }
        return results;
    }
}
