package com.voador.guardeiro.flightclub;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import database.model.ModalidadeModel;
import database.model.Persistence.ModalidadePersistence;
import database.model.Persistence.PlanosPersistence;
import database.model.PlanosModel;
import utils.MoneyTextWatcher;

public class PlanosActivity extends AppCompatActivity {

    private ListView listViewPlanos;
    private PlanosPersistence planosPersistence;
    AlertDialog dialog;
    private String[] planos;
    private List<PlanosModel> listaPlanosModel;
    private EditText editTextPlanos;
    private EditText valor;
    private Spinner todasModalidades;
    private TextView titulo;

    private ModalidadePersistence modalidadePersistence;
    private List<ModalidadeModel> listaModalidades;
    private String[] modalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planos);
        planosPersistence = new PlanosPersistence(getBaseContext());
        modalidadePersistence = new ModalidadePersistence(getBaseContext());
        listViewPlanos = findViewById(R.id.listPlanos);

        atualizarPlanos();

        listViewPlanos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builderRemover = new AlertDialog.Builder(PlanosActivity.this);
                builderRemover.setTitle("Remover Plano");
                builderRemover.setMessage("Deseja remover o plano?");

                builderRemover.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        planosPersistence.delete(listaPlanosModel.get(position));
                        Toast.makeText(PlanosActivity.this, "Modalidade removida com sucesso", Toast.LENGTH_SHORT).show();
                        atualizarPlanos();
                    }
                });

                builderRemover.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        atualizarPlanos();
                    }
                });

                (dialog = builderRemover.create()).show();

                return true;
            }
        });

        listViewPlanos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 final PlanosModel plano = listaPlanosModel.get(position);

                final AlertDialog.Builder builder = new AlertDialog.Builder(PlanosActivity.this);

                LayoutInflater inflater = PlanosActivity.this.getLayoutInflater();

                final View viewInf = inflater.inflate(R.layout.custom_dialog_planos, null);
                builder.setView(viewInf);

                titulo = (TextView) viewInf.findViewById(R.id.dialogTitle);
                editTextPlanos = (EditText) viewInf.findViewById(R.id.editTextCustom);
                valor = (EditText) viewInf.findViewById(R.id.editTextValor);
                todasModalidades = (Spinner) viewInf.findViewById(R.id.todasModalidades);
                valor.addTextChangedListener(new MoneyTextWatcher(valor));

                titulo.setText("Atualizar planos");

                editTextPlanos.setText(plano.getPlano());
                valor.setText(plano.getValor().toString());
                getModalidades();

                builder
                        .setCancelable(true)
                        .setPositiveButton("Atualizar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                planosPersistence.update(updatePlano(plano));
                                dialog.cancel();
                                atualizarPlanos();
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
        });

}

    public void novoPlano(View v) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(PlanosActivity.this);

        LayoutInflater inflater = PlanosActivity.this.getLayoutInflater();

        final View viewInf = inflater.inflate(R.layout.custom_dialog_planos, null);
        builder.setView(viewInf);


        editTextPlanos = (EditText) viewInf.findViewById(R.id.editTextCustom);
        valor = (EditText) viewInf.findViewById(R.id.editTextValor);
        todasModalidades = (Spinner) viewInf.findViewById(R.id.todasModalidades);
        valor.addTextChangedListener(new MoneyTextWatcher(valor));

        getModalidades();

        builder
                .setCancelable(true)
                .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        cadastrarPlano();
                        dialog.cancel();
                        atualizarPlanos();
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


    private void cadastrarPlano() {
        planosPersistence.insert(getPlano());
    }

    public PlanosModel updatePlano(PlanosModel plano) {
        plano.setModalidade(todasModalidades.getSelectedItem().toString());
        plano.setPlano(editTextPlanos.getText().toString());
        plano.setValor(Double.parseDouble(valor.getText().toString().replaceAll("[^\\d\\,]", "").replaceFirst("[,]", ".")));
        return plano;
    }

    private PlanosModel getPlano() {
        try {
            final String plano = editTextPlanos.getText().toString();
            final String modalidade = todasModalidades.getSelectedItem().toString();
            final Double preco = Double.parseDouble(valor.getText().toString().replaceAll("[^\\d\\,]", "").replaceFirst("[,]", "."));
            return new PlanosModel(modalidade, plano, preco);
        } catch (Exception e){
            Toast.makeText(PlanosActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

            return null;
        }

    }

    private void atualizarPlanos() {
        listaPlanosModel = planosPersistence.getAll();
        if (listaPlanosModel != null) {
            planos = new String[listaPlanosModel.size()];

            for (int i = 0; i < listaPlanosModel.size(); i++) {
                planos[i] = listaPlanosModel.get(i).getPlano();
            }

            CustomAdapterPlanos adapter = new CustomAdapterPlanos(listaPlanosModel, this);

            listViewPlanos.setAdapter(adapter);
        }
    }

    private void getModalidades() {
        listaModalidades = modalidadePersistence.getAll();
        if (listaModalidades != null) {
            modalidades = new String[listaModalidades.size()];

            for (int i = 0; i < listaModalidades.size(); i++) {
                modalidades[i] = listaModalidades.get(i).getModalidade();
            }

            ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, modalidades);
            array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            todasModalidades.setAdapter(array);
        }
    }
}
