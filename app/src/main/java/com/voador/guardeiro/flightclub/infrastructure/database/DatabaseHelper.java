package com.voador.guardeiro.flightclub.infrastructure.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.voador.guardeiro.flightclub.models.Aluno;
import com.voador.guardeiro.flightclub.models.Graduacao;
import com.voador.guardeiro.flightclub.models.MatriculaModalidade;
import com.voador.guardeiro.flightclub.models.Modalidade;
import com.voador.guardeiro.flightclub.models.Plano;
import com.voador.guardeiro.flightclub.models.Usuario;

import java.sql.SQLException;

public abstract class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final int BANCO_VERSAO = 9;

    public DatabaseHelper(Context context) {
        super(context, "fight_club", null, BANCO_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Usuario.class);
            TableUtils.createTable(connectionSource, Graduacao.class);
            TableUtils.createTable(connectionSource, Modalidade.class);
            TableUtils.createTable(connectionSource, MatriculaModalidade.class);
            TableUtils.createTable(connectionSource, Plano.class);
            TableUtils.createTable(connectionSource, Aluno.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Usuario.class, true);
            TableUtils.dropTable(connectionSource, Graduacao.class, true);
            TableUtils.dropTable(connectionSource, Modalidade.class, true);
            TableUtils.dropTable(connectionSource, MatriculaModalidade.class, true);
            TableUtils.dropTable(connectionSource, Plano.class, true);
            TableUtils.dropTable(connectionSource, Aluno.class, true);

            onCreate(sqLiteDatabase, connectionSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
