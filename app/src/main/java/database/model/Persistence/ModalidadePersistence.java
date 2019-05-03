package database.model.Persistence;

import android.content.Context;

import database.model.DAO.GenericDAO;
import database.model.ModalidadeModel;

public class ModalidadePersistence extends GenericDAO<ModalidadeModel> {

    public ModalidadePersistence(Context context) {
        super(context, ModalidadeModel.class);
    }
}
