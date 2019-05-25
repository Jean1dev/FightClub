package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.FaturaMatriculaModel;

public class FaturaMatriculaRepository extends AbstractDAO<FaturaMatriculaModel> {

    public FaturaMatriculaRepository(Context context) {
        super(context, FaturaMatriculaModel.class);
    }
}