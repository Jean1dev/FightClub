package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.MatriculaModalidade;

public class MatriculaModalidadeRepository extends AbstractDAO<MatriculaModalidade, Long> {

    public MatriculaModalidadeRepository(Context context) {
        super(context, MatriculaModalidade.class);
    }
}