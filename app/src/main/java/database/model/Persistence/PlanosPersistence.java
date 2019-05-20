package database.model.Persistence;

import android.content.Context;

import java.util.List;

import database.model.DAO.GenericDAO;
import database.model.PlanosModel;

public class PlanosPersistence extends GenericDAO<PlanosModel> {

    public PlanosPersistence(Context context) {
        super(context, PlanosModel.class);
    }

    public List<PlanosModel> whereName(String usuario) {
        List<PlanosModel> results = null;
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
