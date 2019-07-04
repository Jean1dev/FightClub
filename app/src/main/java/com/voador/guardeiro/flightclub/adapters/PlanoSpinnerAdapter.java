package com.voador.guardeiro.flightclub.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.models.Plano;
import com.voador.guardeiro.flightclub.retrofit.models.PlanoRetrofit;

import java.util.List;

public class PlanoSpinnerAdapter extends ArrayAdapter<PlanoRetrofit> {

    private List<PlanoRetrofit> planos;

    public PlanoSpinnerAdapter(Context context,
                               int textViewResourceId,
                               List<PlanoRetrofit> planos) {
        super(context, textViewResourceId, planos);
        this.planos = planos;
    }

    @Override
    public int getCount() {
        return planos.size();
    }

    @Override
    public PlanoRetrofit getItem(int position) {
        return planos.get(position);
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
        label.setText(planos.get(position).getDs_plano());

        return label;
    }

    @Override
    public View getDropDownView(int position,
                                View convertView,
                                @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(planos.get(position).getDs_plano());

        return label;
    }
}
