package com.voador.guardeiro.flightclub.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.adapters.GraduacaoListViewAdapter;
import com.voador.guardeiro.flightclub.adapters.ModalidadeSpinnerAdapter;
import com.voador.guardeiro.flightclub.infrastructure.repositories.GraduacaoRepository;
import com.voador.guardeiro.flightclub.infrastructure.repositories.ModalidadeRepository;
import com.voador.guardeiro.flightclub.models.Graduacao;
import com.voador.guardeiro.flightclub.models.Modalidade;

import java.sql.SQLException;
import java.util.List;


public class GraduacaoActivity extends BaseActivity {

    AlertDialog dialog;
    private ListView listViewGraduacoes;
    private EditText editTextGraduacoes;
    private GraduacaoRepository graduacaoRepository;
    private ModalidadeRepository modalidadeRepository;
    private List<Graduacao> listaGraduacao;
    private List<Modalidade> listaModalidades;
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
                        try {
                            graduacaoRepository.delete(listaGraduacao.get(position));
                            showSuccessMessage("Graduacão removida com sucesso");
                        } catch (SQLException e) {
                            showErrorMessage("Não foi possível remover a graduação.");
                        }

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
        final View viewInf = inflater.inflate(R.layout.dialog_adicionar_graduacao, null);
        builder.setView(viewInf);

        todasModalidades = viewInf.findViewById(R.id.todasModalidades);
        editTextGraduacoes = viewInf.findViewById(R.id.editTextCustom);
        textViewModalidades = viewInf.findViewById(R.id.textViewGraduacao);
        getModalidades();

        builder
                .setCancelable(true)
                .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        try {
                            cadastrarGraduacao();
                            dialog.cancel();
                            showSuccessMessage("Graduação cadastrada com sucesso");
                            atualizarGraduacoes();
                        } catch (Exception e) {
                            showErrorMessage("Erro ao cadastrar graduação");
                        }
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

    private void atualizarGraduacoes() {
        listaGraduacao = graduacaoRepository.getAll();
        if (listaGraduacao != null) {
            graduacoes = new String[listaGraduacao.size()];

            for (int i = 0; i < listaGraduacao.size(); i++) {
                graduacoes[i] = listaGraduacao.get(i).getDescricao();
            }


            GraduacaoListViewAdapter adapter = new GraduacaoListViewAdapter(listaGraduacao, this);
            listViewGraduacoes.setAdapter(adapter);
        }
    }

    private Graduacao getGraduacao() {
        try {
            final String descricao = editTextGraduacoes.getText().toString();
            final Modalidade modalidade = (Modalidade) todasModalidades.getSelectedItem();
            return new Graduacao(descricao, modalidade);
        } catch (Exception e) {
            showErrorMessage("Erro ao inserir graduação", "Preencha todos os campos");
            return null;
        }

    }

    private void cadastrarGraduacao() {
        graduacaoRepository.insert(getGraduacao());
    }

    private void getModalidades() {
        listaModalidades = modalidadeRepository.getAll();
        if (listaModalidades != null) {

            ModalidadeSpinnerAdapter array = new ModalidadeSpinnerAdapter(this, android.R.layout.simple_spinner_item, listaModalidades);
            array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            todasModalidades.setAdapter(array);
        }
    }
}

