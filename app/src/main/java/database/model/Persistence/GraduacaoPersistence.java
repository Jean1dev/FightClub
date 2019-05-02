package database.model.Persistence;

import android.content.Context;


import database.model.DAO.GenericDAO;
import database.model.GraduacaoModel;

public class GraduacaoPersistence extends GenericDAO<GraduacaoModel> {

    public GraduacaoPersistence(Context context) {
        super(context, GraduacaoModel.class);
    }
}

