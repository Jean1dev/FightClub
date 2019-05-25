package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.GraduacaoModel;

public class GraduacaoRepository extends AbstractDAO<GraduacaoModel> {

    public GraduacaoRepository(Context context) {
        super(context, GraduacaoModel.class);
    }
}

