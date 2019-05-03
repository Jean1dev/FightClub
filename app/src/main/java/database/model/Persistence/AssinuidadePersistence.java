package database.model.Persistence;

import android.content.Context;

import database.model.AssinuidadeModel;
import database.model.DAO.GenericDAO;

public class AssinuidadePersistence extends GenericDAO<AssinuidadeModel> {

    public AssinuidadePersistence(Context context) {
        super(context, AssinuidadeModel.class);
    }
}
