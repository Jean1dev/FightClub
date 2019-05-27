package com.voador.guardeiro.flightclub.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.models.MatriculaModalidade;

import java.util.List;

public class MatriculaListViewAdapter extends BaseAdapter {

    private final List<MatriculaModalidade> matriculas;
    private final Activity act;

    public MatriculaListViewAdapter(List<MatriculaModalidade> matriculas, Activity act) {
        this.matriculas = matriculas;
        this.act = act;
    }

    @Override
    public int getCount() {
        return matriculas.size();
    }

    @Override
    public Object getItem(int position) {
        return matriculas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_matricula, parent, false);
        MatriculaModalidade matricula = matriculas.get(position);

        TextView nomeAluno = view.findViewById(R.id.text_aluno);
        TextView nomePlano = view.findViewById(R.id.text_plano);

        nomeAluno.setText(matricula.getAluno().getNome());
        nomePlano.setText(matricula.getPlano().getDescricao());

        return view;
    }
}
