package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.Plano;

import java.util.List;

public class PlanoRepository extends AbstractDAO<Plano, Long> {

    public PlanoRepository(Context context) {
        super(context, Plano.class);
    }

    public List<Plano> whereName(String usuario) {
        try {
            return dao.queryBuilder().where().eq("email", usuario).query();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
