package database.model.Persistence;

import android.content.Context;

import database.model.DAO.GenericDAO;
import database.model.FaturaMatriculaModel;

public class FaturaMatriculaPersistence extends GenericDAO<FaturaMatriculaModel> {

    public FaturaMatriculaPersistence(Context context) {
        super(context, FaturaMatriculaModel.class);
    }
}