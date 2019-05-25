package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.Aluno;

import java.util.List;

public class AlunoRepository extends AbstractDAO<Aluno, Long> {

    public AlunoRepository(Context context) {
        super(context, Aluno.class);

    }

    public List<Aluno> whereID(Long id) {
        try {
            return dao.queryBuilder().where().eq("codigo", id).query();
        } catch (Exception e) {
            System.out.println("Exception ");
            return null;
        }
    }
}
