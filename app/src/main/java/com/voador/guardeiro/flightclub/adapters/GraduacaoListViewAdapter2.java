package com.voador.guardeiro.flightclub.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.models.Graduacao;
import com.voador.guardeiro.flightclub.retrofit.ApiService;
import com.voador.guardeiro.flightclub.retrofit.models.GraduacaoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.ModalidadeRetrofit;
import com.voador.guardeiro.flightclub.retrofit.services.ModalidadeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GraduacaoListViewAdapter2 extends BaseAdapter {


    private ModalidadeService modalidadeService = new ApiService().getModalidadeService();
    private final List<GraduacaoRetrofit> graduacoes;
    private final Activity act;

    public GraduacaoListViewAdapter2(List<GraduacaoRetrofit> graduacoes, Activity act) {
        this.graduacoes = graduacoes;
        this.act = act;
    }

    @Override
    public int getCount() {
        return graduacoes.size();
    }

    @Override
    public Object getItem(int position) {
        return graduacoes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_graduacao, parent, false);
        GraduacaoRetrofit graduacao = graduacoes.get(position);

        TextView nomeGraduacao = view.findViewById(R.id.tituloGraduacao);
        TextView nomeModalidade = view.findViewById(R.id.tituloModalidade);

        nomeGraduacao.setText(graduacao.getDs_graduacao());
        modalidadeService.buscarModalidade(22).enqueue(new Callback<List<ModalidadeRetrofit>>() {
            @Override
            public void onResponse(Call<List<ModalidadeRetrofit>> call, Response<List<ModalidadeRetrofit>> response) {
                for (final ModalidadeRetrofit m : response.body()) {
                    if(m.getId() == graduacao.getId_modalidade()){
                        nomeModalidade.setText(m.getNm_modalidade());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModalidadeRetrofit>> call, Throwable t) {

            }
        });

        return view;
    }
}
