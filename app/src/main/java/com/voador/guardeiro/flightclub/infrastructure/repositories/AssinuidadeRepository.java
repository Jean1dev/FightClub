package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.AssinuidadeModel;

public class AssinuidadeRepository extends AbstractDAO<AssinuidadeModel> {

    public AssinuidadeRepository(Context context) {
        super(context, AssinuidadeModel.class);
    }
}
