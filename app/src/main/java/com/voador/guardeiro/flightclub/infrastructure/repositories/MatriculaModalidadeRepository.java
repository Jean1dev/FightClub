package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.MatriculaModalidadeModel;

public class MatriculaModalidadeRepository extends AbstractDAO<MatriculaModalidadeModel> {

    public MatriculaModalidadeRepository(Context context) {
        super(context, MatriculaModalidadeModel.class);
    }
}