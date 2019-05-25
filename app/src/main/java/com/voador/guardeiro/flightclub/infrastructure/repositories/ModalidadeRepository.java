package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.ModalidadeModel;

public class ModalidadeRepository extends AbstractDAO<ModalidadeModel> {

    public ModalidadeRepository(Context context) {
        super(context, ModalidadeModel.class);
    }
}
