package database.model.Persistence;

import android.content.Context;

import java.util.List;

import database.model.AlunoModel;

import database.model.DAO.AbstractDao;
import database.model.DAO.DBOpenHelper;
import database.model.DAO.GenericDAO;
import database.model.Usuario;

public class AlunoPersistence extends GenericDAO<AlunoModel> {

    public AlunoPersistence(Context context) {
        super(context, AlunoModel.class);

}
    public List<AlunoModel> whereID(int id) {
        List<AlunoModel> results = null;
        try {
            results = dao.queryBuilder().where().eq("codigo", id).query();
        } catch (Exception e) {
            System.out.println("Exception ");
            return null;
        }
        return results;
    }
}
