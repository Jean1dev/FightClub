package database.model.Persistence;

import android.content.Context;

import database.model.DAO.GenericDAO;
import database.model.Usuario;

public class UsuarioPersistence extends GenericDAO<Usuario> {

    public UsuarioPersistence(Context context){
        super(context, Usuario.class);
    }
}
