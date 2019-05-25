package com.voador.guardeiro.flightclub.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.models.GraduacaoModel;

import java.util.List;

public class GraduacaoListAdapter extends BaseAdapter {

    private final List<GraduacaoModel> graduacoes;
    private final Activity act;

    public GraduacaoListAdapter(List<GraduacaoModel> graduacoes, Activity act) {
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
        View view = act.getLayoutInflater().inflate(R.layout.custom_listview_graduacoes, parent, false);
        GraduacaoModel graduacao = graduacoes.get(position);

        TextView nomeGraduacao = (TextView) view.findViewById(R.id.tituloGraduacao);
        TextView nomeModalidade = (TextView) view.findViewById(R.id.tituloModalidade);


        nomeGraduacao.setText(graduacao.getGraduacao());
        nomeModalidade.setText(graduacao.getModalidadeModel());

        return view;
    }
}
