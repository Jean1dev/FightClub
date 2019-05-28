package com.voador.guardeiro.flightclub.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.adapters.ModalidadeSpinnerAdapter;
import com.voador.guardeiro.flightclub.infrastructure.repositories.ModalidadeRepository;
import com.voador.guardeiro.flightclub.models.Modalidade;

import java.util.List;

public class ModalidadeActivity extends BaseActivity {

    AlertDialog dialog;
    private ListView listaModalidades;
    private EditText editTextModalidade;
    private ModalidadeRepository modalidadeRepository;
    private List<Modalidade> modalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidade);

        modalidadeRepository = new ModalidadeRepository(getBaseContext());
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
                        modalidadeRepository.delete(modalidades.get(position));
                        showToast("Modalidade removida com sucesso");
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

    public void novaModalidade(View v) {

        // Cria o AlertDialog.
        final AlertDialog.Builder builder = new AlertDialog.Builder(ModalidadeActivity.this);

        // Guarda a opção de inflate.
        LayoutInflater inflater = ModalidadeActivity.this.getLayoutInflater();

        // Faz a inflação do layout de configuração.
        final View viewInf = inflater.inflate(R.layout.dialog_adicionar_modalidade, null);
        builder.setView(viewInf);


        editTextModalidade = (EditText) viewInf.findViewById(R.id.editTextCustom);

        builder
                .setCancelable(true)
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
        modalidadeRepository.insert(getModalidade());
    }

    private Modalidade getModalidade() {
        final String modalidade = editTextModalidade.getText().toString();
        return new Modalidade(modalidade);
    }

    private void atualizarModalidade() {
        modalidades = modalidadeRepository.getAll();
        if (modalidades != null) {
            listaModalidades.setAdapter(new ModalidadeSpinnerAdapter(ModalidadeActivity.this, android.R.layout.simple_list_item_1, modalidades));
        }
    }

}
