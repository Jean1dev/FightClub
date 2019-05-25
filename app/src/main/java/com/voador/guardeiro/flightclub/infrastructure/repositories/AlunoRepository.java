package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.AlunoModel;

import java.util.List;

public class AlunoRepository extends AbstractDAO<AlunoModel> {

    public AlunoRepository(Context context) {
        super(context, AlunoModel.class);

}
    public List<AlunoModel> whereID(int id) {
        try {
            return dao.queryBuilder().where().eq("codigo", id).query();
        } catch (Exception e) {
            System.out.println("Exception ");
            return null;
        }
    }
}
