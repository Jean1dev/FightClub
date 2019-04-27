package database.model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import database.model.Usuario;

public class DatabaseHelper<E> extends OrmLiteSqliteOpenHelper {

    private static final int BANCO_VERSAO = 1;

    public DatabaseHelper(Context context) {
        super(context, "my.db", null, BANCO_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Usuario.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try{
            TableUtils.dropTable(connectionSource, Usuario.class, true);
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
