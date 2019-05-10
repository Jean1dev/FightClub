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
            //dao.query((PreparedQuery<Usuario>) dao.queryBuilder().where().eq("email", usuario).query());
            //dao.query((ArrayList<Usuario>) dao.queryBuilder().where().eq("email", usuario).query());
            results = dao.queryBuilder().where().eq("email", usuario).query();
            /*QueryBuilder<Usuario, String> query = dao.queryBuilder();
            Where where = query.where();
            where.eq("email", "iurypiva@gmail.com");*/
        } catch (Exception e) {
            System.out.println("Exception ");
            return null;
        }
        return results;
    }
}
