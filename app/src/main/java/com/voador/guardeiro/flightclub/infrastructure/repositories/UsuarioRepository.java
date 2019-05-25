package com.voador.guardeiro.flightclub.infrastructure.repositories;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.database.AbstractDAO;
import com.voador.guardeiro.flightclub.models.Usuario;

import java.util.List;

public class UsuarioRepository extends AbstractDAO<Usuario, Long> {

    public UsuarioRepository(Context context) {
        super(context, Usuario.class);
    }

    public List<Usuario> whereEmail(String usuario) {
        try {
            return dao.queryBuilder().where().eq("email", usuario).query();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
