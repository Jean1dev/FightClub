package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.Graduacao;

public class GraduacaoRepository extends AbstractDAO<Graduacao, Long> {

    public GraduacaoRepository(Context context) {
        super(context, Graduacao.class);
    }
}

