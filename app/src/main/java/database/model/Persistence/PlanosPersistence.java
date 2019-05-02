package database.model.Persistence;

import android.content.Context;

import database.model.DAO.GenericDAO;
import database.model.PlanosModel;

public class PlanosPersistence extends GenericDAO<PlanosModel> {

    public PlanosPersistence(Context context) {
        super(context, PlanosModel.class);
    }
}
