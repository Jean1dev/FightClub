package database.model.Persistence;

import android.content.Context;

import database.model.DAO.GenericDAO;
import database.model.MatriculasModel;

public class MatriculasPersistence extends GenericDAO<MatriculasModel> {

    public MatriculasPersistence(Context context) {
        super(context, MatriculasModel.class);
    }
}
