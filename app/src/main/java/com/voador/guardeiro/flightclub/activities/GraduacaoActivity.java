package com.voador.guardeiro.flightclub.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.adapters.GraduacaoListAdapter;
import com.voador.guardeiro.flightclub.infrastructure.repositories.GraduacaoRepository;
import com.voador.guardeiro.flightclub.infrastructure.repositories.ModalidadeRepository;
import com.voador.guardeiro.flightclub.models.GraduacaoModel;
import com.voador.guardeiro.flightclub.models.ModalidadeModel;

import java.util.List;


public class GraduacaoActivity extends AppCompatActivity {

    private ListView listViewGraduacoes;
    private EditText editTextGraduacoes;
    AlertDialog dialog;
    private GraduacaoRepository graduacaoRepository;
    private ModalidadeRepository modalidadeRepository;
    private List<GraduacaoModel> listaGraduacao;
    private List<ModalidadeModel> listaModalidades;
    private String[] graduacoes;
    private String[] modalidades;
    private Spinner todasModalidades;
    private TextView textViewModalidades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduacao);

        graduacaoRepository = new GraduacaoRepository(getBaseContext());
        modalidadeRepository = new ModalidadeRepository(getBaseContext());
        listViewGraduacoes = findViewById(R.id.listGraduacoes);

        atualizarGraduacoes();

        listViewGraduacoes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builderRemover = new AlertDialog.Builder(GraduacaoActivity.this);
                builderRemover.setTitle("Remover Graduacão");
                builderRemover.setMessage("Deseja remover a graduacão?");

                builderRemover.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        graduacaoRepository.delete(listaGraduacao.get(position));
                        Toast.makeText(GraduacaoActivity.this, "Graduacão removida com sucesso", Toast.LENGTH_SHORT).show();
                        atualizarGraduacoes();
                    }
                });

                builderRemover.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        atualizarGraduacoes();
                    }
                });

                (dialog = builderRemover.create()).show();

                return true;
            }
        });

    }

    public void novaGraduacao(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(GraduacaoActivity.this);

        // Guarda a opção de inflate.
        LayoutInflater inflater = GraduacaoActivity.this.getLayoutInflater();

        // Faz a inflação do layout de configuração.
        final View viewInf = inflater.inflate(R.layout.custom_dialog_graduacoes, null);
        builder.setView(viewInf);


        todasModalidades = (Spinner)viewInf.findViewById(R.id.todasModalidades);
        editTextGraduacoes = (EditText)viewInf.findViewById(R.id.editTextCustom);
        textViewModalidades = (TextView) viewInf.findViewById(R.id.textViewGraduacao);
        getModalidades();

        builder
                .setCancelable(true)
                .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        cadastrarGraduacao();
                        dialog.cancel();
                        atualizarGraduacoes();
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

    private void atualizarGraduacoes(){
        listaGraduacao = graduacaoRepository.getAll();
        if(listaGraduacao != null) {
            graduacoes = new String[listaGraduacao.size()];

            for (int i = 0; i < listaGraduacao.size(); i++) {
                graduacoes[i] = listaGraduacao.get(i).getGraduacao();
            }


            GraduacaoListAdapter adapter = new GraduacaoListAdapter(listaGraduacao, this);
            listViewGraduacoes.setAdapter(adapter);
        }
    }

    private GraduacaoModel getGraduacao() {
        try {
            final String graduacao = editTextGraduacoes.getText().toString();
            final String modalidade = todasModalidades.getSelectedItem().toString();
            return new GraduacaoModel(graduacao, modalidade);
        } catch (Exception e){
            Toast.makeText(GraduacaoActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }

    return null;
    }

    private void cadastrarGraduacao() {
        graduacaoRepository.insert(getGraduacao());
    }

    private void getModalidades(){
        listaModalidades = modalidadeRepository.getAll();
        if(listaModalidades != null) {
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

