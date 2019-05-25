package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.Cidade;

public class CidadeRepository extends AbstractDAO<Cidade, Long> {

    public CidadeRepository(Context context) {
        super(context, Cidade.class);
    }
}

