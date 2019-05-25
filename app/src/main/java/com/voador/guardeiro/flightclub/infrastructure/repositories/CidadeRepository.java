package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.CidadeModel;

public class CidadeRepository extends AbstractDAO<CidadeModel> {

    public CidadeRepository(Context context) {
        super(context, CidadeModel.class);
    }
}

