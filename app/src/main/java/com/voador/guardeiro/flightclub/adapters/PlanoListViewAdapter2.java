package com.voador.guardeiro.flightclub.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.models.Plano;
import com.voador.guardeiro.flightclub.retrofit.ApiService;
import com.voador.guardeiro.flightclub.retrofit.models.ModalidadeRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.PlanoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.services.ModalidadeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanoListViewAdapter2 extends BaseAdapter {

    private ModalidadeService modalidadeService = new ApiService().getModalidadeService();
    private final List<PlanoRetrofit> planos;
    private final Activity act;

    public PlanoListViewAdapter2(List<PlanoRetrofit> planos, Activity act) {
        this.planos = planos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return planos.size();
    }

    @Override
    public Object getItem(int position) {
        return planos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_plano, parent, false);
        PlanoRetrofit planoModel = planos.get(position);


        TextView plano = view.findViewById(R.id.tituloPlano);
        TextView modalidade = view.findViewById(R.id.tituloModalidade);
        TextView valor = view.findViewById(R.id.tituloValor);


        plano.setText(planoModel.getDs_plano());
        modalidadeService.buscarModalidade(22).enqueue(new Callback<List<ModalidadeRetrofit>>() {
            @Override
            public void onResponse(Call<List<ModalidadeRetrofit>> call, Response<List<ModalidadeRetrofit>> response) {
                for (final ModalidadeRetrofit m : response.body()) {
                    if(m.getId() == planoModel.getId_modalidade()){
                        modalidade.setText(m.getNm_modalidade());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModalidadeRetrofit>> call, Throwable t) {

            }
        });
        valor.setText(planoModel.getValor().toString());

        return view;
    }
}
