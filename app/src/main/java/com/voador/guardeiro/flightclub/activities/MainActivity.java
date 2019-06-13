package com.voador.guardeiro.flightclub.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.adapters.MatriculaListViewAdapter;
import com.voador.guardeiro.flightclub.infrastructure.repositories.MatriculaModalidadeRepository;
import com.voador.guardeiro.flightclub.models.MatriculaModalidade;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<MatriculaModalidade> listaMatriculas;
    private ListView listViewMatriculas;
    private MatriculaModalidadeRepository matriculaModalidadeRepository;
    AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0 & getIntent().getExtras() == null) {
            finish();
            return;
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        matriculaModalidadeRepository = new MatriculaModalidadeRepository(getBaseContext());

        listViewMatriculas = findViewById(R.id.listMatriculas);

        atualizarListMatriculas();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            final AlertDialog.Builder builderRemover = new AlertDialog.Builder(MainActivity.this);
            builderRemover.setTitle("Deseja sair da sua conta?");

            builderRemover.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                   goToClearStack(LoginActivity.class);
            };
            });

            builderRemover.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });

            (dialog = builderRemover.create()).show();

        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_modalidade) {
            startActivity(new Intent(MainActivity.this, ModalidadeActivity.class));
        } else if (id == R.id.nav_graduacao) {
            startActivity(new Intent(MainActivity.this, GraduacaoActivity.class));
        } else if (id == R.id.nav_planos) {
            startActivity(new Intent(MainActivity.this, PlanoActivity.class));
        } else if (id == R.id.nav_matricula) {
            startActivity(new Intent(MainActivity.this, MatriculaActivity.class));
        } else if (id == R.id.nav_aluno) {
            startActivity(new Intent(MainActivity.this, MatriculaActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void atualizarListMatriculas(){
        listaMatriculas = matriculaModalidadeRepository.getAll();


        if (listaMatriculas != null) {

            MatriculaListViewAdapter array = new MatriculaListViewAdapter(listaMatriculas, this);
            listViewMatriculas.setAdapter(array);

        }
    }
}


