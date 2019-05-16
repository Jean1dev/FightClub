package com.voador.guardeiro.flightclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MatriculaActivity extends AppCompatActivity {

    private ListView listaMatriculas;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_matricula);


        //receber do banco todas modalidades
        String[] modalidades = new String[]{
                "Guardeiro",
                "Voador",
                "Chute no saco"
        };

        listaMatriculas = findViewById(R.id.listViewMatricula);
        btnSalvar = findViewById(R.id.btnSalvarMatricula);

        ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, modalidades);
        listaMatriculas.setAdapter(array);


    }

//    private boolean login() {
//        return !new UsuarioPersistence(getApplicationContext()).whereEmail(email).isEmpty();
//    }

}
