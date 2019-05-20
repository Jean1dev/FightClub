package com.voador.guardeiro.flightclub;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import database.model.PlanosModel;

public class CustomAdapterPlanos extends BaseAdapter {

    private final List<PlanosModel> planos;
    private final Activity act;

    public CustomAdapterPlanos(List<PlanosModel> planos, Activity act) {
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
        View view = act.getLayoutInflater().inflate(R.layout.custom_listview_planos, parent, false);
        PlanosModel planoModel = planos.get(position);


        TextView plano = (TextView) view.findViewById(R.id.tituloPlano);
        TextView modalidade = (TextView) view.findViewById(R.id.tituloModalidade);
        TextView valor = (TextView) view.findViewById(R.id.tituloValor);


        plano.setText(planoModel.getPlano());
        modalidade.setText(planoModel.getModalidade());
        valor.setText(planoModel.getValor().toString());

        return view;
    }
}
