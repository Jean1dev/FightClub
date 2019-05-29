package com.voador.guardeiro.flightclub.infrastructure.database;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<E, ID> extends DatabaseHelper {

    protected Dao<E, ID> dao;
    private Class<E> type;

    public AbstractDAO(Context context, Class<E> type) {
        super(context);
        this.type = type;
        setDao();
    }

    protected void setDao() {
        try {
            dao = DaoManager.createDao(getConnectionSource(), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<E> getAll() {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public E getById(ID id) {
        try {
            return dao.queryForId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long insert(E obj) {
        try {
            return (long) dao.create(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void delete(E obj) throws SQLException {
        try {
            dao.delete(obj);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void update(E obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
