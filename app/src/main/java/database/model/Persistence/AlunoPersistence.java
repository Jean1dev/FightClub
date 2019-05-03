package database.model.Persistence;

import android.content.Context;

import java.util.List;

import database.model.AlunoModel;

import database.model.DAO.AbstractDao;
import database.model.DAO.DBOpenHelper;
import database.model.DAO.GenericDAO;

public class AlunoPersistence extends GenericDAO<AlunoModel> {

    public AlunoPersistence(Context context) {
        super(context, AlunoModel.class);

}
/*public class AlunoPersistence extends AbstractDao {

    private Context _context;
    private String[] colunas = new String[]{
            AlunoModel.COLUNA_ID,
            AlunoModel.TABELA_NOME,
            AlunoModel.COLUNA_EMAIL,
            AlunoModel.COLUNA_CELULAR,
            AlunoModel.COLUNA_CEP,
            AlunoModel.COLUNA_COMPLEMENTO,
            AlunoModel.COLUNA_NUMERO,
            AlunoModel.COLUNA_OBSERVACAO,
            AlunoModel.COLUNA_SEXO,
            AlunoModel.COLUNA_TELEFONE
    };

    public AlunoPersistence(Context _context) {
        this._context = _context;
        this.__db = new DBOpenHelper(this._context);
    }*/

    //@Override
    public long insert() {
        return 0;
    }

   // @Override
    public long delete() {
        return 0;
    }

    //@Override
    public long update() {
        return 0;
    }

    //@Override
    public List<AlunoModel> select() {

        return null;
    }
}
