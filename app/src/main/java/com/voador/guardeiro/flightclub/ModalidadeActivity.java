package com.voador.guardeiro.flightclub;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AndroidException;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ModalidadeActivity extends AppCompatActivity {

    private ListView listaModalidades;
    private Button btnCadastrarModalidade;
    private Button btnAdicionar;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidade);

        //receber do banco todas modalidades
        String[] modalidades = new String[]{
                "Guardeiro",
                "Voador",
                "Chute no saco"
        };

        listaModalidades = findViewById(R.id.listModalidade);
        btnCadastrarModalidade = findViewById(R.id.btnCadastrarModalidade);

        ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, modalidades);
        listaModalidades.setAdapter(array);

    }

    public void novaModalidade(View v){

        // Cria o AlertDialog.

        final AlertDialog.Builder builder = new AlertDialog.Builder(ModalidadeActivity.this);

        // Guarda a opção de inflate.
        LayoutInflater inflater = ModalidadeActivity.this.getLayoutInflater();

        // Faz a inflação do layout de configuração.
        final View viewInf = inflater.inflate(R.layout.dialog_modalidade, null);
        builder.setView(viewInf);

        btnAdicionar = (Button)viewInf.findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        (dialog = builder.create()).show();

    }



}
