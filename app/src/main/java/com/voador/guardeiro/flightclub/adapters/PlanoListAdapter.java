package com.voador.guardeiro.flightclub.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.models.PlanoModel;

import java.util.List;

public class PlanoListAdapter extends BaseAdapter {

    private final List<PlanoModel> planos;
    private final Activity act;

    public PlanoListAdapter(List<PlanoModel> planos, Activity act) {
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
        PlanoModel planoModel = planos.get(position);


        TextView plano = view.findViewById(R.id.tituloPlano);
        TextView modalidade = view.findViewById(R.id.tituloModalidade);
        TextView valor = view.findViewById(R.id.tituloValor);


        plano.setText(planoModel.getPlano());
        modalidade.setText(planoModel.getModalidade());
        valor.setText(planoModel.getValor().toString());

        return view;
    }
}
