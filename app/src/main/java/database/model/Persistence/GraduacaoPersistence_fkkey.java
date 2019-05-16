package database.model.Persistence;

import android.content.Context;

import database.model.DAO.GenericDAO;
import database.model.GraduacaoModel_fkKEY;

public class GraduacaoPersistence_fkkey extends GenericDAO<GraduacaoModel_fkKEY> {

    public GraduacaoPersistence_fkkey(Context context) {
        super(context, GraduacaoModel_fkKEY.class);
    }
}

