package com.voador.guardeiro.flightclub.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.models.Plano;

import java.util.List;

public class PlanoListViewAdapter extends BaseAdapter {

    private final List<Plano> planos;
    private final Activity act;

    public PlanoListViewAdapter(List<Plano> planos, Activity act) {
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
        Plano planoModel = planos.get(position);


        TextView plano = view.findViewById(R.id.tituloPlano);
        TextView valor = view.findViewById(R.id.tituloValor);


        plano.setText(planoModel.getDescricao());
        valor.setText(planoModel.getValor().toString());

        return view;
    }
}
