package com.voador.guardeiro.flightclub.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.models.Graduacao;

import java.util.List;

public class GraduacaoListViewAdapter extends BaseAdapter {

    private final List<Graduacao> graduacoes;
    private final Activity act;

    public GraduacaoListViewAdapter(List<Graduacao> graduacoes, Activity act) {
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
        Graduacao graduacao = graduacoes.get(position);

        TextView nomeGraduacao = view.findViewById(R.id.tituloGraduacao);
        TextView nomeModalidade = view.findViewById(R.id.tituloModalidade);

        nomeGraduacao.setText(graduacao.getDescricao());
        nomeModalidade.setText(graduacao.getModalidade().getDescricao());

        return view;
    }
}
