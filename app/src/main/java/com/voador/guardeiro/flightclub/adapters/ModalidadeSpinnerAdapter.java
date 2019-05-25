package com.voador.guardeiro.flightclub.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.models.Modalidade;

import java.util.List;

public class ModalidadeSpinnerAdapter extends ArrayAdapter<Modalidade> {

    private List<Modalidade> modalidades;

    public ModalidadeSpinnerAdapter(Context context,
                                    int textViewResourceId,
                                    List<Modalidade> modalidades) {
        super(context, textViewResourceId, modalidades);
        this.modalidades = modalidades;
    }

    @Override
    public int getCount() {
        return modalidades.size();
    }

    @Override
    public Modalidade getItem(int position) {
        return modalidades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(modalidades.get(position).getDescricao());

        return label;
    }

    @Override
    public View getDropDownView(int position,
                                View convertView,
                                @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(modalidades.get(position).getDescricao());

        return label;
    }
}
