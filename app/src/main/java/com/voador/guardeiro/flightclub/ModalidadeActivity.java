package com.voador.guardeiro.flightclub;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import database.model.ModalidadeModel;
import database.model.Persistence.ModalidadePersistence;

public class ModalidadeActivity extends AppCompatActivity {

    private ListView listaModalidades;
    private EditText editTextModalidade;
    AlertDialog dialog;
    private ModalidadePersistence modalidadePersistence;
    private String[] modalidades;
    private List<ModalidadeModel> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidade);

        modalidadePersistence = new ModalidadePersistence(getBaseContext());
        listaModalidades = findViewById(R.id.listModalidade);

        atualizarModalidade();

        listaModalidades.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builderRemover = new AlertDialog.Builder(ModalidadeActivity.this);
                builderRemover.setTitle("Remover Modalidade");
                builderRemover.setMessage("Deseja remover a modalidade?");

                builderRemover.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        modalidadePersistence.delete(m.get(position));
                        Toast.makeText(ModalidadeActivity.this, "Modalidade removida com sucesso", Toast.LENGTH_SHORT).show();
                        atualizarModalidade();
                    }
                });

                builderRemover.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        atualizarModalidade();
                    }
                });

                (dialog = builderRemover.create()).show();

                return true;
            }
        });

    }

    public void novaModalidade(View v){

        // Cria o AlertDialog.
        final AlertDialog.Builder builder = new AlertDialog.Builder(ModalidadeActivity.this);

        // Guarda a opção de inflate.
        LayoutInflater inflater = ModalidadeActivity.this.getLayoutInflater();

        // Faz a inflação do layout de configuração.
        final View viewInf = inflater.inflate(R.layout.custom_dialog_modalidades, null);
        builder.setView(viewInf);


        editTextModalidade = (EditText)viewInf.findViewById(R.id.editTextCustom);

        builder
                .setCancelable(false)
                .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        cadastrarModalidade();
                        dialog.cancel();
                        atualizarModalidade();
                    }
                })

                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialog.cancel();
                            }
                        });

        (dialog = builder.create()).show();
    }


    private void cadastrarModalidade() {
        modalidadePersistence.insert(getModalidade());
    }

    private ModalidadeModel getModalidade() {
        final String modalidade = editTextModalidade.getText().toString();
        return new ModalidadeModel(modalidade);
    }

    private void atualizarModalidade(){
        m = modalidadePersistence.getAll();
        if(m != null) {
            modalidades = new String[m.size()];

            for (int i = 0; i < m.size(); i++) {
                modalidades[i] = m.get(i).getModalidade();
            }

            ArrayAdapter<String> array = new ArrayAdapter<String>(ModalidadeActivity.this, android.R.layout.simple_list_item_1, modalidades);
            listaModalidades.setAdapter(array);
        }
    }

    public void graduacao(View view) {
        startActivity(new Intent(ModalidadeActivity.this, GraduacaoActivity.class));
    }
}
