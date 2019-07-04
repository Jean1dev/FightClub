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
import com.voador.guardeiro.flightclub.adapters.GraduacaoListViewAdapter2;
import com.voador.guardeiro.flightclub.adapters.ModalidadeSpinnerAdapter2;
import com.voador.guardeiro.flightclub.retrofit.ApiService;
import com.voador.guardeiro.flightclub.retrofit.models.GraduacaoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.ModalidadeRetrofit;
import com.voador.guardeiro.flightclub.retrofit.services.GraduacaoService;
import com.voador.guardeiro.flightclub.retrofit.services.ModalidadeService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GraduacaoActivity extends BaseActivity {

    AlertDialog dialog;
    private ListView listViewGraduacoes;
    private EditText editTextGraduacoes;
    private List<GraduacaoRetrofit> listaGraduacao = new ArrayList<GraduacaoRetrofit>();
    private List<ModalidadeRetrofit> listaModalidades;
    private String[] graduacoes;
    private Spinner todasModalidades;
    private TextView textViewModalidades;


    private ModalidadeService modalidadeService = new ApiService().getModalidadeService();
    private GraduacaoService graduacaoService = new ApiService().getGraduacaoService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduacao);

        listViewGraduacoes = findViewById(R.id.listGraduacoes);

        getModalidades();
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
                            graduacaoService.excluirPlano(listaGraduacao.get(position).getId());
                            showSuccessMessage("Graduacão removida com sucesso");
                        } catch (Exception e) {
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
                            showSuccessMessage("Graduação cadastrada com sucesso");
                            dialog.cancel();
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

    private void cadastrarGraduacao() {
        graduacaoService.inserirGraduacao(getGraduacao());
    }

    private void atualizarGraduacoes() {
        listaGraduacao.clear();

        graduacaoService.buscarTodos(22L,22L).enqueue(new Callback<List<GraduacaoRetrofit>>() {
            @Override
            public void onResponse(Call<List<GraduacaoRetrofit>> call, Response<List<GraduacaoRetrofit>> response) {
                for (final GraduacaoRetrofit graduacao : response.body()) {
                    if(graduacao != null)
                    listaGraduacao.add(graduacao);
                }
            }

            @Override
            public void onFailure(Call<List<GraduacaoRetrofit>> call, Throwable t) {

            }
        });
        if (listaGraduacao != null) {
            graduacoes = new String[listaGraduacao.size()];

            for (int i = 0; i < listaGraduacao.size(); i++) {
                graduacoes[i] = listaGraduacao.get(i).getDs_graduacao();
            }


            GraduacaoListViewAdapter2 adapter = new GraduacaoListViewAdapter2(listaGraduacao, this);
            listViewGraduacoes.setAdapter(adapter);
        }
    }

    private GraduacaoRetrofit getGraduacao() {
        try {
            final String descricao = editTextGraduacoes.getText().toString();
            final ModalidadeRetrofit modalidade = (ModalidadeRetrofit)todasModalidades.getSelectedItem();
            return new GraduacaoRetrofit(descricao, modalidade);
        } catch (Exception e) {
            showErrorMessage("Erro ao inserir graduação", "Preencha todos os campos");
            return null;
        }

    }


        private void getModalidades() {
            modalidadeService.buscarModalidade(22).enqueue(new Callback<List<ModalidadeRetrofit>>() {
                @Override
                public void onResponse(Call<List<ModalidadeRetrofit>> call, Response<List<ModalidadeRetrofit>> response) {
                    listaModalidades = response.body();
                }
                @Override
                public void onFailure(Call<List<ModalidadeRetrofit>> call, Throwable t) {
                    t.printStackTrace();
                    showToast("Ocorreu um erro");
                }
            });


            if (listaModalidades != null) {

                ModalidadeSpinnerAdapter2 array = new ModalidadeSpinnerAdapter2(this, android.R.layout.simple_spinner_item, listaModalidades);
                array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                todasModalidades.setAdapter(array);

            }
        }
}

