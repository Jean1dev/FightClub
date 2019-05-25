package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.FaturaMatricula;

public class FaturaMatriculaRepository extends AbstractDAO<FaturaMatricula, Long> {

    public FaturaMatriculaRepository(Context context) {
        super(context, FaturaMatricula.class);
    }
}