package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.PlanoModel;

import java.util.List;

public class PlanoRepository extends AbstractDAO<PlanoModel> {

    public PlanoRepository(Context context) {
        super(context, PlanoModel.class);
    }

    public List<PlanoModel> whereName(String usuario) {
        List<PlanoModel> results = null;
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
