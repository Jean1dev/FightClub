package database.model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import database.model.GraduacaoModel;
import database.model.ModalidadeModel;
import database.model.Usuario;

public class DatabaseHelper<E> extends OrmLiteSqliteOpenHelper {

    private static final int BANCO_VERSAO = 8;

    public DatabaseHelper(Context context) {
        super(context, "my.db", null, BANCO_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Usuario.class);
            TableUtils.createTable(connectionSource, GraduacaoModel.class);
            TableUtils.createTable(connectionSource, ModalidadeModel.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try{
            TableUtils.dropTable(connectionSource, Usuario.class, true);;
            TableUtils.dropTable(connectionSource, GraduacaoModel.class, true);
            TableUtils.dropTable(connectionSource, ModalidadeModel.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
