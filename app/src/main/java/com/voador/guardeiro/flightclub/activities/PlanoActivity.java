package com.voador.guardeiro.flightclub.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.adapters.ModalidadeSpinnerAdapter;
import com.voador.guardeiro.flightclub.adapters.ModalidadeSpinnerAdapter2;
import com.voador.guardeiro.flightclub.adapters.PlanoListViewAdapter;
import com.voador.guardeiro.flightclub.adapters.PlanoListViewAdapter2;
import com.voador.guardeiro.flightclub.infrastructure.repositories.ModalidadeRepository;
import com.voador.guardeiro.flightclub.infrastructure.repositories.PlanoRepository;
import com.voador.guardeiro.flightclub.models.Modalidade;
import com.voador.guardeiro.flightclub.models.Plano;
import com.voador.guardeiro.flightclub.retrofit.ApiService;
import com.voador.guardeiro.flightclub.retrofit.models.ModalidadeRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.PlanoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.services.ModalidadeService;
import com.voador.guardeiro.flightclub.retrofit.services.PlanoService;
import com.voador.guardeiro.flightclub.utils.MoneyTextWatcher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanoActivity extends BaseActivity {

    AlertDialog dialog;
    private ListView listViewPlanos;
    private String[] planos;
    private List<PlanoRetrofit> listaPlanoModel = new ArrayList<PlanoRetrofit>();
    private EditText editTextPlanos;
    private EditText valor;
    private Spinner todasModalidades;
    private TextView titulo;

    private ModalidadeService modalidadeService;
    private PlanoService planoService;
    private List<ModalidadeRetrofit> modalidades =  new ArrayList<ModalidadeRetrofit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planos);
        listViewPlanos = findViewById(R.id.listPlanos);

        modalidadeService = new ApiService().getModalidadeService();
        planoService = new ApiService().getPlanoService();

        atualizarPlanos();

        listViewPlanos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builderRemover = new AlertDialog.Builder(PlanoActivity.this);
                builderRemover.setTitle("Remover Plano");
                builderRemover.setMessage("Deseja remover o plano?");

                builderRemover.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        try {
                            planoService.excluirPlano(listaPlanoModel.get(position).getId()).enqueue(new Callback<Boolean>() {
                                @Override
                                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                    showSuccessMessage("Plano removida com sucesso");
                                }

                                @Override
                                public void onFailure(Call<Boolean> call, Throwable t) {
                                    showErrorMessage("Não foi possível remover o plano.");

                                }
                            });
                        } catch (Exception e) {
                            System.out.println(e);
                        }

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

                final PlanoRetrofit plano = listaPlanoModel.get(position);
                final AlertDialog.Builder builder = new AlertDialog.Builder(PlanoActivity.this);
                LayoutInflater inflater = PlanoActivity.this.getLayoutInflater();
                final View viewInf = inflater.inflate(R.layout.dialog_adicionar_plano, null);
                builder.setView(viewInf);

                titulo = viewInf.findViewById(R.id.dialogTitle);
                editTextPlanos = viewInf.findViewById(R.id.editTextCustom);
                valor = viewInf.findViewById(R.id.editTextValor);
                todasModalidades = viewInf.findViewById(R.id.todasModalidades);
                valor.addTextChangedListener(new MoneyTextWatcher(valor));

                titulo.setText("Atualizar planos");

                editTextPlanos.setText(plano.getDs_plano());
                valor.setText(plano.getValor().toString());
                getModalidades();

                builder
                        .setCancelable(true)
                        .setPositiveButton("Atualizar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                try {
                                    inserirPlano(plano);
                                    showSuccessMessage("Plano atualizaco com sucesso");
                                    dialog.cancel();
                                } catch (Exception e) {
                                    showErrorMessage("Erro ao atualizar plano");
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
        });

    }

    public void novoPlano(View v) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(PlanoActivity.this);
        LayoutInflater inflater = PlanoActivity.this.getLayoutInflater();
        final View viewInf = inflater.inflate(R.layout.dialog_adicionar_plano, null);
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
                        try {
                            cadastrarPlano();
                            atualizarPlanos();
                            dialog.cancel();
                        } catch (Exception e) {}
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
        final String value = valor.getText().toString().replaceAll("[^\\d\\,]", "").replaceFirst("[,]", ".");

        final PlanoRetrofit plano = new PlanoRetrofit();
        plano.setId_modalidade(4L);
        plano.setValor(Double.parseDouble(value));
        plano.setDs_plano(editTextPlanos.getText().toString());
        plano.setDhinc(new Date());
        plano.setIdConta(22L);

        inserirPlano(plano);
    }

    private void inserirPlano(PlanoRetrofit plano) {
        planoService.inserirPlano(plano).enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                showSuccessMessage("Salvo com sucesso");
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                showErrorMessage("Ocorreu um erro ao salvar o plano");
            }
        });
    }

    public Plano updatePlano(Plano plano) {
        plano.setModalidade((Modalidade) todasModalidades.getSelectedItem());
        plano.setDescricao(editTextPlanos.getText().toString());
        plano.setValor(Double.parseDouble(valor.getText().toString().replaceAll("[^\\d\\,]", "").replaceFirst("[,]", ".")));
        return plano;
    }

    private void atualizarPlanos() {
         planoService.buscarTodos(22L, 4L).enqueue(new Callback<List<PlanoRetrofit>>() {
            @Override
            public void onResponse(Call<List<PlanoRetrofit>> call, Response<List<PlanoRetrofit>> response) {
                for (final PlanoRetrofit plano : response.body()) {
                    if(plano != null) {
                        listaPlanoModel.add(plano);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<PlanoRetrofit>> call, Throwable t) {
                t.printStackTrace();
                showToast("Ocorreu um erro");
            }
        });

        if (listaPlanoModel != null) {
            PlanoListViewAdapter2 adapter = new PlanoListViewAdapter2(listaPlanoModel, this);
            listViewPlanos.setAdapter(adapter);
        }
    }

    private void getModalidades() {

            modalidades.clear();
            modalidadeService.buscarModalidade(22).enqueue(new Callback<List<ModalidadeRetrofit>>() {
                @Override
                public void onResponse(Call<List<ModalidadeRetrofit>> call, Response<List<ModalidadeRetrofit>> response) {
                    for (final ModalidadeRetrofit modalidade : response.body()) {
                        modalidades.add(modalidade);
                    }
                }
                @Override
                public void onFailure(Call<List<ModalidadeRetrofit>> call, Throwable t) {
                    t.printStackTrace();
                    showToast("Ocorreu um erro");
                }
            });

        if (modalidades != null) {

            ModalidadeSpinnerAdapter2 array = new ModalidadeSpinnerAdapter2(this, android.R.layout.simple_spinner_item, modalidades);
            array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            todasModalidades.setAdapter(array);
        }
    }
}
