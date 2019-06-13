package com.voador.guardeiro.flightclub.retrofit;

import com.voador.guardeiro.flightclub.retrofit.services.AlunoService;
import com.voador.guardeiro.flightclub.retrofit.services.ModalidadeService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static final String BASE_URL = "http://api.m3.nextcodeapp.com.br/api/unesc/";

    private Retrofit retrofit;

    public ApiService() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public AlunoService getAlunoService() {
        return this.retrofit.create(AlunoService.class);
    }

    public ModalidadeService getModalidadeService() {
        return this.retrofit.create(ModalidadeService.class);
    }
}
