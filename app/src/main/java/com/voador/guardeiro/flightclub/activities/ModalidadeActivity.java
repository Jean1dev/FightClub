package com.voador.guardeiro.flightclub.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.adapters.ModalidadeSpinnerAdapter2;
import com.voador.guardeiro.flightclub.infrastructure.repositories.ModalidadeRepository;
import com.voador.guardeiro.flightclub.retrofit.ApiService;
import com.voador.guardeiro.flightclub.retrofit.models.ModalidadeRetrofit;
import com.voador.guardeiro.flightclub.retrofit.services.ModalidadeService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModalidadeActivity extends BaseActivity {

    AlertDialog dialog;
    private ListView listaModalidades;
    private EditText editTextModalidade;
    private ModalidadeRepository modalidadeRepository;
    private List<ModalidadeRetrofit> modalidades = new ArrayList<ModalidadeRetrofit>();
    private ModalidadeService modalidadeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidade);

        modalidadeService = new ApiService().getModalidadeService();

        modalidadeRepository = new ModalidadeRepository(getBaseContext());
        listaModalidades = findViewById(R.id.listModalidade);

        buscarModalidade();

//        listaModalidades.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//
//                final AlertDialog.Builder builderRemover = new AlertDialog.Builder(ModalidadeActivity.this);
//                builderRemover.setTitle("Remover ModalidadeRetrofit");
//                builderRemover.setMessage("Deseja remover a modalidade?");
//
//                builderRemover.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        try {
//                            modalidadeRepository.delete(modalidades.get(position));
//                            showSuccessMessage("ModalidadeRetrofit removida com sucesso");
//                        } catch (SQLException e) {
//                            showErrorMessage("Não foi possível remover a modalidade.");
//                        }
//
//                        atualizarModalidade();
//                    }
//                });
//
//                builderRemover.setNegativeButton("Não", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        atualizarModalidade();
//                    }
//                });
//
//                (dialog = builderRemover.create()).show();
//
//                return true;
//            }
//        });
    }

    public void novaModalidade(View v) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(ModalidadeActivity.this);
        LayoutInflater inflater = ModalidadeActivity.this.getLayoutInflater();
        final View viewInf = inflater.inflate(R.layout.dialog_adicionar_modalidade, null);
        builder.setView(viewInf);

        editTextModalidade = (EditText) viewInf.findViewById(R.id.editTextCustom);

        builder
                .setCancelable(true)
                .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        try {
                            cadastrarModalidade();
                            showSuccessMessage("ModalidadeRetrofit cadastrada com sucesso");
                            dialog.cancel();
                            atualizarModalidade();
                        } catch (Exception e) {
                            showErrorMessage("Não foi possível cadastrar a modalidade.");
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

    private void cadastrarModalidade() {

        new ApiService().getModalidadeService().inserirModalidade(getModalidade()).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(retrofit2.Call<Boolean> call, Response<Boolean> response) {
                showSuccessMessage("Salvo com sucesso");
            }
            @Override
            public void onFailure(retrofit2.Call<Boolean> call, Throwable t) {
                showErrorMessage("Ocorreu um erro ao salvar o aluno");
            }
        });
    }

    private ModalidadeRetrofit getModalidade() {
        final String modalidade = editTextModalidade.getText().toString();
        return new ModalidadeRetrofit(modalidade);
    }

    private void buscarModalidade() {
        modalidadeService.buscarModalidade(22).enqueue(new Callback<List<ModalidadeRetrofit>>() {
            @Override
            public void onResponse(Call<List<ModalidadeRetrofit>> call, Response<List<ModalidadeRetrofit>> response) {
                for (final ModalidadeRetrofit modalidade : response.body()) {
                    modalidades.add(modalidade);
                }
                atualizarModalidade();
            }
            @Override
            public void onFailure(Call<List<ModalidadeRetrofit>> call, Throwable t) {
                t.printStackTrace();
                showToast("Ocorreu um erro");
            }
        });
    }


    private void atualizarModalidade() {
        if (modalidades != null) {
            listaModalidades.setAdapter(new ModalidadeSpinnerAdapter2(ModalidadeActivity.this, android.R.layout.simple_list_item_1, modalidades));
        }
    }

}
