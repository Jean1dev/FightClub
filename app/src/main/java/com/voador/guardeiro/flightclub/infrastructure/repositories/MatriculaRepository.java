package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.Matricula;

public class MatriculaRepository extends AbstractDAO<Matricula, Long> {

    public MatriculaRepository(Context context) {
        super(context, Matricula.class);
    }
}
