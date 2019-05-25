package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.MatriculaModel;

public class MatriculaRepository extends AbstractDAO<MatriculaModel> {

    public MatriculaRepository(Context context) {
        super(context, MatriculaModel.class);
    }
}
