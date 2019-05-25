package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.Modalidade;

public class ModalidadeRepository extends AbstractDAO<Modalidade, Long> {

    public ModalidadeRepository(Context context) {
        super(context, Modalidade.class);
    }
}
