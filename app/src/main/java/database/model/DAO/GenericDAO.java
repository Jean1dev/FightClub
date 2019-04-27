package database.model.DAO;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.util.List;

public class GenericDAO<E> extends DatabaseHelper<E> {

    protected Dao<E, Integer> dao;
    private Class<E> type;

    public GenericDAO(Context context, Class<E> type){
        super(context);
        this.type = type;
        setDao();
    }

    protected void setDao() {
        try{
            dao = DaoManager.createDao(getConnectionSource(), type);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<E> getAll(){
        try{
            List<E> result = dao.queryForAll();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public E getById(int id) {
        try{
            E obj = dao.queryForId(id);
            return obj;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public long insert(E obj) {
        try{
            long ret = dao.create(obj);
            return ret;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void delete(E obj) {
        try{
            dao.delete(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(E obj) {
        try{
            dao.update(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
