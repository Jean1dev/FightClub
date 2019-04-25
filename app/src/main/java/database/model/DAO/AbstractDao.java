package database.model.DAO;

import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.List;

public abstract class AbstractDao {

    protected SQLiteDatabase db;
    protected DBOpenHelper __db;

    protected final void open(){
        this.db = this.__db.getWritableDatabase();
    }

    protected final void close(){
        this.__db.close();
    }

    public boolean doesDatabaseExist(ContextWrapper context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }

    public abstract long insert();
    public abstract long delete();
    public abstract long update();
    public abstract List<?> select();
}
