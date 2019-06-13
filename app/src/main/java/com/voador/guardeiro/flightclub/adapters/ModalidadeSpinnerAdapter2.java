package com.voador.guardeiro.flightclub.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.models.Modalidade;
import com.voador.guardeiro.flightclub.retrofit.models.ModalidadeRetrofit;

import java.util.List;

public class ModalidadeSpinnerAdapter2 extends ArrayAdapter<ModalidadeRetrofit> {

    private List<ModalidadeRetrofit> modalidades;

    public ModalidadeSpinnerAdapter2(Context context,
                                     int textViewResourceId,
                                     List<ModalidadeRetrofit> modalidades) {
        super(context, textViewResourceId, modalidades);
        this.modalidades = modalidades;
    }

    @Override
    public int getCount() {
        return modalidades.size();
    }

    @Override
    public ModalidadeRetrofit getItem(int position) {
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
        label.setText(modalidades.get(position).getNm_modalidade());

        return label;
    }

    @Override
    public View getDropDownView(int position,
                                View convertView,
                                @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(modalidades.get(position).getNm_modalidade());

        return label;
    }
}
