package database.model.Persistence;

import android.content.Context;

import database.model.DAO.GenericDAO;
import database.model.CidadeModel;

public class CidadePersistence extends GenericDAO<CidadeModel> {

    public CidadePersistence(Context context) {
        super(context, CidadeModel.class);
    }
}

