package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.Assinuidade;

public class AssinuidadeRepository extends AbstractDAO<Assinuidade, Long> {

    public AssinuidadeRepository(Context context) {
        super(context, Assinuidade.class);
    }
}
