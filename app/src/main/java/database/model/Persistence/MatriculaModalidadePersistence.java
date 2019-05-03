package database.model.Persistence;

import android.content.Context;

import database.model.DAO.GenericDAO;
import database.model.MatriculasModalidadeModel;

public class MatriculaModalidadePersistence extends GenericDAO<MatriculasModalidadeModel> {

    public MatriculaModalidadePersistence(Context context) {
        super(context, MatriculasModalidadeModel.class);
    }
}